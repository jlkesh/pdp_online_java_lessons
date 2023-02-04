# Wrapper Classes

````java
package uz.pdp.wrapperclasses;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 7:52 AM
 * @project lesson_6_1
 */

public class NumberClassTest {
    public static void main(String[] args) {
        /*Integer a = 12;
        Number integerNumber = a;
        System.out.println(integerNumber);
*/
        // Byte aByte = new Byte("12"); // deprecated
        /*Byte b1 = Byte.parseByte("12"); // primitive
        Byte b2 = Byte.valueOf("12"); // object
        byte b3 = 12;
        Byte b4 = b3;
        System.out.println(b1);
        System.out.println(b2);*/

        /*Byte b5 = 12;
        double doubleValue = b5.doubleValue();
        System.out.println(doubleValue);
        */

        // System.out.println(Byte.decode("12"));
        // System.out.println(Byte.decode("#12"));
        // System.out.println(Byte.decode("0XF"));
        System.out.println(Byte.parseByte("101010", 2));
        System.out.println(Byte.parseByte("17", 8));
        System.out.println(Byte.parseByte("1F", 16));


    }
}
````

````java
package uz.pdp.wrapperclasses;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 8:20 AM
 * @project lesson_6_1
 */

public class DoubleTest {
    public static void main(String[] args) {
        /*int x = 12;
        int y = 0;
        int z = x / y;*/
        double a = 0;
        double b = 0;
        double c = a / b;
        System.out.println(c);
        System.out.println(Double.isNaN(0D/0));
        System.out.println(Double.isFinite(12D/3));
        System.out.println(Double.isFinite(-12D/3));
        System.out.println(Double.isInfinite(-12D/0));
    }
}
````

````java
package uz.pdp.wrapperclasses.utils;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 8:12 AM
 * @project lesson_6_1
 */

public class Util {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidData(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            if (!Character.isLetterOrDigit(ch)){
                return false;
            }
        }
        return true;
    }
}
````

````java
package uz.pdp.wrapperclasses;

import uz.pdp.wrapperclasses.utils.Util;

/**
 * @author Elmurodov Javohir
 * @time 11/9/2022 8:09 AM
 * @project lesson_6_1
 */

public class CharacterClassTest {
    public static void main(String[] args) {
        /*Character ch = 'A';

        if (Character.isDigit(ch)) {
            System.out.println("A is digit");
        } else {
            System.out.println("A is not digit");
        }*/

//        System.out.println(Util.isValidPhoneNumber("12asdw"));
//        System.out.println(Util.isValidPhoneNumber("21301624"));
        System.out.println(Util.isValidData("21301624"));
        System.out.println(Util.isValidData("2asdsa1"));
        System.out.println(Util.isValidData("2asdsa<1"));
    }
}
````
# BigNumbers

````java
import java.math.BigDecimal;

/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 6:52 AM
 * @project lesson_6_3_big_numbers
 */

public class BigDecimalTest {
    public static void main(String[] args) {
        /*double a = 2.1;
        double b = 2.2;
        System.out.println(a + b);*/
        // BigDecimal b1 = new BigDecimal(2.1); // 1-way of constructing BigDecimal 😒
        // BigDecimal b2 = new BigDecimal(2.2);
        /*BigDecimal b1 = BigDecimal.valueOf(2.1); // 2-way of constructing BigDecimal 😒
        BigDecimal b2 = BigDecimal.valueOf(2.2);
        BigDecimal b3 = b1.add(b2);
        BigDecimal b4 = BigDecimal.valueOf(12.234343546436436346631234);
        //                                 12.234343546436437
        System.out.println(b4);*/
        BigDecimal b1 = new BigDecimal("2.1"); // 3-way of constructing BigDecimal 😊
        BigDecimal b2 = new BigDecimal("2.2");
        BigDecimal b3 = b1.add(b2);
        BigDecimal b4 = new BigDecimal("12.234343546436436346631234");
        System.out.println(b4);
        // text 1
        // text 2
        // text 3
    }
}
````

````java
import java.math.BigInteger;

