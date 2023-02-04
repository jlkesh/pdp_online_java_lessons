# Abstraction

````java
package uz.pdp.abstraction;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:16 AM
 * @project lesson_5_1
 */

public abstract class Shape {
    public abstract double square();
}
````

````java
package uz.pdp.abstraction;

import static java.lang.Math.*;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:18 AM
 * @project lesson_5_1
 */

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return PI * pow(radius, 2);
    }
}
````

````java
package uz.pdp.abstraction;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:17 AM
 * @project lesson_5_1
 */

public class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double square() {
        return a * b;
    }
}
````

````java
package uz.pdp.abstraction;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:16 AM
 * @project lesson_5_1
 */

public class Test {
    public static void main(String[] args) {
        //
        Shape circle = new Circle(12);
        Shape rectangle = new Rectangle(12, 5);
        System.out.println("circle.square() = " + circle.square());
        System.out.println("rectangle.square() = " + rectangle.square());
    }
}
````

# Interfaces

````java
package uz.pdp.interfaces;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:54 AM
 * @project lesson_5_2
 */

public interface Shape {

    static boolean isNull(Double a) {
        return a == null;
    }

    static boolean isNonNull(Double a) {
        return !isNull(a);
    }

    default void draw() {
        // Since java 1.8
    }

    double square();

    double pmt();
}
````

````java
package uz.pdp.interfaces;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:56 AM
 * @project lesson_5_2
 */

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return PI * pow(radius, 2);
    }

    @Override
    public double pmt() {
        return 2 * PI * radius;
    }
}
````

````java
package uz.pdp.interfaces;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:55 AM
 * @project lesson_5_2
 */

public class Rectangle implements Shape {

    private Double a;
    private Double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double square() {
        if ( Shape.isNull(a) ) {
            return 0;
        }
        return a * b;
    }

    @Override
    public double pmt() {
        return 2 * ( a + b );
    }
}
````

````java
package uz.pdp.interfaces;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 6:24 AM
 * @project lesson_5_2
 */

public class Triangle implements Shape {

    @Override
    public void draw() {
        Shape.super.draw();
    }

    @Override
    public double square() {
        return 0;
    }

    @Override
    public double pmt() {
        return 0;
    }
}
````

````java
package uz.pdp.interfaces;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 5:58 AM
 * @project lesson_5_2
 */

public class Test {
    public static void main(String[] args) {

        Shape circle = new Circle(12);
        Shape rectangle = new Rectangle(12, 9);
        System.out.println("circle.square() = " + circle.square());
        System.out.println("rectangle.square() = " + rectangle.square());
        System.out.println("circle.pmt() = " + circle.pmt());
        System.out.println("rectangle.pmt() = " + rectangle.pmt());
    }
}
````

# Abstraction and Interfaces Differences

````java
/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 6:53 AM
 * @project lesson_5_3
 */

public abstract class AbstractClass {
    private String fieldOne;
    public String fieldTwo;
    public final String fieldThree = "123";
}
````

````java
/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 6:53 AM
 * @project lesson_5_3
 */

public interface Interface {
    String fieldOne = "123";

    public abstract void methodOne();
}
````

````java
/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 6:53 AM
 * @project lesson_5_3
 */

public class Main {
    public static void main(String[] args) {

    }
}
````

# Marker Interfaces

````java
public interface MarkerInterface {
}
````

````java
/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 7:09 AM
 * @project lesson_5_4
 */

public class CustomString implements MarkerInterface {
}
````

````java
/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 7:08 AM
 * @project lesson_5_4
 */

public class Dynamic<T extends MarkerInterface> {
}
````

````java
import java.io.Serializable;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 7:03 AM
 * @project lesson_5_4
 */

public class Main implements Cloneable {
    public static void main(String[] args) throws Exception {

        System.out.println(Byte.decode("0X1F"));

        // Cloneable
        // Main main = new Main();
        // Main cloneOfMain = (Main) main.clone();
        // Serializable
        // ----------------------------------
        Dynamic<CustomString> stringDynamic = new Dynamic<CustomString>();
    }
}
````