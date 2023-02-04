````java
public class Main {
    /**
     * Main method
     * @param args -> commandline arguments
     */
    public static void main(String[] args) {
        final int a = 12;
        // final bilan e'lon qilingan
        // ozgaruvchini ozgartirib bolmaydi
        int age = 28;
        /*
        Hello PDP.
        Welcome to future job
        */
    }
}
````


````java
public class DataTypes {
    public static void main(String[] args) {

        // int a = 12;
        // float b = 12.12f;
        // -2^(bit - 1) <= x < 2^(bit - 1)
        byte byteNumber = 127;// -2^7 <= x < 2^7; -128 <= x <= 127
        // signed(-) or unsigned(+)
        // unsigned byte byteNumber = 127;


        /*
        short shortNumber = 1245;
        // -2^(16 - 1) <= x < 2^(16 - 1)
        // -32768 <= x < 32768
        // -32768 <= x <= 32767
        short maxValueForShort = Short.MAX_VALUE;
        short minValueForShort = Short.MIN_VALUE;
        System.out.println(maxValueForShort);
        System.out.println(minValueForShort);
        */

        /*
        int intNumber = 1; //32-bit -> 4 byte
        // -2^(32 - 1) <= x < 2^(32 - 1)
        // -2147483648 <= x <= 2147483647
        int maxValueForInt = Integer.MAX_VALUE;
        int minValueForInt = Integer.MIN_VALUE;
        System.out.println(maxValueForInt);
        System.out.println(minValueForInt);
        */

        /*

        long longNumber = 10L; //64-bit -> 8 byte
        long maxValueForLong = Long.MAX_VALUE;
        long minValueForLong = Long.MIN_VALUE;
        System.out.println("maxValueForLong = " + maxValueForLong);
        System.out.println("minValueForLong = " + minValueForLong);

        System.out.println("maxValueForLong = " + maxValueForLong);
        System.out.println("minValueForLong = " + minValueForLong);
        */

        // floating point numbers
        // float double
        // float
        /*
        float floatNumber = 1.5F; // 32-bit -> 4 byte 7-8
        float maxValueForFloat = Float.MAX_VALUE;
        float minValueForFloat = Float.MIN_VALUE;

        System.out.println("maxValueForFloat = " + maxValueForFloat);
        System.out.println("minValueForFloat = " + minValueForFloat);
        */
        /*
        int a = 12;
        int b = 0;
        int c = a / b;
        System.out.println(c);
         */

        /*

        float a = 12f;
        float b = 0f;
        float c = a / b;
        // System.out.println(c);

        float a2 = -10f;
        float c2 = a2 / b;
        // System.out.println(c2);

        float a3 = 0f;

        float c3 = a3 / b;
        // System.out.println(c3);
        boolean isPositiveInfinity = Float.POSITIVE_INFINITY == c;
        System.out.println(isPositiveInfinity);
        boolean isNegativeInfinity = Float.NEGATIVE_INFINITY == c2;
        System.out.println(isNegativeInfinity);
        boolean isNan =  Float.NaN == c3;
        boolean isNan2 =  Float.isNaN(c3);
        System.out.println(isNan);
        System.out.println(isNan2);
        System.out.println(c3);
        System.out.println(Float.NaN);
        */

        /*
        double doubleNumber = 12D; // 64-bit -> 8 byte;
        boolean isInfinityNumber = Double.isFinite(-12D / 0);
        */

        char c = 'A'; // 16-bit -> 2 byte

        boolean is12GreaterThen15 = ( 12 > 15 );
        boolean is21GreaterThen15 = ( 21 > 15 );
        System.out.println(is12GreaterThen15);
        System.out.println(is21GreaterThen15);
    }
}
````


````java
import java.io.Console;

public class ConsoleTest {

    public static void main(String[] args) {
        Console console = System.console();
        String login = console.readLine("Enter Login : ");
        char[] arr = console.readPassword("Enter Password : ");
        String password = new String(arr);
        System.out.println(login);
        System.out.println(password);
    }
}
````


````java
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        int a = 10;
        Scanner reader = new Scanner(System.in);
//        String login = reader.nextLine();
//        System.out.println(login + " successfully logged in 👌");
//        String next = reader.next();
//        System.out.println("next = " + next);

        /*
        boolean hasNextInt = reader.hasNextInt();
        if (hasNextInt){
            int nextInt2 = reader.nextInt();
            System.out.println(nextInt2);
        }
        */

//        String login = reader.nextLine();
//        String password = reader.nextLine();
//        System.out.println(login);
        System.out.print("Enter number : ");
        int i = reader.nextInt();
        System.out.print("Enter Some String : ");
        reader.nextLine();
        String s = reader.nextLine();
        System.out.println(i);
        System.out.println(s);
    }
}
````


````java
public class NamingConventions {

    int CAR_WHEELS = 4;

    public static void main(String[] args) {
//        int user_age = 12;
//        int userAge = 12;

    }
}
````


````java
public class VariableTypes {

    int count = 3;
    static int count2 = 3;

    public static void main(String[] args) {
        int a = 12;
        float b = 123F;
        long c = 123L;
    }
}
````

````java
import java.io.Console;

public class AuthenticationApplication {

    public static void main(String[] args) {
        String dbLogin = "jl";
        String dbPassword = "123";
        Console console = System.console();

        String login = console.readLine("login : ");
        char[] array = console.readPassword("password : ");
        String password = new String(array);

        if ( login.equals(dbLogin) && password.equals(dbPassword) ) {
            System.out.println("Successfully logged in 😊");
        } else {
            System.out.println("Bad credentials 😒");
        }
    }
}
````
