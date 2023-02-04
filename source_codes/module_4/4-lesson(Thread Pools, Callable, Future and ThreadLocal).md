# Thread Pools
````java
package uz.pdp.threadpool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // register user
        registerNewUser();
    }

    private static void registerNewUser() {
        // database save
        saveUserToDatabase();
        // generate template
        generateTemplate();
        // send over network
        sendMail();
        System.out.println("....................");
    }

    public static void saveUserToDatabase(/*user data input*/) {
        Runnable runnable = () -> {
            try {
                System.out.println("Saving to database..........");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("User saved to database..........");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(runnable).start();
    }

    public static void generateTemplate(/*user data input*/) {
        Runnable runnable = () -> {
            try {
                System.out.println("Generating Template..........");
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("Template generated..........");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(runnable).start();
    }

    public static void sendMail(/*user data input*/) {
        Runnable runnable = () -> {
            try {
                System.out.println("Connecting to smtp server..........");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Mail sent..........");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(runnable).start();
    }
}
````


````java
package uz.pdp.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        m1();
        // m2();

    }

    private static void m2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        // scheduledExecutorService.schedule(() -> System.out.println("Time is " + new Date()), 2, TimeUnit.SECONDS);
        /* scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("Time is " + new Date()),
                2, 1,
                TimeUnit.SECONDS);

         */
        scheduledExecutorService.scheduleWithFixedDelay(
                () -> {
                    System.out.println("Time is " + new Date());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                2, 1,
                TimeUnit.SECONDS);
    }

    private static void m1() throws InterruptedException {
        int a = 12;
        // ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            final int taskID = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(2000);
                    System.out.printf(Thread.currentThread() + "::" + "Task executing (task number is %d)|Tread count : %d|%n", taskID, Thread.activeCount());
                } catch (InterruptedException e) {
                }
            };
            executorService.submit(runnable);
        }
        // executorService.shutdown();
        // executorService.execute(() -> System.out.println("Reject task"));
        // System.out.println(executorService.awaitTermination(3, TimeUnit.SECONDS));
        // executorService.shutdownNow();
        executorService.shutdown();
        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Shutting down");
            executorService.shutdownNow();
        }
    }
}
````

````java
package uz.pdp.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        // fixed(availableProcessors);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for ( int i = 0; i < 10000; i++ )
            executorService.execute(() -> {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        Thread.sleep(1000);
        System.out.println(Thread.activeCount() - 2);
        Thread.sleep(60_000);
        System.out.println(Thread.activeCount() - 2);
    }

    private static void fixed(int availableProcessors) {
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        for ( int i = 0; i < 1000; i++ )
            executorService.execute(() -> {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        System.out.println(Thread.activeCount());
    }
}
````


````java
package uz.pdp.threadpools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        // executorService.schedule(() -> System.out.println("Hello PDP"), 2, TimeUnit.SECONDS);
        /*executorService.scheduleAtFixedRate(() ->
                {
                    System.out.println("Hello PDP");
                },
                2, 1, TimeUnit.SECONDS);*/

        SimpleDateFormat smdf = new SimpleDateFormat("HH:mm:ss");
        executorService.scheduleWithFixedDelay(() ->
                {
                    System.out.print("\r" + smdf.format(new Date()));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                2, 1, TimeUnit.SECONDS);
    }
}
````

````java
package uz.pdp.threadpools;

import java.util.concurrent.*;

public class CustomThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(
                10, 1000, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue<>()
        );
        for ( int i = 0; i < 1000; i++ )
            executorService.execute(() -> {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            });
        executorService.shutdown();
        if ( !executorService.awaitTermination(30, TimeUnit.MILLISECONDS) ) {
            executorService.shutdownNow();
        }
        // executorService.execute(()-> System.out.println("Main task"));
    }
}
````
# Callable
````java
package uz.pdp.callable;

import java.util.concurrent.*;

