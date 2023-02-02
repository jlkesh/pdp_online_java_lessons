### We will Need Some Faker Data

download [sds](seeder.java) and run below command

```shell
java -jar seeder.jar
```
### Stream Support For User defined classes

```java
public static class Item {
    UUID id = UUID.randomUUID();
    LocalDate localDate = LocalDate.now();

    public Stream<Object> stream() {
        Spliterator<Object> spliterator = Spliterators.spliterator(new Object[]{id, localDate}, Spliterator.SIZED);
        return StreamSupport.stream(spliterator, false);
    }
}
```