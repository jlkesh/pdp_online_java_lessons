````java
import java.util.Random;
import java.util.Scanner;

public class StringFormatTest {
    public static void main(String[] args) {
        System.out.print("Enter name : ");
        String name = new Scanner(System.in).nextLine();
        int age = new Random().nextInt(10, 30);
        /*String pattern = "Hello %S, are you %d years old ?";
        String message = String.format(pattern, name, age);
        System.out.println(message);*/
        String pattern = "Hello %S, are you %d years old ?";
        // String message = pattern.formatted(name, age);
        /*String message = "Hello %S, are you %d years old ?"
                .formatted(name, age);*/
        String message = "Hello " + name + ", are you " + age + " years old ?";
        System.out.println(message);


    }
}
````

````java
import java.util.Locale;

public class NumberFormatOutput {
    public static void main(String[] args) {
        System.out.printf("%,d %n", 1000000);
        System.out.printf(Locale.US, "%,d %n", 1000000);
        System.out.printf(Locale.CANADA, "%,d %n", 1000000);
        System.out.printf(Locale.GERMAN, "%,d %n", 1000000);
        System.out.printf(Locale.FRENCH, "%,d %n", 1000000);
    }
}
````

````java
public class MessageFormatTest {
    public static void main(String[] args) {
        System.out.print("Enter name : ");
        String name = new Scanner(System.in).nextLine();
        int age = new Random().nextInt(10, 30);
        String message = MessageFormat.format("Hello {1}, are you {0} years old ?", name, age);
        System.out.println(message);
    }
}
````

````java
public class DateFormatOutput {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.printf(Locale.ITALY, "%tB %n", date);
        System.out.printf(Locale.ITALY, "%tb %n", date);
        System.out.printf(Locale.CHINA, "%tB %n", date);
        System.out.printf(Locale.CHINA, "%tb %n", date);
        System.out.printf("%tB/%<tA %n", date);
        System.out.printf("%TB/%<Ta %n", date);
        System.out.printf("%tY %n", date);
        System.out.printf("%ty %n", date);
        System.out.printf("%tj %n", date);
        System.out.printf("%tm %n", date);
        System.out.printf("%td %n", date); // 04
        System.out.printf("%te %n", date); // 4
        System.out.printf("%td/%<tm/%<ty %n", date);
        System.out.printf("%tD %n", date);
        System.out.printf("%td-%<tm-%<tY %<tH:%<tM:%<tS %n", date);

    }
}
````

````java
import java.util.Date;

public class TimeFormat {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.printf("%tH %n", date);
        System.out.printf("%tM %n", date);
        System.out.printf("%tS %n", date);
        System.out.printf("%tH:%<tM:%<tS:%<tL %n", date);
        System.out.printf("%tH:%<tM:%<tS %<tp %n", date);
        System.out.printf("%tH:%<tM:%<tS %<Tp %n", date);
        System.out.printf("%ts %n", date);
    }
}
````

````java
public class DateTimeFormatOutput {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.printf("%tR %n", date);
        System.out.printf("%tT %n", date);
        System.out.printf("%tT %<tp %n", date);
        System.out.printf("%tr %n", date); // 12 clock format
        System.out.printf("%tD %n", date);
        System.out.printf("%tF %n", date);
        System.out.printf("%tc %n", date);
        System.out.println(date);
    }
}
````

````java
import java.io.IOException;
import java.util.*;

public class FormatOutput {
    public static void main(String[] args) {
        double x = 5;
        double y = x / 3.0;
        System.out.println(y);
        System.out.printf("%.2f %n", y);
        System.out.printf("%B %n", null);
        System.out.printf("%B %n", 123);
        System.out.printf("%b %n", false);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        /*System.out.print("your name : ");
        String name = scanner.nextLine();
        int age = random.nextInt(10, 40);
        // Hello John, Are you 28 years old ?
        System.out.printf("Hello %S, Are you %d years old ?%n", name, age);
        System.out.printf("Hello %2$d, Are you %1$S years old ?%n", name, age);*/

        // System.out.printf("%2$+5.2f--%1$-6.1f--%n", 12.12, 45.67);
        // System.out.printf("%s %n", 12);
        // System.out.printf("%s %n", 12.23);
        // below 👌👌👌👌👌👌
        Book book = new Book();
        System.out.printf("%60s %n", book);

    }
}

class Book implements Formattable {
    private String title = "Boy Ota Kambagal Ota";
    private String author = "***";

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        try {
            Appendable appendable = formatter.out();
            String response = "Book[title=" + title + ", author = " + author + "]";
            int length = response.length();
            if ( length < width ) {
                response = "#".repeat(width - length) + response;
            }
            appendable.append(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````