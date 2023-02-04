# Algorithms
## SimpleAlgorithm

````java
package collectionsframework.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class SimpleAlgorithm {
    public static void main(String[] args) {

        var numbers = new ArrayList<Integer>();

        for ( int i = 0; i < 10; i++ ) {
            numbers.add((int) ( Math.random() * 5 ));
        }
        System.out.println(numbers);
        Integer min = Collections.min(numbers);
        System.out.println(min);
        Integer max = Collections.max(numbers);
        System.out.println(max);
        Predicate<Integer> predicate = (number) -> number < 0;
        numbers.removeIf(predicate);
        System.out.println(numbers);
        Collections.reverse(numbers);
        System.out.println(numbers);
        int frequency = Collections.frequency(numbers, 3);
        System.out.println(frequency);
        boolean disjoint = Collections.disjoint(numbers, List.of(6, 7, 8, 1));
        System.out.println(disjoint);
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println(numbers);
        Collections.shuffle(numbers);
        System.out.println(numbers);

    }
}
````

## ArrayAlgorithms

````java
package collectionsframework.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class ArrayAlgorithms {
    public static void main(String[] args) {
        var languages = new String[]{"Java", "GO", "Groovy"};
        List<String> languagesList = List.of(languages);
        System.out.println(languagesList);
        String[] objects = languagesList.toArray(String[] :: new);
        System.out.println(Arrays.toString(objects));
        int go = Collections.binarySearch(languagesList, "GaO");
        System.out.println(go);
    }
}
````
# Optional
## Card
````java
package optional;

public record Card (String holderName, String pan, String expiry){}
````

## WithoutOptional

````java
package optional;

import java.util.Optional;
import java.util.Random;

public class WithoutOptional {

    public static void main(String[] args) {
        Optional<Card> cardOptional = findCardByPan("9860 **** **** ****");
        Card card2 = findCardByPan2("9860 **** **** ****");

        if (card2 == null) {
            System.out.println("UNKNOWN");
        } else {
            System.out.println(card2.holderName());
        }

        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            System.out.println(card.holderName());
        } else {
            System.out.println("UNKNOWN");
        }
    }

    static Optional<Card> findCardByPan(String pan) {
        var random = new Random();
        if (random.nextBoolean())
            return Optional.of(new Card("Elmurodov Javohir", pan, "01/26"));
        return Optional.empty();
    }

    static Card findCardByPan2(String pan) {
        var random = new Random();
        if (random.nextBoolean())
            return new Card("Elmurodov Javohir", pan, "01/26");
        return null;
    }
}
````

## OptionalClassTest

````java
package optional;

import javax.management.RuntimeOperationsException;
import java.util.Optional;
import java.util.Random;

public class OptionalClassTest {
    // private Optional<String> ddd; // do not  use this

    public static void main(String[] args/*, Optional<String> param*/) {
        // param is null
        // param is empty
        // param is present
        /*Optional<Object> empty = Optional.empty();
        System.out.println(empty.isEmpty());
        System.out.println(empty.isPresent());
        Optional<String> string = Optional.of("String");
        System.out.println(string.isEmpty());
        System.out.println(string.isPresent());
        Optional<String> stringOptional = Optional.ofNullable(null);
        System.out.println(stringOptional.isEmpty());
        System.out.println(stringOptional.isPresent());*/
        var card = new Card("Elmurodov Javohir", "9869 **** **** ****", "01/26");
        var unknown = new Card("UNKNOWN", "xxxx xxxx xxxx xxxx", "mm/yy");
        var random = new Random();
        Optional<Card> cardOptional = Optional.ofNullable(random.nextBoolean() ? card : null);
        /*Card card2 = cardOptional.orElse(unknown);
        System.out.println(card2);*/
        /*cardOptional.ifPresent((element)->{
            System.out.println(element);
        });*/

        /*cardOptional.ifPresentOrElse(
                (element) -> {
                    System.out.println(element);
                },
                () -> {
                    System.out.println(unknown);
                }
        );*/
        var card3 = cardOptional
                .orElseThrow(() -> new RuntimeException("Card not found"));
        System.out.println(card3);

    }
}
````
# SOLID
 <details>
<summary>Single Responsibility</summary>

**Without Single Responsibility**

````java
package solid.without.srp;

public class User {
    private String username;
    private String email;
    private String age;

    // getters and setter

    public void save(User user) {
        // connect to Database
        // persist to Database
    }

    public void remove(User user) {
        // connect to Database
        // remove from Database
    }

    public User get(String username) {
        // connect to Database
        // get from Database
        return null;
    }

    public void logToExcel(User user){

    }
    public void logToTxt(User user){

    }

    public Object generateAsPDF(){
        return null;
    }

    public Object generateAsDoc() {
        return null;
    }
}
````
**With Single Responsibility**

````java
package solid.with.srp;

public class User {
    private String username;
    private String email;
    private String age;
    // getters and setter
}
````

````java
package solid.with.srp;

public class LogService {
    public void logToExcel(User user) { }
    public void logToTxt(User user) { }
}
````

````java
package solid.with.srp;

public class UserRepository {
    public void save(User user) {
        // getConnection();
        // persist to Database
    }

    public void remove(User user) {
        // getConnection();
        // remove from Database
    }

    public User get(String username) {
        // getConnection();
        // get from Database
        return null;
    }

    public Object getConnection() {
        return null;
    }

}
````

````java
package solid.with.srp;

