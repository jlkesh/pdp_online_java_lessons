# Comparator
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


# Collector

````java
@AllArgsConstructor
public class Employee {
    public String id;
    public String name;
    public String technology;
    public double salary;
}
````

````java
public class ToXMLCollector implements Collector<Employee, StringBuffer, String> {

    final String xmlstr = """
            \n\t<employee eid='%s'>
            \t\t<name>%s</name>
            \t\t<tech>%s</tech>
            \t\t<salary>%s</salary>
            \t</employee>""";

    public Supplier<StringBuffer> supplier() {
        return StringBuffer :: new;
    }

    public BiConsumer<StringBuffer, Employee> accumulator() {
        return (sb, e) -> sb.append(String.format(xmlstr, e.empid, e.name, e.technology, e.salary));
    }

    public BinaryOperator<StringBuffer> combiner() {
        return (sb1, sb2) -> sb1.append(sb2.toString());
    }

    public Function<StringBuffer, String> finisher() {
        return sb -> String.format("<employees>%s\n</employees>", sb.toString());
    }

    public Set<Characteristics> characteristics() {
        return EnumSet.of(CONCURRENT);
    }

    public static void main(String[] args) {
        Set<Employee> employeeSet = Database.employees();
        String xml = employeeSet.stream().collect(new ToXMLCollector());
        System.out.println(xml);
    }

}
````