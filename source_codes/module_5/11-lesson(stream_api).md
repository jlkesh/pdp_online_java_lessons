### We will Need Some Faker Data

download [seeder.jar](https://github.com/jlkesh/pdp_online_java_lessons/raw/main/jars/seeder.jar) and run below command to generate some random data

```shell
java -jar seeder.jar
```

or you can download some already generated data [here](https://github.com/jlkesh/pdp_online_java_lessons/raw/main/jars/employees.json)


````java
package uz.pdp.streamapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.declarativeprogramming.Item;

import java.io.DataInput;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamAPIOperatorsExample {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/employees.json");
        String jsonDATA = Files.readString(path);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employeeList = gson.fromJson(jsonDATA, type);
        /*int[] numbers = {12, 5, 6, 7, 8, 90};
        IntStream stream = Arrays.stream(numbers);
        IntPredicate predicate = (i) -> i % 2 == 0;
        stream.filter(predicate)
                .forEach(System.out :: println);*/
        /*Predicate<Employee> filterByGender = employee -> employee.getGender().equals("FEMALE");
        Predicate<Employee> filterByAge = employee -> employee.getAge() > 29;
        Predicate<Employee> employeePredicate = filterByAge.and(filterByGender);
        employeeList.stream()
                *//*.filter(filterByAge)
                .filter(filterByGender)*//*
                .filter(employeePredicate)
                .skip(33)
                .limit(5)
                .peek(System.out :: println)
                .toList();*/
        //.forEach(System.out :: println);

        /*Stream<Integer> integerStream = Stream.of(11, 3, 4, 7);
        boolean anyMatch = integerStream.anyMatch((i) -> i % 2 == 0);
        System.out.println("anyMatch = " + anyMatch);

        integerStream = Stream.of(12, 4, 4, 8);
        boolean allMatch = integerStream.allMatch((i) -> i % 2 == 0);
        System.out.println("allMatch = " + allMatch);

        integerStream = Stream.of(19, 17, 3, 7);
        boolean nonMatch = integerStream.noneMatch((i) -> i % 2 == 0);
        System.out.println("nonMatch = " + nonMatch);*/

        /*
        Stream<Employee> employeeStream = employeeList.stream();
        Stream<EmpInfo> empInfoStream = employeeStream
                .map(employee -> new EmpInfo(employee.getFull_name(), employee.getAge()));
        // empInfoStream.forEach(System.out :: println);
        IntStream integerStream = empInfoStream.mapToInt(employee -> employee.age());
        // Stream<Integer> = IntStream
        integerStream.forEach(System.out :: println);
        */
        List<Book> javaBooks = new ArrayList<>();
        javaBooks.add(new Book("1", "Concurrency in Practise"));
        javaBooks.add(new Book("2", "Modern Java In Action"));

        /*List<Book> postgresqlBook = new ArrayList<>();
        postgresqlBook.add(new Book("5", "Postgresql 14 Administration"));
        postgresqlBook.add(new Book("6", "SQL for Dummies"));

        List<List<Book>> lists = List.of(javaBooks, postgresqlBook);
        Stream<Book> streamStream = lists
                .stream()
                .flatMap(books -> books.stream());
        streamStream.forEach(System.out :: println);*/
        /*.map(books -> books.stream());*/

        /*javaBooks.parallelStream()
                .filter(book -> book.id().equals("2"))
                .findAny()
                .ifPresentOrElse(
                        book -> System.out.println(book.name()),
                        () -> System.out.println("Not Found"));
        */
        /*Stream<String> stringStream = Stream.of("Java", "Scala", "Kotlin", "Groovy", "Python");*/
        // Stream<String> stringStream = Stream.of();
        /*stringStream.reduce((language1, language2) -> language1 + ", " + language2)
                .ifPresentOrElse(lang-> System.out.println(lang),
                        ()-> System.out.println("No items found"));*/
        /*String[] array = stringStream.toArray(String[] :: new);
        System.out.println(Arrays.toString(array));*/


        /*Stream.iterate(1, (x) -> x + 1)
                .limit(100)
                .forEach(System.out :: println);
        */

        /*Stream.generate(UUID :: randomUUID)
                .limit(10)
                .forEach(System.out :: println);*/

    }
}


record EmpInfo(String fullName, int age) {
}

record Book(String id, String name) {
}
````

````java
package uz.pdp.streamapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private int id;
    private String full_name;
    private String gender;
    private int age;
}
````

