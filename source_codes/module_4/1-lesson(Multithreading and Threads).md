````java
package uz.pdp.workingwithThreads;

public class ThreadClassMethods {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread() + "->" + i);
            }
        };

        var thread1 = new Thread(runnable, "Thread ONE");
        var thread2 = new Thread(runnable, "Thread TWO");
        thread1.start();
        thread1.join(1000);
        thread2.start();
        System.out.println("Hello PDP");
    }
}
````

````java
package uz.pdp.workingwithThreads;

public class Threading {

    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());

        /*MyTask myTask = new MyTask();
        myTask.start();

        MyRunnableTask task = new MyRunnableTask();
        Thread thread = new Thread(task);
        thread.start();*/

        Runnable runnable = () -> {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        };
        /*Thread thread1 = new Thread(runnable);
        thread1.start();*/
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }, "MyThread").start();
        System.out.println("Do not say Hello World");
    }

}

class MyRunnableTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}

class MyTask extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }

}
````

````java
package uz.pdp.workingwithThreads;


public class ThreadPriorities {
    public static void main(String[] args) {
        var th = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Thread For Test");
        th.setPriority(Thread.MAX_PRIORITY);
    }
}
````


````java
package uz.pdp.workingwithThreads;

public class ThreadInterruption {
    public static void main(String[] args) {
        // Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable)
                -> System.out.println(thread.getName() + "::" + throwable.getMessage()));

        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        var th1 = new Thread(runnable);
        th1.start();
        System.out.println("Hello PDP");
        th1.interrupt();
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println(thread.getName() + "::" + throwable.getMessage());
    }
}
````

````java
package uz.pdp.workingwithThreads;

public class DealingWithThreadExceptions {
    public static void main(String[] args) throws InterruptedException {
        var th1 = new MyThread("Thread 1");
        var th2 = new MyThread("Thread 2");
        var th3 = new MyThread("Thread 3");
        th1.start();
        th2.start();
        th3.start();
        Thread.sleep(120);
        throw new RuntimeException("Main Thread Exception");
    }
}

class MyThread extends Thread {
    private final String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            if (name.equalsIgnoreCase("thread 1") && i == 2) throw new RuntimeException("Exception for testing");
            else System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return name + "->";
    }
}
````

````java
package uz.pdp.workingwithThreads;

public class ActiveThreadsCountTest {
    public static void main(String[] args) {
        var th1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread For Test");
        th1.start();
        int x = Thread.activeCount();
        Thread[] threads = new Thread[x];
        Thread.enumerate(threads);
        System.out.println(x);
        for ( Thread thread : threads ) {
            System.out.println(thread);
        }
    }
}
````

````java
package uz.pdp.workingwithThreads;

public class DaemonThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                for ( int i = 0; i < 40; i++ ) {
                    System.out.println("Active threads count : " + Thread.activeCount() + ", i = " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        var th1 = new Thread(runnable);
        th1.setDaemon(true);
        th1.setName("MyThread");
        th1.start();

        System.out.println("Hello PDP");
        Thread.sleep(210);
    }
}
````

