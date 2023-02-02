import java.time.LocalDate;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {
    public static class Item {
        UUID id = UUID.randomUUID();
        LocalDate localDate = LocalDate.now();

        public Stream<Object> stream() {
            Spliterator<Object> spliterator = Spliterators.spliterator(new Object[]{id, localDate}, Spliterator.SIZED);
            return StreamSupport.stream(spliterator, false);
        }
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.stream().forEach(System.out :: println);
    }
}
