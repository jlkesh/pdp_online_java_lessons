

````java
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HappyBirthday {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        for ( int i = 0; i < 100; i++ ) {
            TimeUnit.MILLISECONDS.sleep(400); //
            int leftSideDotesCount = randomNumberBetween1And30();
            int rightSideDotesCount = 30 - leftSideDotesCount;
            String leftSide = "\uD83C\uDF82".repeat(leftSideDotesCount);
            String rightSide = "\uD83C\uDF81".repeat(rightSideDotesCount);
            String message = leftSide + "Happy birthday " + name + rightSide;
            System.out.println(message);
        }

    }

    static int randomNumberBetween1And30() {
        return (int) Math.round(Math.random() * ( 30 - 1 )) + 1;
    }
}
````


````java
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HappyBirthdayTwo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name : ");
        String name = scanner.nextLine();


        for ( int i = 0; i < 300; i++ ) {
            TimeUnit.MILLISECONDS.sleep(200); //

            int leftSideDotesCount = randomNumberBetween1And30();
            int rightSideDotesCount = 30 - leftSideDotesCount;

            String leftSide = getSide(leftSideDotesCount);
            String rightSide = getSide(rightSideDotesCount);
            String message = leftSide + "Happy birthday " + name + rightSide;
            System.out.println(message);
        }

    }

    static String getSide(int repeatCount) {
        String birthdayCake = "\uD83C\uDF82";
        String wrappedPresent = "\uD83C\uDF81";
        String confettiBall = "\uD83C\uDF8A";
        String beatingHeartEmoji = "\uD83D\uDC93";
        StringBuilder stringBuilder = new StringBuilder();
        for ( int i = 0; i < repeatCount; i++ ) {
            int randNumber = randomNumberBetween1And4();
            String sign = switch ( randNumber ) {
                case 1 -> birthdayCake;
                case 2 -> wrappedPresent;
                case 3 -> confettiBall;
                case 4 -> beatingHeartEmoji;
                default -> birthdayCake;
            };
            stringBuilder.append(sign);
        }

        return stringBuilder.toString();
    }

    static int randomNumberBetween1And30() {
        return (int) Math.round(Math.random() * ( 30 - 1 )) + 1;
    }

    static int randomNumberBetween1And4() {
        return (int) Math.round(Math.random() * ( 4 - 1 )) + 1;
    }

}
````


````java
public class StringAPI {
    public static void main(String[] args) {
        /*String name = "java";
        String upperName = name.toUpperCase();
        System.out.println(name);
        System.out.println(upperName);
        String progLang = "PYTHON";
        System.out.println(progLang.toLowerCase());

        // S, M, L, XL, XXL
        String sizes = String.join("/ ", "S", "M", "L", "XL");
        System.out.println(sizes);
        */
        String str = "Java";
        String repeatedStr = str.repeat(10);
        System.out.println(repeatedStr);

    }
}
````


````java
public class StringBuilding {
    public static void main(String[] args) {
//        String str = "";
//        for (int i = 0; i < 100; i++) {
//            str = str + i;
//        }
//        System.out.println(str);
        //class name
        StringBuilder stringBuilder = new StringBuilder();

        for ( int i = 0; i < 100; i++ ) {
            //stringBuilder.append(i);
            stringBuilder.insert(0, i);
        }

        String str = stringBuilder.toString();
        System.out.println(str);
    }
}
````


````java
public class StringCodeUnitAndCodePoints {
    public static void main(String[] args) {
        String str = "JAVA\u2122\uD83D\uDC96";
        int strLength = str.length(); //code unit
        System.out.println(strLength);
        System.out.println(str);
        // code point
        int codePointAt1 = str.codePointAt(1);
        System.out.println(codePointAt1);
    }
}
````


````java
public class StringConcat {
    public static void main(String[] args) {
        /*String str1 = "Hello";
        String str2 = "PDP";
        String concatStr = str1 + str2;
        System.out.println(concatStr);
        String concatStr2 = str1.concat(str2);
        System.out.println(concatStr2);
        String concatStr3 = str2.concat(str1);
        System.out.println(concatStr3);*/
        // int age = 9;
        // String name = "John";
        String message = "Hello, I'm ";
        int age = 17; // "17"
        String fullMessage = message + age;
        System.out.println(fullMessage);

    }
}
````


````java
public class StringEmptyOrNull {
    public static void main(String[] args) {
        /*String message = ""; //code unit lar soni
        int messageLength = message.length();
        System.out.println(messageLength);
        if (messageLength == 0) {
            System.out.println("message is empty");
        }*/

        String message2 = "";// null, "", "data"

        if ( message2 != null && message2.length() != 0 ) {
            System.out.println("message2 is not empty");
        } else {
            System.out.println("message2 is null or empty");
        }
    }
}
````


````java
public class StringEquality {
    public static void main(String[] args) {


       /* int a = 12;
        int b = 12;
        // ==
        if (a == b){
            System.out.println("a and b equal");
        }else{
            System.out.println("a and b not equal");
        }*/

        String name = "JAvOHiR";
        //
        String name2 = "jAVohir";
        // == checks memory address
        /*if (name == name2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }*/
        // name.equals(name2);
        if ( name.equalsIgnoreCase(name2) ) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
````
````java
public class StringTest {
    public static void main(String[] args) {
        String name = "Hello world";
        //             0123456789A
        int age = 12;
        // int, short, boolean, long, double, char, float
        String newStr = name.substring(6);
        System.out.println(newStr);
        String newStr2 = name.substring(6, 9);
        // 1-argument -> inclusive
        // 2-argument -> exclusive
        // inclusive ; exclusive .  [2;4)
        System.out.println(newStr2);
        System.out.println(name);

    }
}
````

````java
public class TextBlock {
    public static void main(String[] args) {
        String body = """
                Programmer's Guide to Text Blocks
                Jim Laskey
                Stuart Marks""";
        System.out.println("-------------------");
        System.out.println(body);
        System.out.println("-------------------");
    }
}
````

