
# Overloading
````java
package uz.pdp.overloading;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 4:38 AM
 * @project lesson_4_1
 */

public class Calculator {

    public int sum(byte x, byte y) {
        System.out.println("byte, byte called");
        return x + y;
    }

    public int sum(int x, int y) {
        System.out.println("int, int called");
        return x + y;
    }

    public int sum(int x, long y) {
        System.out.println("int, long called");
        return (int) ( x + y );
    }

    public int sum(int x, double y) {
        System.out.println("int, double called");
        return (int) ( x + y );
    }

}
````


````java
package uz.pdp.overloading;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 4:39 AM
 * @project lesson_4_1
 */

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int x = 90;
        int y = 10;
        // System.out.println(calculator.sum(x, y));
        // System.out.println(calculator.sum(x, 12.0F));
        // System.out.println(calculator.sum(x, 12L));
        // String str1 = String.valueOf(12);
        // String str2 = String.valueOf(12D);
        // String str3 = String.valueOf(12L);
        // String str4 = String.valueOf('A');
        byte a = 12;
        byte b = 32;
        // automatic type promotion
        //
        System.out.println(calculator.sum(a, b));

    }
}
````

# Overriding
````java
package uz.pdp.overriding;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 4:58 AM
 * @project lesson_4_1
 */

public class Shape {
    public void area() {
        System.out.println("Shape area");
    }

    public Number covariantTypeTest() {
        return 21;
    }

    public static void hiding() {
        System.out.println("Shape hiding method");
    }
}
````


````java
package uz.pdp.overriding;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:01 AM
 * @project lesson_4_1
 */

public class Rectangle extends Shape {
    private double a;
    private double b; // a*b

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void area() {
        double area = a * b;
        System.out.printf("Rectangle Area : %10.2f %n", area);
    }
}
````


````java
package uz.pdp.overriding;

import java.awt.font.NumericShaper;

import static java.lang.Math.*;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 4:59 AM
 * @project lesson_4_1
 */

public class Circle extends Shape {
    private double radius; // pi*radius^2

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        double area = PI * pow(radius, 2);
        System.out.printf("Circle Area : %10.2f%n", area);
    }

    @Override
    public Double covariantTypeTest() {
        return 12D;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void hiding() {
        System.out.println("Circle hiding method");
    }
}
````


````java
package uz.pdp.overriding;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:02 AM
 * @project lesson_4_1
 */

public class App {
    public static void main(String[] args) {

        Shape circle = new Circle(4D); // upcasting
        circle.area();
        // circle.hiding();

        Shape rectangle = new Rectangle(4, 6); // upcasting
        rectangle.area();
        // rectangle.hiding();
    }
}
````

# Access Modifiers

````java
package uz.pdp.accessmodifiers;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:28 AM
 * @project lesson_4_1
 */

public class Child extends Parent{
    @Override
    protected void defaultMethod() { // protected or public
        super.defaultMethod();
    }

    @Override
    public void protectedMethod() {
        super.protectedMethod();
    }

    @Override
    public void publicMethod() {
        super.publicMethod();
    }
}
````


````java
package uz.pdp.accessmodifiers;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:28 AM
 * @project lesson_4_1
 */

public class Parent {
    void defaultMethod() {
        System.out.println("Parent default method");
    }

    protected void protectedMethod() {
        System.out.println("Parent protected method");
    }
    public void publicMethod() {
        System.out.println("Parent public method");
    }

    private void privateMethod() {
        System.out.println("Parent private method");
    }
}
````