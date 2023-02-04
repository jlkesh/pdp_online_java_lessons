## SimpleDictionary<K, V>

````java
package collectionsframework.dictionary;

import java.util.Arrays;

public class SimpleDictionary<K, V> {
    private Entry<K, V>[] dictionary;
    private static int DEFAULT_CAPACITY = 16;

    public SimpleDictionary() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SimpleDictionary(int capacity) {
        this.dictionary = new Entry[capacity];
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % dictionary.length;
        var entry = dictionary[index];
        if ( entry == null )
            return null;

        return entry.value;
    }

    public V put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hashCode % dictionary.length;
        dictionary[index] = new Entry<>(key, value);
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(dictionary);
    }

    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "%s=%s".formatted(key, value);
        }
    }
}

````

## SimpleDictionaryTest

````java
package collectionsframework.dictionary;

public class SimpleDictionaryTest {
    public static void main(String[] args) {
        /*
        var dict = new SimpleDictionary<String, String>();
        dict.put("hello", "Assalom alekum");
        dict.put("cat", "Mushuk");
        dict.put("dog", "It");
        System.out.println(dict);
        System.out.println(dict.get("cat"));
        System.out.println(dict.get("hello"));
        System.out.println(dict.get("dog"));
        System.out.println(dict.get("fly"));
        */

        var dict2 = new SimpleDictionary<Integer, String>();
        dict2.put(0, "Java"); // index -> 0, hash -> 0
        dict2.put(16, "Scala"); // index -> 0, hash -> 16
        dict2.put(32, "Groovy"); // index -> 0, hash -> 32
        System.out.println(dict2);
    }
}

````

## Dictionary<K, V>

````java
package collectionsframework.dictionary;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Dictionary<K, V> {
    public static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;


    public Dictionary() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Dictionary(int capacity) {
        this.table = new Node[capacity];
    }

    public V put(K key, V value) {
        int hash = hash(key);
        int index = index(hash);
        var newNode = new Node<>(hash, key, value);
        var node = table[index];
        if ( node == null ) {
            table[index] = newNode;
            return null;
        }
        Node<K, V> prev = null;
        while ( node != null ) {
            if ( node.hash == newNode.hash && Objects.equals(node.key, key) ) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            prev = node;
            node = node.next;
        }
        prev.next = newNode;
        return null;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = index(hash);
        var node = table[index];
        if ( node == null )
            return null;
        while ( node != null ) {
            if ( node.hash == hash && Objects.equals(node.key, key) )
                return node.value;
            node = node.next;
        }
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        var entrySet = new HashSet<Entry<K, V>>();
        for ( Node<K, V> node : table ) {
            while ( node != null ) {
                entrySet.add(new Entry<>(node.key, node.value));
                node = node.next;
            }
        }
        return entrySet;
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private int index(K key) {
        return hash(key) % table.length;
    }

    private int index(int hash) {
        return hash % table.length;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "{", "}");
        for ( Entry<K, V> kvEntry : entrySet() )
            sj.add(kvEntry.toString());
        return sj.toString();
    }

    public record Entry<K, V>(K key, V value) {
        @Override
        public String toString() {
            return "%s=%s".formatted(key, value);
        }
    }

    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

}

````

## DictionaryTest

````java
package collectionsframework.dictionary;

public class DictionaryTest {
    public static void main(String[] args) {
        var dict = new Dictionary<String, String>();
        dict.put("1", "Java");
        dict.put("2", "Go");
        dict.put("3", "Scala");
        dict.put("4", "Groovy");
        for ( Dictionary.Entry<String, String> entry : dict.entrySet() ) {
            System.out.println(entry);
        }
        System.out.println(dict);
    }
}
````

## HashMapClassTest

````java
package collectionsframework.map;

import java.util.HashMap;

public class HashMapClassTest {
    public static void main(String[] args) {
        var hm = new HashMap<String, String>();
        hm.put("1", "Java");
        hm.put("3", "Scala");
        hm.put("2", "Kotlin");
        // System.out.println(hm.get("k"));
        // System.out.println(hm.get("1"));
        // System.out.println(hm.get("2"));
        hm.compute("3", (key, value) -> key + "->" + value);
        hm.computeIfAbsent("4", (key) -> key + " -> new key value inserted");
        hm.computeIfPresent("2", (key, oldValue) -> key + "->" + oldValue);
        // String orDefault = hm.getOrDefault("1", "Default Value");
        // System.out.println("orDefault = " + orDefault);
        // System.out.println(hm);
        // System.out.println(hm.containsKey("k"));
        // System.out.println(hm.containsKey("2"));
        // System.out.println(hm.containsValue("Java"));
        // System.out.println(hm.containsValue("3->Scala"));
        // Set<String> keySet = hm.keySet();
        // keySet.forEach(System.out::println);
        // Collection<String> values = hm.values();
        // values.forEach(System.out::println);
        // Set<Map.Entry<String, String>> entries = hm.entrySet();
        // for (Map.Entry<String, String> entry : entries) {
        //     System.out.println(entry.getKey() + "=" + entry.getValue());
        // }
        hm.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });

    }
}



````

## LinkedHashMapClassTest

````java
package collectionsframework.map;

import java.util.LinkedHashMap;

public class LinkedHashMapClassTest {
    public static void main(String[] args) {
        var lhm = new LinkedHashMap<Integer, String>();
        // var lhm = new HashMap<Integer, String>();
        lhm.put(1, "Java");
        lhm.put(3, "Groovy");
        lhm.put(4, "Scala");
        lhm.put(2, "Kotlin");
        lhm.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}

````

## TreeMapClassTest

````java
package collectionsframework.map;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class TreeMapClassTest {
    public static void main(String[] args) {
        /*var tm = new TreeMap<String, String>();
        tm.put("3", "groovy");
        tm.put("2", "Scala");
        tm.put("1", "Java");
        tm.forEach((k, v) -> System.out.println(k + "=" + v));
        */

        var tm = new TreeMap<Student, String>(Comparator.comparingInt(student -> student.age));
        tm.put(new Student(12, "Akbarov Akbar"), "test data");
        tm.put(new Student(23, "Komilova Nodira"), "test data");
        tm.put(new Student(11, "Jasur Rahmatov"), "test data");
        tm.forEach((k, v) -> System.out.println(k + "=" + v));

    }
}

class Student /*implements Comparable<Student>*/ {
    public int age;
    public String fullName;

    public Student(int age, String fullName) {
        this.age = age;
        this.fullName = fullName;
    }

/*    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.age, student.age);
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
````

# References
## SoftReference
```java
package references;

import java.lang.ref.SoftReference;

public class SoftRef {

    public static void main(String[] args) {
        String language = "english";
        SoftReference<String> softReference = new SoftReference<>(language);
        language = null;
        System.gc();
        String s = softReference.get();
        System.out.println(s);
    }
}
```
## WeakReference
```java
package references;

import java.lang.ref.WeakReference;

public class WeakRef {
    public static void main(String[] args) {
        String language = "english";
        WeakReference<String> weakReference = new WeakReference<>(language);
        language = null;
        System.gc();
        String s = weakReference.get();
        System.out.println(s);
    }
}
```

## WeakHashMapClassTest
```java
package references;

import java.util.WeakHashMap;

public class WeakHashMapClassTest {
    public static void main(String[] args) {
        var whm = new WeakHashMap<String, String>();
        String key = new String("1");
        whm.put(key, "java");
        whm.put("2", "groovy");
        whm.put("3", "Scala");
        key = null;
        System.gc();
        whm.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
```