public class CallableNeedingExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // uzcard to humo
        // sender to receiver
        // sender check // parallel // 2s -> true/false new Thread(test sender).start()
        // receiver check // parallel // 2s -> true/false new Thread(test receiver).start()
        // transfer

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long begin = System.currentTimeMillis();

        Callable<Boolean> checkUzcardValid = () -> {
            System.out.println("Checking sender.............");
            TimeUnit.SECONDS.sleep(2);
            return true;
        };

        Callable<Boolean> checkHumoValid = () -> {
            System.out.println("Checking receiver.............");
            TimeUnit.SECONDS.sleep(2);
            return true;
        };

        Future<Boolean> uzcardCheckResponse = executorService.submit(checkUzcardValid);
        Future<Boolean> humoCheckResponse = executorService.submit(checkHumoValid);
        System.out.println(uzcardCheckResponse.get());
        System.out.println(humoCheckResponse.get());
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        executorService.shutdown();
    }
}
````
# Future
````java
package uz.pdp.callable;

import java.util.concurrent.*;

public class FutureMethodsExample {
    public static void main(String[] args) {
        try ( ExecutorService executorService = Executors.newFixedThreadPool(10) ) {
            Future<String> future = executorService.submit(() -> {
                System.out.println("Connecting to API........");
                Thread.sleep(1500);
                return "Response from API";
            });
            //while (!future.isDone()) {
            //    Thread.sleep(100);
            //    System.out.println("API still did not return response");
            //    // future.cancel(true);
            //}
            //if (future.isCancelled()) {
            //    System.out.println("Future response cancelled");
            //} else {
            //    System.out.println("Reading response from future");
            //    System.out.printf("Response is : '%s'", future.get());
            // }
            String response = future.get(1, TimeUnit.SECONDS);
            System.out.println(response);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }
}
````

````java
package uz.pdp.callable;

import java.util.List;
import java.util.concurrent.*;

public class ExecuterServiceMethodsWhichWorksWithCallableAndFuture {
    public static void main(String[] args) {
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println(threadCount);
        try ( ExecutorService executorService = Executors.newFixedThreadPool(threadCount) ) {
            Callable<String> callable1 = () -> {
                Thread.sleep(100);
                return "Response 1";
            };
            Callable<String> callable2 = () -> {
                Thread.sleep(100);
                return "Response 2";
            };
            Callable<String> callable3 = () -> {
                Thread.sleep(100);
                return "Response 3";
            };
            /*List<Future<String>> futures = executorService.invokeAll(List.of(callable1, callable2, callable3));
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }*/
            String response = executorService.invokeAny(List.of(callable1, callable2, callable3));
            System.out.println(response);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
````
# ThreadLocal
````java
package uz.pdp.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithoutThreadLocal {
    public static void main(String[] args) {
        int coresCount = Runtime.getRuntime().availableProcessors();
        try (ExecutorService executorService = Executors.newFixedThreadPool(coresCount)) {
            for (int i = 0; i < 1000; i++) {
                executorService.execute(() -> {
                    a(new Date());
                });
            }
        }
    }

    static void a(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String formattedDate = simpleDateFormat.format(date);
        System.out.println(formattedDate);
    }
}
````

````java
package uz.pdp.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithThreadLocal {

    private static final ThreadLocal<SimpleDateFormat> formatThreadLocal = ThreadLocal.withInitial(SimpleDateFormat::new);

    public static void main(String[] args) {
        int coresCount = Runtime.getRuntime().availableProcessors();
        try (ExecutorService executorService = Executors.newFixedThreadPool(coresCount)) {
            for (int i = 0; i < 1000; i++) {
                executorService.execute(() -> {
                    a(new Date());
                });
            }
        }
    }

    static void a(Date date) {
        SimpleDateFormat simpleDateFormat = formatThreadLocal.get();
        String formattedDate = simpleDateFormat.format(date);
        System.out.println(formattedDate);
    }
}
````

````java
package uz.pdp.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("ddMMyyyy"));
        // Random random = new Random();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        threadLocalRandom.nextInt(100, 300);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for ( int i = 0; i < 1000; i++ ) {
            executorService.execute(() -> {
                try {
                    System.out.println(sdf.get().parse("01012001"));
                } catch (Exception e) {
                }
            });
        }
    }
}
````

````java
package uz.pdp.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomClassExample {
    public static void main(String[] args) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(100, 1300));
    }
}
````
