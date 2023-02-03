### We will Need Some Faker Data

download [seeder jar](seeder.java) and run below command

```shell
java -jar seeder.jar
```
### Stream Support For User defined classes

```java
package uz.pdp.declarativeprogramming;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/students.json");
        String jsonDATA = Files.readString(path);
        /*Stream<String> stream = Files.newBufferedReader(path).lines();*/
        Gson gson = new Gson();
        Type type = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> students = gson.fromJson(jsonDATA, type);

        //imperative(students);
        Predicate<Student> studentPredicate = student -> student.getAge() < 21;
        List<Student> studentsUnder21 = students
                .stream()
                .parallel()
                .filter(studentPredicate)
                .filter(student -> student.getGender().equals("MALE"))
                .limit(10)
                .collect(Collectors.toList());
        studentsUnder21.forEach(System.out :: println);

        Stream<String> stringStream = Stream.of("Java", "Python", "Scala");
        stringStream.forEach(System.out :: println);

    }

    private static void imperative(List<Student> students) {
        List<Student> studentsUnder21 = new ArrayList<>();
        int count = 0;
        for ( Student student : students ) {
            if ( student.getAge() < 21 ) {
                studentsUnder21.add(student);
                count = count + 1;
            }
            if ( count == 10 )
                break;
        }

        Consumer<Student> studentConsumer = System.out :: println;
        studentsUnder21.forEach(System.out :: println);
    }
}

```

````java
package uz.pdp.declarativeprogramming;

import java.time.LocalDate;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Item {
    private UUID id = UUID.randomUUID();
    private LocalDate localDate = LocalDate.now();
    public Stream<Object> stream() {
        Spliterator<Object> spliterator = Spliterators.spliterator(new Object[]{id, localDate}, Spliterator.SIZED);
        return StreamSupport.stream(spliterator, false);
    }
    public static void main(String[] args) {
        Item item = new Item();
        item.stream().forEach(System.out :: println);
    }
}
````

````java
package uz.pdp.declarativeprogramming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private int age;
}
````