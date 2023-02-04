## ProblemsNeedToConsiderExample class
````java
package exceptions;

import java.util.Scanner;

public class ProblemsNeedToConsiderExample {
    public static void main(String[] args) {
        /*final Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        System.out.println(nextInt * 2);
        scanner.close();*/
        registerUser(null, "123");
    }

    static boolean registerUser(String username, String password) {
        // JoHN, jOHn, John, johN => username.toLowerCase ,
        if (username != null) {
            username = username.toLowerCase();
        }
        // save to database (username, password)
        return true;
    }
}
````

## CheckedAndUncheckedExceptionExample
````java
package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class CheckedAndUncheckedExceptionExample {

    public static void main(String[] args) throws FileNotFoundException {
        // uncheckedExceptionExample();
        // checked -> compile time exception
        // unchecked -> runtime exception
        System.out.println("Welcome to reader");
        readFile();
    }

    private static void readFile() throws FileNotFoundException {
        InputStream is = new FileInputStream("file.txt");
    }

    private static void uncheckedExceptionExample() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to simple calculator");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a / b);
        scanner.close();
    }

}
````

## ThrowingExceptionExample
````java
package exceptions;

import java.io.IOException;

public class ThrowingExceptionExample {

    public static void main(String[] args) throws Exception {
        m1(2);
    }

    private static void m1(int a) throws Exception {
        if (a == 2)
            throw new Exception("a is 2 which is not acceptable");

    }

    private static void m2() {

    }

    private static void m3() {

    }
}
````

## ExceptionPropagation2Example
````java
package exceptions;

import java.io.FileNotFoundException;

public class ExceptionPropagation2Example {
    public static void m5() throws FileNotFoundException {
        throw new FileNotFoundException("Checking Exception Propagation");
    }
}
````

## NotFoundException
````java
package exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
````

## ExceptionHandlingExample
````java
package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        divide(12, 0);
        System.out.println("end");
    }

    private static void divide(int a, int b) {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("file.txt");
        } catch (FileNotFoundException e) {
            // code
        }
    }
}
````

## MultipleExceptionHandlingExample
````java
package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class MultipleExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            m1();
            m2();
            m3();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*catch (UnknownHostException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    private static void m3() throws IOException {

    }

    private static void m2() throws FileNotFoundException {

    }

    private static void m1() throws UnknownHostException {

    }

}
````

## Source Code
````java
package exceptions;

import java.sql.SQLException;
import java.util.Random;

public class RethrowingExceptionExample {

    public static void main(String[] args) {
        registerUser("user");
    }

    static void registerUser(Object user) { // username, email, password
        // save to db and send email to that user
        try {
            saveDB(user);
            sendEmail(user);
        } catch (Exception e) {
            APIException exception = new APIException(e.getMessage());
            exception.initCause(e);
            throw exception;
        }
    }

    private static void sendEmail(Object user) throws Exception {
        if (new Random().nextBoolean()) {
            throw new Exception("Could not connect to smtp server");
        }

    }

    private static void saveDB(Object user) throws SQLException {
        if (new Random().nextBoolean()) {
            throw new SQLException("Could not connect ot database");
        }
    }
}

class APIException extends RuntimeException {

    public APIException(String message) {
        super(message);
    }
}
````

## FinallyBlockExample
````java
package exceptions;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class FinallyBlockExample {
    public static void main(String[] args) {
        // m1();
        // m2();
        //System.out.println(m3());
        m4();
    }

    private static int m3() {
        try {
            return 10;
        } finally {
            return 5;
        }
    }

    private static void m4() {
        try (var scanner = new Scanner(new File("src/files/file.txt"), StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }


    private static void m2() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/files/file.txt"), StandardCharsets.UTF_8);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.println("closing input stream..");
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void m1() {
        try {
            if (new Random().nextBoolean()) {
                throw new Exception("Exception");
            } else {
                System.out.println("Success");
            }
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.println("Finally");
        }
    }

}
````

## ExceptionPropagationExample
````java
package exceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionPropagationExample {
    public static void main(String[] args) {
        // StackWalker instance = StackWalker.getInstance();
        try {
            m1();
        } catch (FileNotFoundException e) {
            System.out.println("error ");
            var writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String s = writer.toString();
            System.out.println(s);
        }
        System.out.println("end");
//        m4();
    }

    private static void m1() throws FileNotFoundException {
        m2();
    }

    private static void m2() throws FileNotFoundException {
        m3();
    }

    private static void m3() throws FileNotFoundException {
        ExceptionPropagation2Example.m5();
    }

    private static void m4() {
        throw new NotFoundException("runtime exception check");
    }
}
````

## TipsForExceptionUsingExample
````java
package exceptions;

public class TipsForExceptionUsingExample {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        m1(arr);
    }

    private static void m1(int[] arr) {
        int index = 9;
        if (index < arr.length)
            System.out.println(arr[index]);
/*
        try {
            System.out.println(arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }*/
    }
}
````