/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 7:02 AM
 * @project lesson_6_3_big_numbers
 */

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger b1 = BigInteger.valueOf(10L);
        BigInteger b2 = BigInteger.valueOf(3L);
        // System.out.println(b1.add(b2));
        // System.out.println(b1.subtract(b2));
        // System.out.println(b1.multiply(b2));
        // System.out.println(b1.divide(b2));
        System.out.println(factorial2(100000));
    }

    public static long factorial(long n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static BigInteger factorial2(long n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
````
# Boxing

````java
/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 7:21 AM
 * @project lesson_6_3_boxing
 */

public class BoxingUnboxingTest {
    public static void main(String[] args) {
        Integer a = 12;
        int b = a; // unboxing
        double d = 12.0;
        Double d2 = d; // boxing
    }
}
````
# Inner Classes
````java
/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 7:34 AM
 * @project lesson_6_4_innerclasses
 */

public class NormalInnerClass {

    public class InnerClass {
        public class InnerInnerClass {

        }
    }
}
````

````java
/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 7:37 AM
 * @project lesson_6_4_innerclasses
 */

public class StaticNestedInnerClass {

    public static class Session{

    }
}
````

````java
/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 7:39 AM
 * @project lesson_6_4_innerclasses
 */

public class StaticNestedInnerClassTest {
    StaticNestedInnerClass.Session session = new StaticNestedInnerClass.Session();
    // NormalInnerClass.InnerClass innerClass = new NormalInnerClass.InnerClass();
}
````

````java
/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 7:36 AM
 * @project lesson_6_4_innerclasses
 */

public class MethodLocalInnerClass {

    public void hi() {
        class InnerClass {

        }
    }
}
````
# Number System Convertor I
````java
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 5:44 AM
 * @project lesson_6_number_system_conversion_app
 */

public class NumberSystemVersionOne {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.print("Enter number : ");
        String number = scanner.nextLine();

        System.out.print("Enter base index : ");
        int baseIndex = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter to index : ");
        int toIndex = Integer.parseInt(scanner.nextLine());
        int decimalFormatOfNumber = fromAnyToDecimal(baseIndex, number);
        System.out.println("Decimal : " + decimalFormatOfNumber);
        CharSequence resultNumber = fromDecimalToAny(decimalFormatOfNumber, toIndex);
        System.out.println("Result : " + resultNumber);
    }


    private static int fromAnyToDecimal(int baseIndex, String number) {
        int length = number.length();
        int multiplier = length - 1;
        double result = 0;
        for (int i = 0; i < length; i++)
            result += getCharAsInteger(number.charAt(i)) * pow(baseIndex, multiplier--);
        return (int) result;
    }


    private static CharSequence fromDecimalToAny(int number, int toIndex) {
        StringBuilder builder = new StringBuilder("");
        while (number >= toIndex) {
            int remainder = number % toIndex;
            number = number / toIndex;
            builder = builder.append(getIntegerAsChar(remainder));
        }
        if (number != 0)
            builder = builder.append(getIntegerAsChar(number));
        builder.reverse();
        return builder;
    }

    private static int getCharAsInteger(char ch) {
        return ch - (ch >= 48 && ch <= 57 ? 48 : 55);
    }

    private static char getIntegerAsChar(int number) {
        return (char) (number + (number >= 0 && number <= 9 ? 48 : 55));
    }
}
````
# Number System Convertor II

````java
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * @author Elmurodov Javohir
 * @time 11/10/2022 5:44 AM
 * @project lesson_6_number_system_conversion_app
 */

public class NumberSystemVersionTwo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.print("Enter number : ");
        String number = scanner.nextLine();
        System.out.print("Enter base index : ");
        int baseIndex = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter to index : ");
        int toIndex = Integer.parseInt(scanner.nextLine());
        if (checkNumberWithBaseIndex(number, baseIndex)) {
            if (baseIndex == toIndex)
                System.out.println("Result : " + number);
            else {
                int decimalFormatOfNumber = Integer.parseInt(number, baseIndex);
                System.out.println("Decimal : " + decimalFormatOfNumber);
                CharSequence resultNumber = fromDecimalToAny(decimalFormatOfNumber, toIndex);
                System.out.println("Result : " + resultNumber);
            }
        } else {
            System.out.println("Number is invalid");
        }

    }


    private static boolean checkNumberWithBaseIndex(String number, int baseIndex) {
        for (int i = 0; i < number.length(); i++) {
            if (Character.digit(number.charAt(i), baseIndex) == -1)
                return false;
        }
        return true;
    }


    private static CharSequence fromDecimalToAny(int number, int toIndex) {
        if (toIndex == 10)
            return String.valueOf(number);

        String result = "";
        while (number >= toIndex) {
            int remainder = number % toIndex;
            number = number / toIndex;
            result = getIntegerAsChar(remainder) + result;
        }
        if (number != 0)
            result = getIntegerAsChar(number) + result;
        return result;
    }

    private static char getIntegerAsChar(int number) {
        return (char) (number + (number >= 0 && number <= 9 ? 48 : 55));
    }

}
````