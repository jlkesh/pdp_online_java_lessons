## Patient

````java
package collectionsframework.queue;

public class Patient /*implements Comparable<Patient>*/ {
    private String fullName;
    private int priority;

    public Patient(String fullName, int priority) {
        this.fullName = fullName;
        this.priority = priority;
    }

/*
    @Override
    public int compareTo(Patient patient) {
        return Integer.compare(priority, patient.priority) * -1;
    }
*/

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "fullName='" + fullName + '\'' +
                ", priority=" + priority +
                '}';
    }
}

````

## SimpleQueue<E>

````java
package collectionsframework.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class SimpleQueue<E> implements Iterable<E> {
    private Object[] elements;
    private int size = 0;

    public SimpleQueue(int capacity) {
        this.elements = new Object[capacity];
    }

    public boolean enqueue(E element) {
        if (isFull()) return false;
        elements[size++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        E frontElement = (E) elements[0];
        System.arraycopy(elements, 1, elements, 0, size - 1);
        elements[size - 1] = null;
        size--;
        return frontElement;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        this.forEach(e -> sj.add(String.valueOf(e)));
        return sj.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) elements[i++];
            }
        };
    }

    public static void main(String[] args) {
        var q = new SimpleQueue<Integer>(10);

        q.enqueue(12);
        q.enqueue(34);
        q.enqueue(89);
        q.enqueue(9);
//        System.out.println(q);
//        System.out.println(q.size());
        q.forEach(System.out::println);
        System.out.println(q);
    }
}
````

## JavaPriorityQueueTest

````java
package collectionsframework.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaPriorityQueueTest {
    public static void main(String[] args) {
        /*var pq = new PriorityQueue<String>();
        pq.add("Java");
        pq.add("C++");
        pq.add("AA");
        pq.add("Kotlin");
        pq.add("Python");
        System.out.println(pq.peek());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);*/

        var patients = new PriorityQueue<Patient>(
                Comparator.comparingInt(Patient::getPriority).reversed()
        );
        patients.add(new Patient("Akbar Akbarov", 2));
        patients.add(new Patient("Asliddin Abdullayev", 3));
        patients.add(new Patient("Karimov Javlon", 5));
        System.out.println(patients.poll());
    }
}

````