public class GeneratorService {
    public Object generateAsPDF() {
        return null;
    }
    public Object generateAsDoc() {
        return null;
    }
}
````
</details>

<details>
<summary>Open Close</summary>

**Without Open Close**

````java
public class TransferService {
    public boolean transfer(Transfer transfer) {
        if (transfer.transactionType().equals("uzcard_humo")) {
            // .............. write code here
        } else if (transfer.transactionType().equals("humo_uzcard")) {
            // .............. write code here
        }
        return true;
    }
}
````
````java
public record Transfer (String sender, String receiver, String transactionType, String amount){
}
````

**With Open Close**

````java
public record Transfer (String sender, String receiver, String transactionType, String amount){
}
````



````java
public interface TransferService {
    boolean transfer(Transfer transfer);
}
````

````java
public class UzcardHumoTransferService implements TransferService {
    @Override
    public boolean transfer(Transfer transfer) {
        // ........................
        return false;
    }
}
````

````java
public class HumoUzcardTransferService implements TransferService{
    @Override
    public boolean transfer(Transfer transfer) {
        // ....................
        return false;
    }
}
````
````java
public class Main {
    public static void main(String[] args) {
        TransferService transferService1 = new HumoUzcardTransferService();
        TransferService transferService2 = new UzcardHumoTransferService();
    }
}
````
</details>

<details>
<summary>Liskov Substitution</summary>

**Without Liskov Substitution**

````java
package solid.without.lsp;

public interface Database {
    void save();

    void delete();

    Object get();

    void createTable();
}


class PostgresqlDatabase implements Database {
    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public void createTable() {
        System.out.println("Table created");
    }
}

class MongoDatabase implements Database {
    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public void createTable() {
        throw new RuntimeException("MongoDB does not have table");
    }
}
````
````java
package solid.without.lsp;

public class Test {
    public static void main(String[] args) {
        call(new PostgresqlDatabase());
        call(new MongoDatabase());
    }

    static void call(Database database) {
        database.createTable();
    }
}
````

**With Liskov Substitution**

````java
package solid.with.lsp;

public interface Database {
    void save();
    void delete();
    Object get();
}
````

````java
package solid.with.lsp;

public interface NoSQLDatabase extends Database {
    void createCollection();
}
````

````java
package solid.with.lsp;

public interface RelationalDatabase extends Database {
    void createTable();
}
````
````java
package solid.with.lsp;

public class MongoDatabase implements NoSQLDatabase {
    @Override
    public void save() {
        System.out.println("Document saved to collection");
    }

    @Override
    public void delete() {
        System.out.println("Document deleted from collection");
    }

    @Override
    public Object get() {
        return "Document returned";
    }

    @Override
    public void createCollection() {
        System.out.println("Collection created");
    }
}
````
````java
package solid.with.lsp;

public class MongoDatabase implements NoSQLDatabase {
    @Override
    public void save() {
        System.out.println("Document saved to collection");
    }

    @Override
    public void delete() {
        System.out.println("Document deleted from collection");
    }

    @Override
    public Object get() {
        return "Document returned";
    }

    @Override
    public void createCollection() {
        System.out.println("Collection created");
    }
}
````
````java
package solid.with.lsp;

public class PostgresqlDatabase implements RelationalDatabase {
    @Override
    public void save() {
        System.out.println("Saved to table");
    }

    @Override
    public void delete() {
        System.out.println("Deleted from table");
    }

    @Override
    public Object get() {
        return "Row returned";
    }

    @Override
    public void createTable() {
        System.out.println("Table created");
    }
}
````
````java
package solid.with.lsp;

public class Test {
    public static void main(String[] args) {
        call(new PostgresqlDatabase());
        call(new MongoDatabase());
    }

    static void call(Database database) {
        database.save();
        database.delete();
        System.out.println(database.get());
    }
}
````

</details>



<details>
<summary>Interface Segregation</summary>

````java
package solid.with.isp;

public interface A1 {
    void m1();
}

interface A2 {
    void m2();
}

interface A3 {
    void m3();
}

class B implements A1, A3 {
    @Override
    public void m1() {

    }

    @Override
    public void m3() {

    }
}

class C implements A2 {
    @Override
    public void m2() {

    }
}

class D implements A1, A2 {
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }
}
````
</details>

<details>
<summary>Dependency Aggregation</summary>

````java
package solid.without.dip;

public interface Keyboard {
}
````

````java
package solid.without.dip;

public class Computer {
    String cpu;
    String maker;
    Keyboard keyboard;

    public Computer(String cpu, String maker, Keyboard keyboard) {
        this.cpu = cpu;
        this.maker = maker;
        this.keyboard = keyboard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}

````

````java
package solid.without.dip;

public record SimpleKeyboard() implements Keyboard {
}
````
````java
package solid.without.dip;

public record RGBKeyboard() implements Keyboard {
}
````
````java
package solid.without.dip;

public class MagicKeyboard implements Keyboard{
}
````
````java
package solid.without.dip;

public class Test {
    public static void main(String[] args) {
        SimpleKeyboard keyboard = new SimpleKeyboard();
        Computer computer = new Computer("Core i9", "hp", keyboard);
        RGBKeyboard keyboard1 = new RGBKeyboard();
        computer.setKeyboard(keyboard1);
        MagicKeyboard keyboard2 = new MagicKeyboard();
        computer.setKeyboard(keyboard2);
    }
}
````

</details>