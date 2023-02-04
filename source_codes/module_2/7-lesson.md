# Stack
````java
/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 8:34 AM
 * @project lesson_7_2_stack
 */

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.m2();
        int w = 9;
    }

    public void m1() {
        int a = 13;
        Integer b2 = 12;
        double b = 90;
        m2();
        int q = 12;
    }

    public void m2() {
        int c = 91;
        float f = 90;
    }
}
````
# Method Parameters
````java
package uz.pdp;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 6:57 AM
 * @project lesson_7_4_ma
 */

public class Counter {
    public int count = 0;
}
````


````java
package uz.pdp;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 6:45 AM
 * @project lesson_7_4_ma
 */

public class App {
    public static void main(String[] args) {
        App app = new App();
        int a = 12;
        // app.m1(a);
        // System.out.println(a);
        // Integer b = 12;
        // app.m2(b);
        // System.out.println(b);
        Counter c = new Counter();
        c.count = 90;
        System.out.println(c.count);
        app.m3(c);
        System.out.println(c.count);
    }

    public void m3(Counter c) {
        // c.count = 300;
        c = new Counter();
        c.count = 300;
    }

    public void m2(Integer b) {
        b = 90;
    }

    public void m1(int a) {
        a = 90;
        System.out.println("inside m1 method " + a);
    }
}
````

````java
package uz.pdp;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 7:06 AM
 * @project lesson_7_4_ma
 */

public class Calculator {
    public static void main(String... args) {
        Calculator c = new Calculator();
        System.out.println(c.add(12, 3));
        System.out.println(c.add(12, 3, 45));
        System.out.println(c.add(12, 3, 45, 20));
        System.out.println(c.add(12, 3, 45, 4, 5, 5, 6, 7, 7, 20));
    }

    public int add(int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

//    public int add(int[] arr) {
//        int sum = 0;
//        for (int i : arr) {
//            sum += i;
//        }
//        return sum;
//    }
}
````