````java
public class ExecutionFlow {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("PDP");
        System.out.println("...");
        System.out.println("END");
    }
}
````

````java
import java.util.Scanner;

public class ConditionalExecutionFlow {

    public static void main(String[] args) {
        System.out.println("How many legs will horses have ? ");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        if ( userInput == 4 ) {
            System.out.println("Yes, You Right :) 😊");
        } else {
            System.out.println("Nope :( 😒");
        }
    }
}
````

````java
public class FlowControlStatements {
    public static void main(String[] args) {
        int age = 12;
        boolean booleanExpression = ( age > 18 ); // boolean expression
        if ( booleanExpression ) // conditional test
        { // block
            // ................
            // ................
            // ................
            // ................
        }
    }
}
````

````java
import java.util.Scanner;

public class RepetitionExecutionFlow {
    public static void main(String[] args) {

        int userInput;
        do {
            System.out.print("How many legs will horses have ? ");
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
            if ( userInput == 4 ) {
                System.out.println("Yes, You Right :) 😊");
            } else {
                System.out.println("Nope :( 😒");
                System.out.println("Try again 🙌");
            }
        } while ( userInput != 4 );
    }
}
````

````java
import java.util.Scanner;

public class IfCS {
    public static void main(String[] args) {
        System.out.println("Telegram");
        System.out.println("You will have simple emojis 😊");
        System.out.print("Is your telegram premium (yes/no -> 0/1)");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        if ( userInput == 0 ) {
            System.out.println("You will have awesome emojis too");
        }
        System.out.println("...............");
    }
}
````

````java
import java.util.Scanner;

public class IfElseCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your age : ");
//        int age = scanner.nextInt();
//        if (age > 50) {
//            System.out.println("Ready For Retirement :(");
//        } else {
//            System.out.println("Work hard :))");
//        }
//        System.out.println("End of program");
        System.out.print("Enter day number : ");
        int dayNumber = scanner.nextInt();

        if ( dayNumber == 1 ) {
            System.out.println("Dushanba");
        } else if ( dayNumber == 2 ) {
            System.out.println("Seshanba");
        } else if ( dayNumber == 3 ) {
            System.out.println("Chorshanba");
        }
        // ..........
        else if ( dayNumber == 7 ) {
            System.out.println("Yakshanba");
        } else {
            System.out.println("Topilmadi");
        }
    }
}
````

````java
import java.util.Scanner;

public class NestedIfCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your gender (male/female -> 0/1): ");
        int gender = scanner.nextInt();

        System.out.print("Your age : ");
        int age = scanner.nextInt();

        // men -> 60
        // women -> 55

        if ( gender == 0 ) {
            // ...
            if ( age >= 60 ) {
                System.out.println("Enjoy your retirement :( 😊");
            } else {
                int i = 60 - age;
                System.out.println(i + " years for your retirement");
            }
        } else if ( gender == 1 ) {
            if ( age >= 55 ) {
                System.out.println("Enjoy your retirement :( 😊");
            } else {
                int i = 55 - age;
                System.out.println(i + " years for your retirement");
            }
        } else {
            System.out.println("error");
        }

    }
}
````

````java
import java.util.Scanner;

public class SwitchCaseCS {
    public static void main(String[] args) {
        // java 7
        Scanner scanner = new Scanner(System.in);
        /*int number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("NO idea");
        }*/
        // java 8 String Case, Enum Case
        String day = "Monday";

        /*switch (day) {
            case "Monday":
            case "Tuesday":
                System.out.println("Week day");
                break;
            //....
            case "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("No idea");
        }*/
        // java 12 , ->, java 14
        int number = scanner.nextInt();
        /*switch (number) {
            case 1 -> System.out.println("One");
            case 2 -> System.out.println("Two");
            case 3 -> System.out.println("Three");
            default -> System.out.println("NO idea");
        }*/

        String a = switch ( number ) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            default -> "NO idea";
        };
        System.out.println(a);
        // java 17 null
    }
}
````

