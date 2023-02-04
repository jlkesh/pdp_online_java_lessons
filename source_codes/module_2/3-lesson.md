# Inheritance

````java
package uz.pdp.example_1;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 5:50 AM
 * @project lesson_3_1
 */

public class App {
    public static void main(String[] args) {
        Car car = new Car();
        car.getColor();
    }
}
````


````java
package uz.pdp.example_1;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 5:45 AM
 * @project lesson_3_1
 */

public class Vehicle { // mashina
    private String manufacturer;
    private String name;
    private String color;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
````


````java
package uz.pdp.example_1;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 5:54 AM
 * @project lesson_3_1
 */

public class Truck extends Vehicle{
}
````


````java
package uz.pdp.example_1;

/*
 *
 * @author Elmurodov Javohir
 * @time 11/3/2022 5:47 AM
 * @project lesson_3_1

 */


public class Car extends Vehicle {

}
````


````java

package uz.pdp;


/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 5:53 AM
 * @project lesson_3_1
 */


public class Sedan extends Car{

}
````


````java
package uz.pdp.example_2;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 5:58 AM
 * @project lesson_3_1
 */

public class Employee {
    private String fullName;
    private double salary;


    public Employee(){
        System.out.println("Employee no-args constructor called");
    }

    public Employee(String fullName, double salary){
        this.fullName = fullName;
        this.salary = salary;
        System.out.println("Employee class two argument constructor called");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
````



````java
package uz.pdp.example_2;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 5:58 AM
 * @project lesson_3_1
 */

public class Manager /*subclass or child class*/
        extends Employee /*super class or parent class*/ {

    private int bonus;

    public Manager(int bonus) {
        super();
        this.bonus = bonus;
        System.out.println("Manager one argument constructor called");
    }

    public Manager(String fullName, double salary, int bonus) {
        super(fullName, salary);
        this.bonus = bonus;
        System.out.println("Manager class three argument constructor called");
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
````


````java
package uz.pdp.example_2;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 6:01 AM
 * @project lesson_3_1
 */

public class App {
    public static void main(String[] args) {
        // Manager manager = new Manager(7);
        Manager manager2 = new Manager("John Doe",12,9);
        Employee employee = new Manager(2);
        /*manager.setSalary(10);
        manager.setBonus(5);
        System.out.println(manager.getSalary());*/
    }
}
````


````java
package uz.pdp.example_3;


/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 6:13 AM
 * @project lesson_3_1
 */

public class Book /*extends Object*/ {
    private String id;
    private String title;
    private String author;


    public Book() {
    }

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this == obj)
            return true;


        if (!(obj instanceof Book o))
            return false;

        return this.title.equals(o.getTitle()) &&
                this.id.equals(o.getId()) &&
                this.author.equals(o.getAuthor());
    }

    public String displayBookObject() {
        return "Book{id = %s, title = %s, author = %s}"
                .formatted(id, title, author);
    }

    @Override
    public String toString() {
        return "Book{id = %s, title = %s, author = %s}"
                .formatted(id, title, author);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
````


````java
package uz.pdp.example_3;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 6:14 AM
 * @project lesson_3_1
 */

public class App {
    public static void main(String[] args) {
        Book cleanCode = new Book("1", "Clean code", "Robert C.Martin");
        Book cleanCode2 = new Book("3", "Clean code", "Robert C.Martin");
        Book reactiveSpring = new Book("2", "Reactive Spring", "Josh Long");
        // System.out.println(cleanCode.displayBookObject());
        // System.out.println(cleanCode2.displayBookObject());
        // System.out.println(reactiveSpring.displayBookObject());
        System.out.println(cleanCode);
        // System.out.println(cleanCode == cleanCode2);
        // System.out.println(cleanCode.equals(cleanCode));
        // System.out.println(cleanCode.equals(12.0D));
    }
}
````

# Modifiers
````java
package uz.pdp.package_for_default_modifier;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:23 AM
 * @project lesson_3_2
 */

public class ClassWithDefaultModifier {

    String defaultField;

    void defaultMethod() {
        System.out.println("Default method");
    }
}
````


````java
package uz.pdp.package_for_default_modifier;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:26 AM
 * @project lesson_3_2
 */

public class ClassWithDefaultModifierTest {
    public static void main(String[] args) {
        ClassWithDefaultModifier obj = new ClassWithDefaultModifier();
        obj.defaultMethod();
    }
}
````



````java
package uz.pdp.package_for_protected_modifier;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:12 AM
 * @project lesson_3_2
 */

public class ClassWithProtectedModifier {

    protected String protectedField;

    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

}
````


````java
package uz.pdp.package_for_protected_modifier;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:17 AM
 * @project lesson_3_2
 */

public class ClassWithProtectedModifierTest {
    public static void main(String[] args) {
        ClassWithProtectedModifier obj = new ClassWithProtectedModifier();
        obj.protectedField = "123";
        obj.protectedMethod();
    }
}
````


````java
package uz.pdp.package_for_protected_modifier_test;

import uz.pdp.package_for_protected_modifier.ClassWithProtectedModifier;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:18 AM
 * @project lesson_3_2
 */

public class ClassForTestingProtectedModifier extends ClassWithProtectedModifier {

    public ClassForTestingProtectedModifier(String protectedField) {
        super.protectedField = protectedField;
    }


    public String returnProtectedField() {
        return "-> " + protectedField;
    }

    public void callProtectedMethod() {
        protectedMethod();
    }
}
````


````java
package uz.pdp;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:28 AM
 * @project lesson_3_2
 */

public class ClassWithPrivateModifier {

    private String privateField;

    private void privateMethod() {
        System.out.println(privateField);
        System.out.println("privateMethod");
    }

    public void callPrivateMethod() {
        privateMethod();
    }
}
````


````java
package uz.pdp;

import uz.pdp.package_for_default_modifier.ClassWithDefaultModifier;
import uz.pdp.package_for_protected_modifier.ClassWithProtectedModifier;
import uz.pdp.package_for_protected_modifier_test.ClassForTestingProtectedModifier;
import uz.pdp.package_for_public_modifier.ClassWithPublicModifier;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:09 AM
 * @project lesson_3_2
 */

public class App {
    public static void main(String[] args) {
        /*ClassWithPublicModifier obj = new ClassWithPublicModifier();
        obj.publicField = "Public Field";
        obj.publicMethod();*/
        /*ClassWithProtectedModifier obj = new ClassWithProtectedModifier();
        obj.protectedField = "qwe3wq";
        obj.protectedMethod();*/

        /*ClassForTestingProtectedModifier obj = new ClassForTestingProtectedModifier("Field One");
        System.out.println(obj.returnProtectedField());
        obj.callProtectedMethod();*/
        ClassWithDefaultModifier obj = new ClassWithDefaultModifier();

    }
}
````

# Relationships

````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:50 AM
 * @project lesson_3_3
 */

public class Address {
    private String countryName;
    private String regionName;
    private String streetName;

    public Address(String countryName, String regionName, String streetName) {
        this.countryName = countryName;
        this.regionName = regionName;
        this.streetName = streetName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "countryName='" + countryName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
````

````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:45 AM
 * @project lesson_3_3
 */

public class Citizen {
    private String fullName;

    public Citizen(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
````


````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:55 AM
 * @project lesson_3_3
 */

public class Heart {
    private int beatsCount;

    public Heart(int beatsCount) {
        this.beatsCount = beatsCount;
    }
}
````


````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:45 AM
 * @project lesson_3_3
 */

public class Passport {
    private String serial;
    private String number;

    public Passport(String serial, String number) {
        this.serial = serial;
        this.number = number;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
````


````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:55 AM
 * @project lesson_3_3
 */

public class Person {
    private String name;
    private final Heart heart;

    public Person(String name, Heart heart) {
        this.name = name;
        this.heart = heart;
    }
}
````


````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:50 AM
 * @project lesson_3_3
 */

public class Student {
    private String fullName;
    private int age;
    private Address address;

    public Student(String fullName, int age, Address address) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
````


````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:50 AM
 * @project lesson_3_3
 */

public class AggregationTest {
    public static void main(String[] args) {
        Address address = new Address("Uzbekistan", "Tashkent", "Beruniy");
        Student student = new Student("Akbarov Akbar", 22, address);
        System.out.println(student);
    }
}
````


````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:46 AM
 * @project lesson_3_3
 */

public class AssosiotionTest {
    public static void main(String[] args) {
        Citizen citizen = new Citizen("Akbarov Akbar");
        Passport passport = new Passport("AB", "1231234");
        String message = "%s, %s%s"
                .formatted(citizen.getFullName(), passport.getSerial(), passport.getNumber());
        System.out.println(message);
    }
}
````


````java
package uz.pdp.has;

/**
 * @author Elmurodov Javohir
 * @time 11/3/2022 7:54 AM
 * @project lesson_3_3
 */

public class CompositionTest {
    public static void main(String[] args) {
        Heart heart = new Heart(77);
        Person person = new Person("Akbar", heart);
    }
}
````