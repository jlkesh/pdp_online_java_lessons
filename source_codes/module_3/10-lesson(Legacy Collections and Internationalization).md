# Legacy Collections

## Stack

````java
package collectionsframework.legacycollections;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class Stack<E> implements Iterable<E> {
    public static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        this.elements = new Object[capacity];
    }

    public E push(E element) {
        if ( isFull() )
            throw new StackOperationException("Stack is full");
        elements[size++] = element;
        return element;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if ( isEmpty() )
            throw new StackOperationException("Stack is empty");
        return (E) elements[size - 1];
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if ( isEmpty() )
            throw new StackOperationException("Stack is empty");
        E removedElement = (E) elements[size - 1];
        elements[--size] = null;
        return removedElement;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        this.forEach(e -> sj.add(Objects.toString(e)));
        return sj.toString();

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return size > current;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) elements[current++];
            }
        };
    }

    public static class StackOperationException extends RuntimeException {
        public StackOperationException(String message) {
            super(message);
        }
    }
}
````

## CustomStackClassTest

````java
package collectionsframework.legacycollections;

public class CustomStackClassTest {
    public static void main(String[] args) {
        var stack = new Stack<String>(10);
        stack.push("Java");
        stack.push("Pascal");
        stack.push("Delphi");
        stack.push("BASIC");
        stack.push("Kotlin");
        // for (String s : stack) {
        //     System.out.println(s);
        // }
        System.out.println(stack);
    }
}
````

## Java StackClass Test

````java
package collectionsframework.legacycollections;

import java.util.Stack;

public class StackClassTest {
    public static void main(String[] args) {
        var stack = new Stack<String>();
        stack.push("Java");
        stack.push("Pascal");
        stack.push("Delphi");
        stack.push("BASIC");
        stack.push("Kotlin");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
````

## Java StackClass Test

````java
package collectionsframework.legacycollections;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClassTest {

    public static void main(String[] args) {
        try {
            // readFromDotProperties();
            var properties = new Properties();
            var propertiesFilePath = "src/collectionsframework/legacycollections/config.xml";
            var fileInputStream = new FileInputStream(propertiesFilePath);
            properties.loadFromXML(fileInputStream);
            // System.out.println(properties.getProperty("database.database_name"));
            properties.forEach((k, v) -> System.out.println(k + "=" + v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromDotProperties() throws IOException {
        var properties = new Properties();
        var propertiesFilePath = "src/collectionsframework/legacycollections/config.properties";
        var fileReader = new FileReader(propertiesFilePath);
        properties.load(fileReader);
        // Object o = properties.get("datasource.username");
        // var username = properties.getProperty("datasource.username2", "default_username");
        // var password = properties.getProperty("datasource.password");
        // System.out.println(username);
        // System.out.println(password);
        // var message = properties.getProperty("message");
        // System.out.println(message);
        properties.forEach((k, v) -> System.out.println(k + "=" + v));
    }

}
````

## config.properties

````properties
datasource.username=postgres
datasource.password=123
message=Lorem ipsum dolor sit amet, consectetur adipisicing elit. \
    Autem dignissimos eos eveniet ex fuga hic itaque, laboriosam minus\
    necessitatibus, nesciunt non odit omnis quas quos, repellendus sit vero?\
    Beatae blanditiis consequatur consequuntur dignissimos dolor \
    dolore dolorem dolorum enim est exercitationem, facere fuga fugit id \
    impedit in ipsam libero modi mollitia nemo nisi obcaecati quo quod
# comments some
````

## config.xml

````xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
    <entry key="database.url">jdbc:postgresql</entry>
    <entry key="database.username">postgres</entry>
    <entry key="database.password">123</entry>
    <entry key="database.database_name">pdpdb</entry>
</properties>
````

## HashtableClassTest

````java
package collectionsframework.legacycollections;

import java.util.HashMap;
import java.util.Hashtable;

public class HashtableClassTest {
    public static void main(String[] args) {
        var ht = new Hashtable<Integer, String>();
        var hm = new HashMap<Integer, String>();
        ht.put(1, "Java");
        ht.put(2, "Scala");
        hm.put(3, "Groovy");
        System.out.println(ht);
        String s = ht.get(1);
        System.out.println(s);
    }
}
````

# Internationalization

## I18N

````java
package i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class I18N {
    public static void main(String[] args) {
        Locale english = Locale.US;
        Locale fr = Locale.FRENCH;
        Locale japan = Locale.JAPAN;
        Locale it = Locale.ITALIAN;
        Locale uz = Locale.forLanguageTag("uz");
        // playWithLocalClass(english, fr, japan, it, uz);
        // testDateFormatI18N(fr);
        // testDateFormatI18N(japan);
        // testDateFormatI18N(english);
        // testDateFormatI18N(uz);
        // testDateFormatI18N(it);

        // testNumberI18N(fr);
        // testNumberI18N(japan);
        // testNumberI18N(english);
        // testNumberI18N(uz);
        // testNumberI18N(it);

        // testCurrencyI18N(fr);
        // testCurrencyI18N(english);
        // testCurrencyI18N(japan);
        // testCurrencyI18N(uz);
        // testCurrencyI18N(it);
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);
        Locale.setDefault(Locale.JAPAN);

        aDefault = Locale.getDefault();
        System.out.println(aDefault);
    }

    private static void testCurrencyI18N(Locale fr) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(fr);
        double d = 100200.91;
        String format = currencyInstance.format(d);
        System.out.println(format);
    }

    private static void testNumberI18N(Locale fr) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(fr);
        double d = 123045.921;
        String format = numberInstance.format(d);
        System.out.println(format);
    }

    private static void testDateFormatI18N(Locale fr) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, fr);
        String format = dateFormat.format(new Date());
        System.out.println(format);
    }

    private static void playWithLocalClass(Locale english, Locale fr, Locale japan, Locale it, Locale uz) {
        // Locale uz = new Locale("uz", "UZB");
        Locale us = new Locale("en", "US");
        // Locale kz = Locale.forLanguageTag("kz");

        System.out.println(english.getDisplayLanguage(fr));
        System.out.println(english.getDisplayLanguage(japan));
        System.out.println(english.getDisplayLanguage(it));
        System.out.println(english.getDisplayLanguage(uz));
        System.out.println(english.getCountry());
    }
}
````

## User

````java
package i18n;

import java.util.List;
import java.util.Locale;

public record User(String username, Locale locale) {
    public static List<User> users = List.of(
            new User("user1", Locale.forLanguageTag("uz")),
            new User("user2", Locale.ENGLISH),
            new User("user3", Locale.FRANCE)
    );
}
````

## UI

````java
package i18n;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
       /* // login
        // messages_en.properties | login -> Login
        // messages_uz.properties | login -> Kirish
        // messages_fr.properties | login -> Connexion
        // ResourceBundle, Locale.FRENCH
        // magic.get("login", FRENCH);
        var fr = ResourceBundle.getBundle("messages", Locale.FRENCH);
        System.out.println(fr.getString("login"));
        var us = ResourceBundle.getBundle("messages", Locale.US);
        System.out.println(us.getString("login"));
        var uz = ResourceBundle.getBundle("messages", Locale.forLanguageTag("uz"));
        System.out.println(uz.getString("login"));*/
        while ( true ) {
            String username = login();
            var bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
            System.out.println(bundle.getString("welcome").formatted(username));
        }
    }

    private static String login() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("username : ");
        String username = scanner.nextLine();
        for ( User user : User.users ) {
            if ( user.username().equals(username) ) {
                Locale.setDefault(user.locale());

            }
        }
        return username;
    }
}
````