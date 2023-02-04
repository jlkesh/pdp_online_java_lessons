## SinglyLinkedList<E>

````java
package collectionsframework.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class SinglyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private int size;


    public boolean add(E element) {
        var newNode = new Node<>(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            var current = this.head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        this.size++;
        return true;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index == 0)
            return head.element;

        var current = head;

        for (int i = 1; i <= index; i++)
            current = current.next;

        return current.element;
    }

    public boolean addAtBeginning(E element) {
        var newNode = new Node<>(element);
        if (head != null)
            newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public E removeFromBeginning() {
        if (head == null)
            throw new NoSuchElementException("LinkedList is empty");
        E element = head.element;
        head = head.next;
        size--;
        return element;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) return removeFromBeginning();
        var current = head;
        for (int i = 1; i < index; i++)
            current = current.next;
        var element = current.next.element;
        current.next = current.next.next;
        return element;
    }

    public boolean remove(Object o) {
        if (head == null) return false;
        Node<E> prev = null;
        Node<E> current = head;

        while (current != null) {
            if (Objects.equals(o, current.element)) {
                if (prev == null)
                    head = current.next;
                else
                    prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }


    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        var current = this.head;
        while (current != null) {
            sj.add(String.valueOf(current.element));
            current = current.next;
        }
        return sj.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    public static void main(String[] args) {
        var sll = new SinglyLinkedList<String>();
        /*
         size(); // done
         get(index); // done
         addAtBeginning(element); // done
         remove(obj); // remove
         remove(index); // done
         removeFromBeginning(); // done
         set(index, element); // done
         */
        sll.add("Java");
        sll.add("Scala");
        sll.add("Python");
        sll.add("Kotlin");
        sll.add("Groovy");
        // System.out.println(sll.addAtBeginning("C++"));
        // System.out.println(sll.addAtBeginning("Groovy"));
        // System.out.println(sll);
        // System.out.println(sll.removeFromBeginning());
        // System.out.println(sll.removeFromBeginning());
        // System.out.println(sll.removeFromBeginning());
        //System.out.println(sll.remove(null));
        // System.out.println(sll);

        for (String lang : sll) {
            System.out.println(lang);
        }
        // sll.forEach(System.out::println);

    }
}

````

## DoublyLinkedList<E>

````java
package collectionsframework.linkedlist;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class DoublyLinkedList<E> implements Iterable<E> {


    private Node<E> head;
    private Node<E> tail;
    private int size;

    public boolean add(E element) {
        var l = tail;
        var newNode = new Node<>(element);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
            newNode.prev = l;
        }
        size++;
        return true;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index == 0)
            return head.element;

        Node<E> current = null;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current.element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        this.forEach(lang -> sj.add(String.valueOf(lang)));
        return sj.toString();
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        var dll = new DoublyLinkedList<String>();
        dll.add("Java");
        dll.add("C++");
        dll.add("Python");
        dll.add("Go");
        dll.add("Scala");
        dll.add("Kotlin");
        System.out.println(dll);
        System.out.println(dll.get(4));
    }

}

````

## JavaLinkedListTest

````java
package collectionsframework.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class JavaLinkedListTest {
    public static void main(String[] args) {
        var programmingLanguages = new LinkedList<String>();
        programmingLanguages.add("Python");
        programmingLanguages.add("Java");

        var languages = new LinkedList<String>();
        languages.add(0, "Scala");
        languages.add("Kotlin");
        languages.add("Groovy");
        languages.addAll(2, programmingLanguages);
        System.out.println(languages);

        languages.addFirst("Go");
        languages.addLast("C");
        languages.add("Kotlin");
        System.out.println(languages);
        // languages.clear();
        languages.removeLastOccurrence("Kotlin");
        System.out.println(languages);
        String[] objects = languages.toArray(String[]::new);
        System.out.println(Arrays.toString(objects));

    }
}

````

## AnalyzeLinkedListAndArrayList

````java
package collectionsframework.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class AnalyzeLinkedListAndArrayList {
    public static void main(String[] args) {
        var arrayList = new ArrayList<Integer>();
        var linkedList = new LinkedList<Integer>();

        final var max_element_count = 100_000;

        var start = System.currentTimeMillis();
        addToArrayList(arrayList, max_element_count);
        var end = System.currentTimeMillis();
        System.out.println("array list - " + (end - start));

        start = System.currentTimeMillis();
        addToLinkedList(linkedList, max_element_count);
        end = System.currentTimeMillis();
        System.out.println("linked list - " + (end - start));

        start = System.currentTimeMillis();
        removeFromBeginningArrayList(arrayList);
        end = System.currentTimeMillis();
        System.out.println("array list (remove) - " + (end - start));

        start = System.currentTimeMillis();
        removeFromBeginningLinkedList(linkedList);
        end = System.currentTimeMillis();
        System.out.println("linked list (remove) - " + (end - start));


    }

    private static void addToLinkedList(LinkedList<Integer> linkedList, int max_element_count) {
        for (int i = 0; i < max_element_count; i++) {
            linkedList.add(0, i);
        }
    }

    private static void addToArrayList(ArrayList<Integer> arrayList, int max_element_count) {
        for (int i = 0; i < max_element_count; i++) {
            arrayList.add(0, i);
        }
    }

    private static void removeFromBeginningLinkedList(LinkedList<Integer> linkedList) {
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(0);
        }
    }

    private static void removeFromBeginningArrayList(ArrayList<Integer> arrayList) {
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(0);
        }
    }
}

````