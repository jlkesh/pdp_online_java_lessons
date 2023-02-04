
# ForkJoin Framework
````java
package uz.pdp.forkjoin;

import java.util.concurrent.RecursiveTask;

public class CounterRecursiveTask extends RecursiveTask<Integer> {

    private double[] numbers;
    private int from;
    private int to;
    private int limit = 1000;

    public CounterRecursiveTask(double[] numbers, int from, int to) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        if ( to - from < limit ) {
            int count = 0;
            for ( int i = from; i < to; i++ ) {
                if ( numbers[i] > 0.3 ) {
                    count++;
                }
            }
            return count;
        } else {
            int mid = from + ( to - from ) / 2;
            CounterRecursiveTask first = new CounterRecursiveTask(numbers, from, mid);
            CounterRecursiveTask second = new CounterRecursiveTask(numbers, mid, to);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
````


````java
package uz.pdp.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {
    public static void main(String[] args) {
        int size = 500_000_000;
        double[] arr = new double[size];
        for ( int i = 0; i < size; i++ ) {
            arr[i] = Math.random();
        }
        // 0.2 > 0
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CounterRecursiveTask counterRecursiveTask = new CounterRecursiveTask(arr, 0, size);

        long begin = System.currentTimeMillis();
        forkJoinPool.invoke(counterRecursiveTask);
        Integer join = counterRecursiveTask.join();
        long end = System.currentTimeMillis();
        System.out.println(join + "::" + ( end - begin ));

        begin = System.currentTimeMillis();
        join = 0;
        for ( int i = 0; i < size; i++ ) {
            if ( arr[i] > 0.3 ) join++;
        }
        end = System.currentTimeMillis();
        System.out.println(join + "::" + ( end - begin ));
    }
}
````

# CompletableFuture

````java
package uz.pdp.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("CompletableFuture Completed");
        System.out.println(completableFuture.get());*/
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        /*CompletableFuture.runAsync(() -> {
            System.out.println("Running on Thread::" + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello From RunAsync");
        }, executorService)*/

        /*register();
        System.out.println(returnSuccessMessage());
        for (int i = 0; i < 10; i++) {
            System.out.println("Message " + i);
            Thread.sleep(20);
        }*/

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Value from completableFuture";
            }
        }, executorService);

        System.out.println(completableFuture.get()); // block

    }

    private static String returnSuccessMessage() throws InterruptedException {
        Thread.sleep(500);
        return "Successfully registered please check your inbox";
    }

    private static void register() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture.runAsync(() -> {
            System.out.println("User data sent to database::" + Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("User data saved to database::" + Thread.currentThread());
        }, executor);

        CompletableFuture.runAsync(() -> {
            System.out.println("Email Sending::" + Thread.currentThread());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Email sent::" + Thread.currentThread());
        }, executor);
    }
}
````


````java
package uz.pdp.completablefuture;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;

public class ThenApplyThenAcceptThenRunExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // thenApply
        //method1();
        //method2(executor);
        // method3();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> errorMessage = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            if (random.nextBoolean()) {
                throw new RuntimeException("Error Message");
            }
            return 12 / 4;
        }).handle((number, ex) -> {
            if (ex != null) {
                System.out.println("Error :: " + ex.getMessage());
                return -1;
            } else {
                System.out.println("Response Successfully returned");
                return number;
            }
        });
        System.out.println(errorMessage.get());

    }

    private static void method3() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> errorMessage = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            if (random.nextBoolean()) {
                throw new RuntimeException("Error Message");
            }
            return 12 / 4;
        }).exceptionally(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) {
                System.out.println("Error :: " + throwable.getMessage());
                return -1;
            }
        });
        System.out.println(errorMessage.get());
    }

    private static void method2(ExecutorService executor) throws InterruptedException {
        // ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread());
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Javohir";
                }, executor)
                .thenApplyAsync((name) -> {
                    System.out.println(Thread.currentThread());
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Elmurodov " + name;
                }, executor)
                .thenAcceptAsync((fullName) -> {
                            System.out.println(Thread.currentThread());
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("FullName:" + fullName);
                        }, executor
                ).thenRunAsync(() -> {
                    System.out.println(Thread.currentThread());
                    System.out.println("................Bye................");
                }, executor);

        Thread.sleep(2000);
    }

    private static void method1() {
        CompletableFuture<String> myNameCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Javohir";
        });

        CompletableFuture<String> fullNameCompletableFuture = myNameCompletableFuture.thenApply((name) -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Elmurodov " + name;
        });


        CompletableFuture<Void> voidCompletableFuture = fullNameCompletableFuture.thenAccept((fullName) -> {
                    System.out.println("FullName:" + fullName);
                }
        );

        voidCompletableFuture.thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("................Bye................");
            }
        });
    }
}
````

# Singleton
````java
package uz.pdp.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
````


````java
package uz.pdp.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for ( int i = 0; i < 500; i++ )
            executorService.execute(() -> System.out.println(System.identityHashCode(Singleton.getInstance())));
    }
}
````
