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
