# VIEWS
## ArrayViewTest

````java
package collectionsframework.views;

import java.util.*;

public class ArrayViewTest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 12, 324};
        /*var arrList = new ArrayList<Integer>();
        for (int i : arr) {
            arrList.add(i);
        }*/
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 12, 324, 5, 6, 890);
        // method(arrList)
        List<String> languages = List.of("Java", "Scala", "Groovy", "Kotlin", "GO");
        Set<String> languagesSet = Set.of("Java", "Scala", "Groovy");
        System.out.println(languages);
        Map<String, String> dict = Map.of(
                "hello", "Assalom Alekum",
                "bye", "Xayr");
        System.out.println(dict);
        List<String> strings = languages.subList(1, 4);
        System.out.println(strings);
        languages.set(0, "Python");

    }
}
````
## EmptyViewTest

````java
package collectionsframework.views;

import java.util.*;

public class EmptyViewTest {

    public static void main(String[] args) {
        var strings = Collections.emptyList();
        var strings2 = new ArrayList<>();
        // method("Akbar Akbarov", new ArrayList<>());
        method("Akbar Akbarov", Collections.emptyList());
        var objects = Collections.emptySet();
        var objectObjectMap = Collections.emptyMap();

    }

    static void method(String fullName, List<String> hobbies) {
        // register
        // ........
    }
}
````

## SingletonViewTest

````java
package collectionsframework.views;

import java.util.*;

public class SingletonViewTest {
    public static void main(String[] args) {
        // var languages = new ArrayList<String>();
        // languages.add("Java");
        // var languages = Collections.singletonList("Java");
        // method(languages);
        Map<String, String> stringStringMap = Collections.singletonMap("hello", "Assalom alekum");
        Set<String> setSingleton = Collections.singleton("Java");
        List<String> strings = Collections.nCopies(4, "Java");
        System.out.println(strings);
    }
}
````

## UnmodifiableViewTest

````java
package collectionsframework.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableViewTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(23, "Akbarov Akbar"));
        students.add(new Student(21, "Abdullayev Asliddin"));
        students.add(new Student(32, "Komilov NurIslom"));
        List<Student> unmodifiableList = Collections.unmodifiableList(students);
        // unmodifiableList.set(0, new Student(32, "Elmurodov Javohir"));
        System.out.println(unmodifiableList);
        unmodifiableList.get(0).fullName = "Elmurodov Javohir";
        System.out.println(unmodifiableList);
    }

    static class Student {
        int age;
        String fullName;

        public Student(int age, String fullName) {
            this.age = age;
            this.fullName = fullName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", fullName='" + fullName + '\'' +
                    '}';
        }
    }
}
````
# Copies

## Address
````java
package copy;

import java.util.ArrayList;
import java.util.List;

public class Address implements Cloneable {
    private String region;
    private String streetName;
    private int apartmentNumber;

    private List<Integer> integers = new ArrayList<>();

    public Address(String region, String streetName, int apartmentNumber, List<Integer> integers) {
        this.region = region;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.integers = integers;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Integer> integers2 = new ArrayList<>();
        integers2.addAll(integers);
        Address address = (Address)super.clone();
        address.integers = integers2;
        return address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "region='" + region + '\'' +
                ", streetName='" + streetName + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", integers=" + integers +
                '}';
    }
}
````


## Student
````java
package copy;

public class Student implements Cloneable {
    private String fullName;
    private int age;
    private Address address;

/*    public Student(Student student) {
        this.fullName = student.fullName;
        this.age = student.age;
    }*/

    public Student(String fullName, int age, Address address) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.address = (Address) this.address.clone();
        return student;
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

## CopyConstructor
````java
package copy;

import java.util.ArrayList;

public class CopyConstructor {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(123);

        var address = new Address("Tashkent", "Muhbir", 55, integers);
        var student1 = new Student("Akbarov Akbar", 23, address);
        // var student2 = new Student(student1);
        // System.out.println(student1);
        // System.out.println(student2);
        try {
            Student student3 = (Student) student1.clone();

            address.setRegion("Qashqadaryo");
            integers.set(0, 12312);
            System.out.println(student1);
            System.out.println(student3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
````

# Iterator and ListIterator

## Counter
````java
package collectionsframework.iterators;

import java.util.Iterator;

public class Counter implements Iterable<Integer> {
    private int min;
    private int max;
    private int step;
    private CounterIterator counterIterator;

    public Counter(int max) {
        this(0, max, 1);
    }

    public Counter(int max, int step) {
        this(0, max, step);
    }

    public Counter(int min, int max, int step) {
        this.min = min;
        this.max = max;
        this.step = step;
        this.counterIterator = new CounterIterator(min, max, step);
    }

    @Override
    public Iterator<Integer> iterator() {
        return counterIterator;
    }
}
````

## CounterIterator

````java
package collectionsframework.iterators;

import java.util.Iterator;

public class CounterIterator implements Iterator<Integer> {
    private int min;
    private int max;
    private int step;
    private int current;

    public CounterIterator(int max) {
        this(0, max, 1);
    }

    public CounterIterator(int max, int step) {
        this(0, max, step);
    }

    public CounterIterator(int min, int max, int step) {
        this.min = min;
        this.max = max;
        this.step = step;
        this.current = min;
    }

    @Override
    public boolean hasNext() {
        return current < max;
    }

    @Override
    public Integer next() {
        int temp = current;
        current = current + step;
        return temp;
    }
}
````

## CounterTest

````java
package collectionsframework.iterators;

public class CounterTest {
    public static void main(String[] args) {
        var counter = new Counter(20, 100, 10);
        /*while (counterIterator.hasNext()) {
            System.out.println(counterIterator.next());
        }*/
        for (Integer integer : counter) {
            System.out.println(integer);
        }
    }
}
````

## Java IteratorClassTest

````java
package collectionsframework.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorClassTest {
    public static void main(String[] args) {
        var languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("Python");
        languages.add("Groovy");

        /*for (String language : languages) {
            if (language.equals("Go"))
                languages.remove(language);
        }*/

        Iterator<String> iterator = languages.iterator();
        iterator.forEachRemaining(System.out::println);

        /*while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("Go") || next.equals("Python")) {
                iterator.remove();
            }
        }*/
        System.out.println(languages);
    }
}
````

## Java ListIteratorClassTest

````java
package collectionsframework.iterators;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorClassTest {
    public static void main(String[] args) {
        var languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("Python");
        languages.add("Groovy");
        ListIterator<String> listIterator = languages.listIterator(languages.size());
        // listIterator.next();
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.println(previous);
            //listIterator.add("Hello "+ Math.random());
            if (previous.equals("Kotlin"))
                listIterator.set(previous + " updated");
        }
        System.out.println(languages);
    }
}
````

## FailFastIterator

````java
package collectionsframework.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastIterator {
    public static void main(String[] args) {
        var languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("Python");
        languages.add("Groovy");


        Iterator<String> iterator = languages.iterator();

        while ( iterator.hasNext() ) {
            String next = iterator.next();
            if ( next.equals("Go") ) languages.remove(next);
        }
        System.out.println(languages);
    }
}
````

## FailSafeIterator

````java
package collectionsframework.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator {
    public static void main(String[] args) {
        var languages = new CopyOnWriteArrayList<String>();
        languages.add("Java");
        languages.add("Scala");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("Python");
        languages.add("Groovy");

        Iterator<String> iterator = languages.iterator();

        while ( iterator.hasNext() ) {
            String next = iterator.next();
            if ( next.equals("Go") ) languages.remove(next);
        }
        System.out.println(languages);
    }
}
````

