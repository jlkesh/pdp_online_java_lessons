# Comparator Lesson Source Code
````java
package uz.pdp.compartor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.streamapi.Employee;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class ComparatorExample {
    public static void main(String[] args) throws IOException {
        /*Function<String, Integer> keyExtractor = element -> element.length();
        Stream.of("water-melon", "milk", "berry", "pineapple", "grapes", "apple")
                .sorted(Comparator.comparing(keyExtractor, Comparator.reverseOrder()))
                .forEach(System.out :: println);*/

        /*ToIntFunction<Integer> keyExtractor = (i) -> Math.abs(i);
        Stream.of(-10, 31, 16, -5, 2)
                .sorted(Comparator.comparingInt(keyExtractor))
                .forEach(System.out :: println);*/

        String readString = Files.readString(Path.of("src/main/resources/employees.json"));
        Gson gson = new Gson();
        Type type = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employees = gson.fromJson(readString, type);
        employees.stream()
                .sorted(Comparator
                        .comparing(Employee :: getFull_name)
                        .thenComparing(Employee :: getGender)
                        .thenComparing(Employee :: getAge)
                ).forEach(System.out :: println);

    }
}
````
# Collector Lesson Source Code 
````java
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

````java
package uz.pdp.compartor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.streamapi.Employee;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorExample {
    public static void main(String[] args) throws IOException {
        String readString = Files.readString(Path.of("src/main/resources/employees.json"));
        Gson gson = new Gson();
        Type type = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employees = gson.fromJson(readString, type);
        String xml = employees.stream()
                .collect(new ToXMLCollector());
        System.out.println(xml);
    }
}

class ToXMLCollector implements Collector<Employee, StringBuffer, String> {

    final String xmlstr = """
            \n\t<employee id='%s'>
            \t\t<name>%s</name>
            \t\t<gender>%s</gender>
            \t\t<age>%s</age>
            \t</employee>""";

    public Supplier<StringBuffer> supplier() {
        return StringBuffer :: new;
    }

    public BiConsumer<StringBuffer, Employee> accumulator() {
        return (sb, e) -> sb.append(String.format(xmlstr, e.getId(), e.getFull_name(), e.getGender(), e.getAge()));
    }

    public BinaryOperator<StringBuffer> combiner() {
        return (sb1, sb2) -> sb1.append(sb2.toString());
    }

    public Function<StringBuffer, String> finisher() {
        return sb -> String.format("<employees>%s\n</employees>", sb.toString());
    }

    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }

}
````

# Extra Code Samples(Comparator)
Example 1
````java
Function<String, Integer> keyExtractor = str -> str.length();
Stream.of("grapes", "milk", "pineapple", "water-melon")
    .sorted(Comparator.comparing(keyExtractor))
    .forEach(System.out::println);
````
Example 2
````java
Stream.of("grapes", "milk", "pineapple", "water-melon")
        .sorted(Comparator.comparing(String::length, Comparator.reverseOrder()))
        .forEach(System.out::println);
````
Example 3
````java
Stream.of(-10, 31, 16, -5, 2)
        .sorted(Comparator.comparingInt(i -> Math.abs(i)))
        .forEach(System.out::println);
````
Example 4
````java
 employees.stream()
        .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
        .forEach(System.out::println);
````