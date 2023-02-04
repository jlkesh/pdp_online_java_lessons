# Atomicity

````java
package uz.pdp.atomicity;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private int counter = 0;

    public synchronized int incrementAndGet() {
        counter = counter + 1;
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        var counter = new Counter();
        Runnable runnable = () -> {
            for ( int i = 0; i < 1000; i++ ) {
                System.out.println(Thread.currentThread() + "::" + counter.incrementAndGet());

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        for ( int i = 0; i < 10; i++ ) {
            new Thread(runnable).start();
        }
        Thread.sleep(2000);
        System.out.println(counter.counter);
    }
}
````

````java
package uz.pdp.atomicity;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class AtomicLongClassExample {
    public static void main(String[] args) throws InterruptedException {
        var counter = new AtomicInteger();
        Runnable runnable = () -> {
            for ( int i = 0; i < 1000; i++ ) {
                System.out.println(Thread.currentThread() + "::" + counter.incrementAndGet());

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        for ( int i = 0; i < 10; i++ ) {
            new Thread(runnable).start();
        }
        Thread.sleep(2000);
        System.out.println(counter.get());
        Random random = new Random();
        int b = random.nextInt(9000, 11000);
        System.out.println(b);
        counter.set(Math.max(counter.get(), b)); // error-> race condition
        counter.accumulateAndGet(b, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int i, int i1) {
                return i > i1 ? i : i1;
            }
        }); // nor race condition
        System.out.println(counter.get());
    }
}
````

# Thread Safe Collection

````java
package uz.pdp.threadsafecollection;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class HashSetUnsafeExample {
    public static void main(String[] args) throws InterruptedException {
        var set1 = new HashSet<Integer>();
        var set = Collections.synchronizedSet(set1);
        // var set = ConcurrentHashMap.<Integer>newKeySet();// <T,Boolean>
        Runnable runnable = () -> {
            try {
                for ( int i = 0; i < 1000; i++ )
                    set.add(i);
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        };
        Runnable runnable2 = () -> {
            try {
                for ( int i = 1000; i < 2000; i++ )
                    set.add(i);
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        };

        new Thread(runnable).start();
        new Thread(runnable2).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(set.size());
    }
}
````

# VERSION ONE

````java
package uz.pdp.immitableclasses.versionone;

public class Address implements Cloneable {
    private String region;
    private String street;

    public Address(String region, String street) {
        this.region = region;
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "region='" + region + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
````

````java
package uz.pdp.immitableclasses.versionone;

public final class Employee {
    private final String fullName;
    private final int age;
    private final Address address;

    public Employee(String fullName, int age, Address address) throws CloneNotSupportedException {
        this.fullName = fullName;
        this.age = age;
        this.address = (Address) address.clone();
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
````

````java
package uz.pdp.immitableclasses.versionone;

public class EmployeeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Tashkent", "Muhbir I");
        Employee employee = new Employee("Akbar Akbarov", 22, address);
        System.out.println(employee);
/*        address.setRegion("Bukhara");
        System.out.println(employee);*/
        employee.getAddress().setRegion("Bukhara");
        System.out.println(employee);
    }
}
````

# VERSION TWO

````java
package uz.pdp.immitableclasses.versiontwo;

public final class Address {
    private final String region;
    private final String street;

    public Address(String region, String street) {
        this.region = region;
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public String getStreet() {
        return street;
    }


    @Override
    public String toString() {
        return "Address{" +
                "region='" + region + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
````

````java
package uz.pdp.immitableclasses.versiontwo;

public final class Employee {
    private final String fullName;
    private final int age;
    private final Address address;

    public Employee(String fullName, int age, Address address) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
````

````java
package uz.pdp.immitableclasses.versiontwo;

public class EmployeeTest {
    public static void main(String[] args) {
        Address address = new Address("Tashkent", "Muhbir I");
        Employee employee = new Employee("Akbar Akbarov", 22, address);
        System.out.println(employee);
        System.out.println(employee);
        System.out.println(employee);
    }
}
````
