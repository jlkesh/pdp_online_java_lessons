# Lesson Source Code
````java
package uz.pdp.precollectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.streamapi.Employee;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.DoubleSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PreCollectorsExample {
    public static void main(String[] args) throws IOException {
        List<String> stringList = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .map(String :: toUpperCase)
                //.toList();
                .collect(Collectors.toList());

        Set<String> stringSet = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .map(String :: toUpperCase)
                .collect(Collectors.toSet());

        TreeSet<String> treeSet = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .map(String :: toUpperCase)
                .collect(Collectors.toCollection(TreeSet :: new));

        Map<String, Integer> integerMap = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy", "JaVa")
                .map(String :: toUpperCase)
                //.collect(Collectors.toMap(String :: toLowerCase, String :: length));
                .collect(Collectors.toMap(String :: toLowerCase, String :: length, (k1, k2) -> k1));

        BiConsumer<String, Integer> stringIntegerBiConsumer = (k, v) -> System.out.println(k + "::" + v);
        /*integerMap.forEach(stringIntegerBiConsumer);*/
        String joinedString = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy", "JaVa")
                .map(String :: toUpperCase)
                .collect(Collectors.joining(", ", "[", "]"));
        /*System.out.println(joinedString);*/

        String readString = Files.readString(Path.of("src/main/resources/employees.json"));
        Gson gson = new Gson();
        Type type = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employees = gson.fromJson(readString, type);

        /*Map<Integer, List<Employee>> integerListMap = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getAge()));
        integerListMap.forEach((k,v)->{
            System.out.println(k);
            for ( Employee employee : v ) {
                System.out.println("\t\t\t"+employee);
            }
        });*/
        /*Map<Integer, Long> integerLongMap = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getAge(), Collectors.counting()));
        integerLongMap.forEach((k, v) -> System.out.println(k + " : " + v));*/

        /*Map<Boolean, Long> booleanListMap = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getGender().equals("MALE"),Collectors.counting()));

        booleanListMap.forEach((k, v) -> {
            System.out.print("Key Is :" + k);
            System.out.println(" Value Is :" + v);

        });*/


        /*Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .collect(Collectors.reducing((l1, l2) -> l1 + ", " + l2))
                .ifPresentOrElse(
                        (r) -> System.out.println(r),
                        () -> System.out.println("There is no Items ")
                );*/

        /*employees.stream()
                .collect(Collectors.minBy(Comparator.comparing(Employee :: getAge)))
                .ifPresentOrElse(
                        (r) -> System.out.println(r),
                        () -> System.out.println("There is no Items ")
                );*/

        /*double collect = employees.stream()
                .collect(Collectors.averagingDouble(employee -> employee.getAge()));
        System.out.println(collect);*/

        DoubleSummaryStatistics statistics = employees
                .stream()
                .collect(Collectors.summarizingDouble(Employee :: getAge));

        /*System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println("statistics.getSum() = " + statistics.getSum());
        System.out.println("statistics.getCount() = " + statistics.getCount());
        System.out.println("statistics.getMax() = " + statistics.getMax());
        System.out.println("statistics.getMin() = " + statistics.getMin());*/

        /*Stream<Integer> integerStream = Stream.of(12, 34, 56);*/
        // IntStream range = IntStream.of();
        IntStream range = IntStream.rangeClosed(1, 10);
        //range.forEach(System.out :: println);
        /*Optional<Double> aDouble = Optional.of(12D);*/
        OptionalDouble average = range.average();
        DoubleSupplier doubleSupplier = () -> 2D;
        System.out.println(average.orElseGet(doubleSupplier));
        Stream<Integer> boxed = range.boxed();
    }
}
````

# Extra Code Samples
### Example toList()
````java
List<String> list = Stream.of("java", ".net", "python")
          .map(String::toUpperCase).collect(Collectors.toList());
````
### Example toSet()
HashSet
````java
Set<String> set = Stream.of("java", ".net", "python")
        .map(String::toUpperCase).collect(Collectors.toSet());
````
### Example toSet()
TreeSet
````java
TreeSet<String> set = Stream.of("java", ".net", "python").map(String::toUpperCase)
        .collect(Collectors.toCollection(TreeSet::new));
````


### Example toMap()
````java
Map<String, Integer> result = Stream
        .of("java", ".net", "python", "jAvA")
        .collect(Collectors.toMap(String :: toUpperCase, String :: length));
````

### Example toMap()
overloaded
````java
Map<String, Integer> result = Stream
        .of("java", ".net", "python", "jAvA")
        .collect(Collectors.toMap(String :: toUpperCase, String :: length, (value1, value2) -> value1 + ( value2 * 2 )));
````

### Example joining
````java
Stream.of("java", ".net", "python").collect(joining(", ", "Joined String[ ", " ]"));
````

### Example groupBy
````java
Map<Integer, List<Employee>> map = employees.stream()
            .collect(Collectors.groupingBy(Employee :: getAge));
````

````java
Map<Integer, Long> map = employees.stream()
        .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
````
### Example 
partitionBy
````java
Map<Boolean, Long> collect = Stream.of("java", ".net", "python", "jAvA")
          .collect(Collectors.partitioningBy(o -> o.length() > 4, Collectors.counting()));
````
