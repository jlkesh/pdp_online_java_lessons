# Final Modifiers

````java
package uz.pdp.modifiers.finalm;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 8:28 AM
 * @project lesson_8_1_modifiers
 */

public /*final*/ class A {

    public final String fieldOne;

    public A(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public final void greeting() {
        final int a = 12;
        System.out.println("Hello");
    }
}
````

````java
package uz.pdp.modifiers.finalm;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 8:28 AM
 * @project lesson_8_1_modifiers
 */

public class B extends A {
    public B(String fieldOne) {
        super(fieldOne);
    }

    /*@Override
    public void greeting() {
        System.out.println("hi 👌👌");
    }*/

    public static void main(String[] args) {
        B b = new B("Field ✅");
        b.greeting();
    }
}
````

# Native Modifier

````java
package uz.pdp.modifiers.nativem;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 8:50 AM
 * @project lesson_8_1_modifiers
 */

public class A {
    public static void main(String[] args) {
        Object o = new Object();
    }
}
````

# Static Modifiers

````java
package uz.pdp.modifiers.staticm;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 8:35 AM
 * @project lesson_8_1_modifiers
 */

public class A {

    public int i;
    public static String field = "✅";
    /*
    class
    method
    variable
     */

    public static void greeting() {
        int a = 12;
        System.out.println("Hello 👌");
    }

    public static class InnerClass {

    }
}
````

````java
package uz.pdp.modifiers.staticm;

import static uz.pdp.modifiers.staticm.A.greeting;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 8:38 AM
 * @project lesson_8_1_modifiers
 */

public class B {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        A a4 = new A();
        greeting();
        /*System.out.println(A.field);
        System.out.println(Math.E);*/
        System.out.println(a1.field);
        System.out.println(a2.field);
        System.out.println(a3.field);
        System.out.println(a4.field);
    }
}
````

# Record

````java
package uz.pdp.recordclass;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 8:58 AM
 * @project lesson_8_2_record
 */

public class Employee {
    private final String fullName;
    private final String employeeId;
    private final LocalDate hiredDate;

    public Employee(String fullName, String employeeId, LocalDate hiredDate) {
        this.fullName = fullName;
        this.employeeId = employeeId;
        this.hiredDate = hiredDate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmployeeId() {
        return employeeId;
    }


    public LocalDate getHiredDate() {
        return hiredDate;
    }


    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Employee employee = (Employee) o;
        return fullName.equals(employee.fullName) && employeeId.equals(employee.employeeId) && hiredDate.equals(employee.hiredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, employeeId, hiredDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", hiredDate=" + hiredDate +
                '}';
    }
}
````

````java
package uz.pdp.recordclass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 9:03 AM
 * @project lesson_8_2_record
 */

public record EmployeeRecord(String fullName, String employeeId, LocalDate hiredDate) {

    public EmployeeRecord {
        System.out.println("EmployeeRecord Constructor");
    }

    public String fullInfo() {
        return "%s,%s,%s".formatted(fullName, employeeId, hiredDate);
    }
}
````

````java
package uz.pdp.recordclass;

import java.time.LocalDate;

/**
 * @author Elmurodov Javohir
 * @time 11/17/2022 8:57 AM
 * @project lesson_8_2_record
 */

public class App {
    public static void main(String[] args) {
        // DTO -> Data Transfer Object
        Employee employee = new Employee(
                "Elmurodov Javohir",
                "1",
                LocalDate.of(2020, 1, 1));

        EmployeeRecord employeeRecord = new EmployeeRecord(
                "Elmurodov Javohir",
                "1",
                LocalDate.of(2020, 1, 1));
        /*System.out.println(employee.getFullName());
        System.out.println(employee.getHiredDate());
        System.out.println(employeeRecord.fullName());
        System.out.println(employeeRecord.hiredDate());*/
        System.out.println(employeeRecord.fullInfo());
    }
}
````

# Sealed Classes

````java
package uz.pdp.sealedclasses;

import java.io.Serializable;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:13 AM
 * @project sealedclasses
 */

public sealed class A extends E implements Serializable, Cloneable permits B {

}
````

````java
package uz.pdp.sealedclasses;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:14 AM
 * @project sealedclasses
 */

public non-sealed class B extends A {

}
````

````java
package uz.pdp.sealedclasses;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:14 AM
 * @project sealedclasses
 */

public class C {
}
````

````java
package uz.pdp.sealedclasses;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:14 AM
 * @project sealedclasses
 */

public class D extends B {
}
````

````java
package uz.pdp.sealedclasses;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:19 AM
 * @project sealedclasses
 */

public class E {
}
````

````java
package uz.pdp.sealedclasses;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:19 AM
 * @project sealedclasses
 */

public class F {
}
````

# Variable hiding

````java
package uz.pdp.variable.hiding;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:57 AM
 * @project vshadowing_vhiding
 */

public class A {
    public int x = 12;

    public void hi() {
        System.out.println("Hi");
    }
}
````

````java
package uz.pdp.variable.hiding;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:57 AM
 * @project vshadowing_vhiding
 */

public class B extends A {
    public int x = 34;

    @Override
    public void hi() {
        System.out.println("Hello");
    }
}
````

````java
package uz.pdp.variable.hiding;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:57 AM
 * @project vshadowing_vhiding
 */

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A ab = new B();
        System.out.println(a.x);
        System.out.println(b.x);
        System.out.println(ab.x);
        ab.hi();
    }
}
````

````java
package uz.pdp.variable.shadowing;

import static java.lang.Math.pow;

/**
 * @author Elmurodov Javohir
 * @time 11/18/2022 5:52 AM
 * @project vshadowing_vhiding
 */

public class Main {
    private final double pi;

    public Main(double pi) {
        this.pi = pi;
    }

    public double calculateSquareOfCircle(double radius) {
        double pi = 1; // variable Shadowing
        return pi * pow(radius, 2);
    }

    public static void main(String[] args) {
        Main main = new Main(Math.PI);
        System.out.println(main.calculateSquareOfCircle(2));
    }
}
````