````java
public class WhileCS {
    public static void main(String[] args) {
        int counter = 10000;
        while ( counter <= 10 ) {
            System.out.println(counter * counter);
            counter++;
        }
    }
}
````

````java
public class ForCS {
    public static void main(String[] args) {

        for ( int i = 1; i <= 10; i = i + 1 ) {
            System.out.println(i);
        }
    }
}
````

````java
public class DoWhileCS {
    public static void main(String[] args) {
        /*
        System.out.println(1);
        System.out.println(4);
        System.out.println(9);
        System.out.println(16);
        //............
        System.out.println(100);
        */
        int counter = 10000;
        do {
            System.out.println(counter * counter);
            counter++;
        } while ( counter <= 1000 );

    }
}
````

````java
public class BreakUCS {
    public static void main(String[] args) {
        int counter = 0;

        while ( true ) {
            if ( counter == 10 ) {
                break;
            }
            System.out.println(counter);
            counter++;
        }
    }
}
````

````java
public class ContinueUCS {
    public static void main(String[] args) {
        int counter = 0;
        while ( true ) {
            counter++;
            if ( counter % 2 == 0 ) {
                continue;
            }
            System.out.println(counter);
            if ( counter > 10 ) {
                return;
            }
        }
        // System.out.println("End........");
    }
}
````

````java
public class InfiniteLoops {
    public static void main(String[] args) {

//        while (true){
//            System.out.println("true");
//        }

//        do {
//            System.out.println("........");
//        }while (true);
//
//
        for ( ; ; ) {
            System.out.println("...........");
        }

    }
}
````

````java
public class LabelledLoop {
    public static void main(String[] args) {
        pdp:
        for ( int i = 0; i < 10; i++ ) {

            for ( int j = 0; j < 10; j++ ) {
                if ( j == 4 ) {
                    //break pdp;
                    continue pdp;
                }
                System.out.print(j + "  ");
            }

            System.out.println("");
        }
    }
}
````

# Guess Game I

````java
public class GuessGameVersionOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 5;
        int computer = (int) Math.round(Math.random() * ( max - min )) + min;
        System.out.print("Enter number : ");
        int guessNumber = scanner.nextInt();
        if ( guessNumber == computer ) {
            System.out.println("You win 🙌🙌🙌🙌");
        } else {
            System.out.println("Sorry You loose 😒😒😒😒");
        }
    }
}

````
# Guess Game II
````java
import java.util.Scanner;

public class GuessGameVersionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter min number : ");
        int min = scanner.nextInt();
        System.out.print("Enter max number : ");
        int max = scanner.nextInt();
        int computer = (int) Math.round(Math.random() * ( max - min )) + min;

        int tryCount = 3;

        do {
            System.out.print("Enter number : ");
            int guessNumber = scanner.nextInt();
            if ( guessNumber == computer ) {
                System.out.println("You win 🙌🙌🙌🙌");
                break;
            } else {
                tryCount--;
                if ( tryCount < 0 ) {
                    System.out.println("Sorry You loose 😒😒😒😒");
                    break;
                } else {
                    System.out.println("Try again 👌👌👌");
                }
            }
        } while ( true );
    }
}
````

````java
public class Unicode {
    public static void main(String[] args) {
        char tm = '\u266F';
        System.out.println("Java" + tm);
        int codePoint = 0x1F495;
        System.out.println("codePoint = " + codePoint);
        char hs = Character.highSurrogate(codePoint);
        char ls = Character.lowSurrogate(codePoint);
        char[] item = {hs, ls};
        System.out.println(item);
    }
}
````

````java
public class ANSI {
    public static void main(String[] args) {
        // ESC[38;5;{ID}m
        System.out.println("\u001b[38;5;34m Hello PDP");
        int counter = 1;
        for ( int i = 0; i < 10; i++ ) {
            for ( int j = 0; j < 10; j++ ) {
                System.out.print("\u001b[38;5;" + counter + "m" + counter + "\t");
                counter++;
            }
            System.out.println("\n");
        }
    }
}
````

````java

````

````java

````

