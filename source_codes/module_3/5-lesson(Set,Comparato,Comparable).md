##  Set Object Creating

````java
package collectionsframework.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ObjectCreating {
    public static void main(String[] args) {
        Set<String> languages = new HashSet<>();
        Set<String> languages2 = new LinkedHashSet<>();
        Set<String> languages3 = new TreeSet<>();
    }
}

````

##  JavaHashSetTest

````java
package collectionsframework.set;

import java.util.HashSet;

public class JavaHashSetTest {
    public static void main(String[] args) {
        var languages = new HashSet<String>();
        languages.add("Java");
        languages.add("Python");
        languages.add("Scala");
        languages.add("C++");
        languages.add("C#");
        // languages.add("Java");
        // languages.clear();
        System.out.println(languages);
        System.out.println(languages.contains("Java"));
        /*for (String language : languages) {
            System.out.println(language);
        }*/

        languages.forEach(System.out::println);
    }
}
````

##  JavaLinkedHashSetTest

````java
package collectionsframework.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class JavaLinkedHashSetTest {
    public static void main(String[] args) {
        var languages = new LinkedHashSet<String>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Scala");
        languages.forEach(System.out::println);
        System.out.println("---------------");
        var languages2 = new HashSet<String>();
        languages2.add("Java");
        languages2.add("Python");
        languages2.add("C++");
        languages2.add("Scala");
        languages2.forEach(System.out::println);
    }
}
````

#  Equals and Hashcode
## Card
````java
package collectionsframework.set.equalsandhashcode;

import java.util.Objects;

public class Card {
    private String cardNumber;
    private String cardExpiry;
    private int field;

    public Card(String cardNumber, String cardExpiry, int field) {
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.field = field;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Card o))
            return false;

        return o.cardExpiry.equals(this.cardExpiry) &&
                o.cardNumber.equals(this.cardNumber) &&
                o.field == this.field;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cardNumber, this.cardExpiry, this.field);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardExpiry='" + cardExpiry + '\'' +
                ", field=" + field +
                '}';
    }
}
````

## HashCodeMethodTest
````java
package collectionsframework.set.equalsandhashcode;

import java.util.HashSet;
import java.util.Set;

public class HashCodeMethodTest {
    public static void main(String[] args) {
        var card1 = new Card("86009090", "06/26", 2);
        var card2 = new Card("86009090", "06/26", 5);
        System.out.println(card1.equals(card2));
        System.out.println(card1.hashCode());
        System.out.println(card2.hashCode());

        Set<Card> cardSet = new HashSet<>();
        cardSet.add(card2);
        cardSet.add(card1);
        System.out.println(cardSet);
    }
}
````

##  VOFR
````java
package collectionsframework.set.equalsandhashcode;

public class VOFR {
    int number;

    public VOFR(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        var o = (VOFR) obj;
        return this.number > o.number;
    }

    public static void main(String[] args) {
        var o1 = new VOFR(1);
        System.out.println(o1.equals(o1));
    }
}

````

## EqualsMethodTest

````java
package collectionsframework.set.equalsandhashcode;

public class EqualsMethodTest {
    public static void main(String[] args) {
        // var card1 = new Card("86009090", "06/26");
        // var card2 = new Card("86009090", "06/26");
        // System.out.println(card1.equals(card2));
        A a = new A();
        B b = new B();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        // System.out.println(a.equals(b));
        // System.out.println(b.equals(a));
    }
}

class A {
    int i;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof A o)) return false;
        return this.i == o.i;
    }
}

class B extends A {
    int j;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof B o)) return false;
        return this.j == o.j && this.i == o.i;
    }
}

````

## JavaTreeSetTest

````java
package collectionsframework.set;

import java.util.Comparator;
import java.util.TreeSet;

public class JavaTreeSetTest {
    public static void main(String[] args) {
        var treeSet = new TreeSet<Integer>();
        treeSet.add(12);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(90);
        treeSet.add(4);
        treeSet.add(6);
        treeSet.add(-12);
        // for (Integer integer : treeSet) {
        //     System.out.println(integer);
        // }
        System.out.println(treeSet);
        // System.out.println(treeSet.floor(5));
        // System.out.println(treeSet.ceiling(6));
        // System.out.println(treeSet.lower(4));
        // System.out.println(treeSet.higher(6));
        System.out.println(treeSet.subSet(6, 12));
        System.out.println(treeSet.subSet(6, true, 12, true));
        System.out.println(treeSet.tailSet(6));
        System.out.println(treeSet.tailSet(6, false));
        var treeSet2 = new TreeSet<Employee>(Comparator.comparing(Employee::getFullName));
        treeSet2.add(new Employee("Akbar Akbarov"));
        System.out.println(treeSet2);

    }
}


class Employee  {
    private String fullName;

    public Employee(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
````

# Comparable 
## Student
````java
package collectionsframework.comparable;

public class Student /*implements Comparable<Student>*/ {
    public String firstName;
    public String lastName;
    public int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

   /* @Override
    public int compareTo(Student student) {
        int i = this.lastName.compareTo(student.lastName);
        if (i == 0) {
            i = this.firstName.compareTo(student.firstName);
            if (i == 0)
                return Integer.compare(age, student.age);
        }
        return i;
    }*/

    @Override
    public String toString() {
        return "%s %s %d".formatted(lastName, firstName, age);
    }
}
````
## MockData
````java
package collectionsframework.comparable;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class MockData {
    public static ArrayList<Student> students() {
        var students = new ArrayList<Student>();
        var faker = new Faker();
        var name = faker.name();
        var random = new Random();
        for (int i = 0; i < 20; i++) {
            students.add(new Student(name.firstName(), name.lastName(), random.nextInt(18, 22)));
        }
        students.add(new Student("Akbar", "Akbarov", 20));
        students.add(new Student("Asliddin", "Akbarov", 19));
        students.add(new Student("Asliddin", "Akbarov", 18));
        return students;
    }
}
````

## StudentSort
````java
package collectionsframework.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StudentSort {
    public static void main(String[] args) {
        int[] arr = {3, 12, 4, 5, 6, 77, -12};
        var students = MockData.students();

        for ( Student student : students ) {
            System.out.println(student);
        }
        System.out.println("--------------------------");
        // Arrays.sort(students);
        /*Collections.sort(students, (o1, o2) -> {
                    int i = o1.lastName.compareTo(o2.lastName);
                    if (i == 0) {
                        i = o1.firstName.compareTo(o2.firstName);
                        if (i == 0)
                            return Integer.compare(o1.age, o2.age);
                    }
                    return i;
                }
        );*/
        Collections.sort(students, Comparator.comparing(student -> student.lastName));

        for ( Student student : students ) {
            System.out.println(student);
        }


    }
}
````

