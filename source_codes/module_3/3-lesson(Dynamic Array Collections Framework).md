## DynamicIntegerArray

````java
package dynamicarray;

import java.util.Arrays;
import java.util.Objects;

public class DynamicIntegerArray {

    private Integer[] elementData;
    private int size = 0;

    public DynamicIntegerArray() {
        this(10);
    }

    public DynamicIntegerArray(int initialCapacity) {
        this.elementData = new Integer[initialCapacity];
    }

    public boolean add(Integer item) {
        if ( size == elementData.length )
            grow();
        elementData[size++] = item;
        return true;
    }

    public Integer get(int index) {
        Objects.checkIndex(index, elementData.length);
        return elementData[index];
    }

    public Integer remove(int index) {
        Objects.checkIndex(index, elementData.length);
        Integer oldVale = elementData[index];
        int newSize;
        if ( ( newSize = size - 1 ) > index )
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        elementData[size = newSize] = null;
        return oldVale;
    }

    public boolean remove(Integer o) {
        int i = 0;
        found:
        {

            if ( o == null ) {
                for ( ; i < size; i++ ) {
                    if ( elementData[i] == null ) {
                        break found;
                    }
                }
            } else {
                for ( ; i < size; i++ ) {
                    if ( o.equals(elementData[i]) ) {
                        break found;
                    }
                }
            }
            return false;
        }
        remove(i);
        return true;
    }

    private void grow() {
        int newCapacity = elementData.length + elementData.length / 2 + 1;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }

    public static void main(String[] args) {
        DynamicIntegerArray arr = new DynamicIntegerArray(30);
        arr.add(12);
        arr.add(4);
        arr.add(null);
        arr.add(19);
        arr.add(17);
        arr.add(18);
        System.out.println(arr);
        System.out.println(arr.remove(null));
        System.out.println(arr.remove(new Integer(17)));
        System.out.println(arr);
    }

}
````

## DynamicArray<E>

````java
package dynamicarray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

public class DynamicArray<E> implements Iterable<E> {

    public static final int INITIAL_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;

    public DynamicArray() {
        this(INITIAL_CAPACITY);
    }

    public DynamicArray(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public boolean add(E item) {
        if (size == elementData.length)
            grow();
        elementData[size++] = item;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, elementData.length);
        return (E) elementData[index];
    }


    @SuppressWarnings("unchecked")
    public E remove(int index) {
        Objects.checkIndex(index, elementData.length);
        Object oldVale = elementData[index];
        int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        elementData[size = newSize] = null;
        return (E) oldVale;
    }

    public boolean remove(Integer o) {
        int i = 0;
        found:
        {

            if (o == null) {
                for (; i < size; i++) {
                    if (elementData[i] == null) {
                        break found;
                    }
                }
            } else {
                for (; i < size; i++) {
                    if (o.equals(elementData[i])) {
                        break found;
                    }
                }
            }
            return false;
        }
        remove(i);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) Arrays
                .stream(Arrays.copyOf(elementData, size))
                .iterator();
    }

    private void grow() {
        int newCapacity = elementData.length + elementData.length / 2 + 1;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }


    public static void main(String[] args) {

        DynamicArray<String> languages = new DynamicArray<>(5);
        languages.add("Java");
        languages.add("Scala");
        languages.add("C#");
        languages.add("Python");
        for (String language : languages) {
            System.out.println(language);
        }
        System.out.println("-------------------");

        DynamicArray<Student> students = new DynamicArray<>();
        students.add(new Student("Akbar Akbarov"));
        students.add(new Student("Asliddin Abdullayev"));
        for (Student student : students) {
            System.out.println(student);
        }
    }

}


class Student {
    private final String id;
    private final String name;

    Student(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
````

## ListInterfaceTest
````java
package collectionsframework.list;

import java.util.Comparator;
import java.util.List;

public class ListInterfaceTest {
    public static void main(String[] args) {
        List<Integer> integers = List.of(12, 45, 90, 12);
        System.out.println(integers.get(0));
        System.out.println(integers.contains(1));
        System.out.println(integers.indexOf(12));
        System.out.println(integers.lastIndexOf(12));
        System.out.println(integers.isEmpty());
        System.out.println(integers.size());
        integers.sort(Comparator.naturalOrder());
    }
}
````

## ArrayListTest
````java
package collectionsframework.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(123);
        integers1.add(188);
        integers1.add(8);
        integers1.add(176);

        ArrayList<Integer> integers2 = new ArrayList<>(integers1);
        integers2.add(34);
        /*System.out.println(integers2);
        integers2.add(0, 45);
        System.out.println(integers2);
        integers2.set(0, 90);
        System.out.println(integers2);
        integers2.remove(0);
        System.out.println(integers2);
        integers2.remove(new Integer(34));
        System.out.println(integers2);
        integers2.removeAll(integers1);
        System.out.println(integers2);*/

        // integers2.forEach(o -> System.out.println(o));
        // integers2.forEach(System.out::println);
        System.out.println(integers2);
        integers2.sort(Comparator.reverseOrder());
        System.out.println(integers2);
        ArrayList<User> users = new ArrayList<>();

        users.add(new User(30, "User 1"));
        users.add(new User(32, "User 2"));
        users.add(new User(16, "User 3"));
        users.add(new User(13, "User 4"));

        showUsers(users);
        users.sort(Comparator.naturalOrder());
        showUsers(users);

    }

    private static void showUsers(ArrayList<User> users) {
        System.out.println("-----------");
        for (User user : users) {
            System.out.println(user);
        }
    }
}

class User implements Comparable<User> {
    private final String id;
    private final int age;
    private final String name;

    User(int age, String name) {
        this.id = UUID.randomUUID().toString();
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User user) {
        return -1 * Integer.compare(this.age, user.age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
````
## JavaVectorTest

````java
package collectionsframework.list;

import java.util.Vector;

public class JavaVectorTest {
    public static void main(String[] args) {
        Vector<String> languages = new Vector<>();
        languages.add("Java");
        languages.add("Python");
        System.out.println(languages);
    }
}
````


