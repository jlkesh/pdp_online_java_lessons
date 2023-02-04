## RawTypeTest<E>
````java
package generics;

public class RawTypeTest<E> {
    private E item;

    public void setItem(E item) {
        this.item = item;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public static void main(String[] args) {
        RawTypeTest rawTypeTest = new RawTypeTest();
        rawTypeTest.setItem("123");
    }
}
````


## GenericMethod
````java
package generics;

public class GenericMethod {

    public static <T extends Comparable<T>> int compare(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }

    /*
    public static int compare(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2);
    }
     */

    /*
    public static <T> int compare(T obj1, T obj2) {
       // some logic;
        return 1;
    }
     */
    /*
    public static int compare(Object obj1, Object obj2) {
       // some logic;
        return 1;
    }
     */

}

record Employee(String fullName, int age) implements Comparable<Employee> {
    @Override
    public int compareTo(Employee employee) {
        return Integer.compare(this.age, employee.age);// this.age.compareTo(employee.age);
    }
}

class GenericMethodTest {
    public static void main(String[] args) {
        int compare = GenericMethod.compare(34, 34);
        System.out.println(compare);
        int compare1 = GenericMethod.compare("hello", "hi");
        System.out.println(compare1);
        var employee1 = new Employee("Javohir Elmurodov", 28);
        var employee2 = new Employee("Akbar Akbarov", 28);
        int compare2 = GenericMethod.compare(employee1, employee2);
        System.out.println(compare2);
    }
}
````


## GenericClass<E>
````java
package generics;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class GenericClass<E> { // type parameter
    private Object[] elementsData;

    public GenericClass() {
        this(3);
    }

    public GenericClass(int capacity) {
        this.elementsData = new Object[capacity];
    }

    public boolean set(int index, E element) {
        Objects.checkIndex(index, elementsData.length);
        elementsData[index] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, elementsData.length);
        return (E) elementsData[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(elementsData);
    }

}

class Student {
    private final String id;
    private final String fullName;

    Student(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<String> languages = new GenericClass<>(); // type argument
        languages.set(0, "Java");
        languages.set(1, "Scala");
        languages.set(2, "Python");
        System.out.println(languages);
        String language = languages.get(1);
        System.out.println(language);

        // GenericClass<Student> students = new GenericClass<>(2);
        var students = new GenericClass<Student>(2);
        students.set(0, new Student(UUID.randomUUID().toString(), "Akbarov Akbar"));
        students.set(1, new Student(UUID.randomUUID().toString(), "Asliddin Abdullayev"));
        Student o = students.get(0);
        System.out.println(students);
        System.out.println(o);

        GenericClass<Integer> integers = new GenericClass<>();
        integers.set(0, 12);
        integers.set(1, 2);
        integers.set(2, 902);
        System.out.println(integers);
        Integer integer = integers.get(1);
        System.out.println(integer);

        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.set(0, "Java");
        // genericClass.set(1, new Student("1", "Akbarov Akbar"));
        // genericClass.set(2, 123D);
        String o1 = genericClass.get(0);
        System.out.println(o1);
    }
}
````


## Generics Bounds
````java

package generics.bounds;


public class TypeVariableBounds<T extends CharSequence> {
    private final T field;

    public TypeVariableBounds(T field) {
        this.field = field;
    }
}

interface CanConnectToDatabase {
}

class Repository implements CanConnectToDatabase {
}

class Service<R extends CanConnectToDatabase> {
    private final R repository;

    Service(R repository) {
        this.repository = repository;
    }
}

class A<E extends B1 & B2 & B3> {}

interface B1 {}

interface B2 {}

interface B3 {}

class C1 implements B1, B2 {}

class C2 implements B1, B3,B2 {}

class TypeVariableBoundsTest {
    public static void main(String[] args) {
        var t = new TypeVariableBounds<String>("Hello");
        // var t2 = new TypeVariableBounds<Long>(1L);
        // var t3 = new TypeVariableBounds<Integer>(1);
        // var t4 = new TypeVariableBounds<Double>(1D);
        Repository repository = new Repository();
        var service = new Service<Repository>(repository);
        // var a = new A<C1>();
        var a2 = new A<C2>();
    }
}



````


## Restrictions

````java
package generics.restrictions;

import java.io.Serializable;

public class Example<E> {
    // private static E e;
    /*
    try{
        ...code
    }
    catch(E e){

    }
     */

    static  <T extends Number> void m1(T t1, T t2){

    }
    static  <E extends Serializable> void m1(E t1, E t2){

    }

    /*
        static   void m1(Number t1, Number t2){

         }
        static   void m1(Serializable t1, Serializable t2){

        }
     */
    public static void main(String[] args) {

        var r = new Example<Integer>();

    }
}
````


# Inheritance

````java
package generics.inhiretance;

public class Employee {
}
````

````java
package generics.inhiretance;

public class Manager extends Employee {
}
````

```java
package generics.inhiretance;

public class InhiretanceTest {

    public static void main(String[] args) {
        Employee employee = new Employee();
        Manager manager = new Manager();
        employee = manager; // valid

        Pair<Employee> employeePair = new Pair<>(employee);
        Pair<Manager> managerPair = new Pair<>(manager);

        // employeePair = managerPair; // invalid
        Employee[] arr = new Manager[]{};
    }

}

class Pair<E> {
    private final E e;

    Pair(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }
}

class P {
    void ss(Pair<?> pair) {

    }
}
```


