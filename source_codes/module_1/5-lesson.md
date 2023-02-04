````java
public class MethodDefinitionExample {

    public static void main(String[] args) {
        // call method
        int addMethodResponse = add(12, 1290);
        System.out.println(addMethodResponse);
        hello();
    }

    static int add(int x, int y) {
        int result = x + y;
        return result;
    }

    static void hello() {
        System.out.println("Hello");
    }
}
````


````java
import java.util.Scanner;

public class GuessGame {


    public static void main(String[] args) {
        int number = generateNumber(20, 1);
        System.out.println("Choose number between 1 and 20");
        for ( int i = 0; i < 3; i++ ) {
            int guess = readInputAsInt("Guess number : ");
            if ( guess == number ) {
                System.out.println("You win 😂😂😂 )))");
                return;
            } else {
                System.out.println("Try again ))");
            }
        }
        System.out.println("You loose 😒😒😒");
    }

    private static int readInputAsInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    private static int generateNumber(int max, int min) {
        if ( max < min ) {
            int temp = min;
            min = max;
            max = temp;
        }
        return (int) Math.round(Math.random() * ( max - min )) + 1;
    }

}
````


````java
public class Recursion {
    public static void main(String[] args) {
        // recursion(5);
        // headRecursion(3);
        treeRecursion(3);
    }

    static void recursion(int n) { // tail recursion
        if ( n > 0 ) { // 1) base condition
            System.out.println(n);
            n = n - 1; // 3) change state
            recursion(n); // 2) call
        }
    }

    static void headRecursion(int n) {
        if ( n > 0 ) {
            headRecursion(n - 1);
            System.out.println(n);
        }
    }

    static void treeRecursion(int n) {
        if ( n > 0 ) {
            System.out.println(n);
            treeRecursion(n - 1);
            treeRecursion(n - 1);
        }
    }
}
````


````java
public class Fibonacci {
    public static void main(String[] args) {
        // f(n) = f(n - 1) + f(n - 2)
        // f(0) = 0
        // f(1) = 1
        // f(2) = f(1) + f(0) = 1
        // f(3) = f(2) + f(1) = 2
        // f(4) = f(3) + f(2) = 3
        // f(5) = f(4) + f(3) = 5
        // f(6) = f(5) + f(4) = 8
//        int fibonacci3 = fibonacci(3);
//        int fibonacci6 = fibonacci(6);
//        int fibonacci13 = fibonacci(13);
//        System.out.println(fibonacci3);
//        System.out.println(fibonacci6);
//        System.out.println(fibonacci13);
        long fibonacci100 = fibonacci2(100);
        System.out.println(fibonacci100);
//        hello();
    }

    static void hello() {
        System.out.println("Hello");
        hello();
    }


    static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static long fibonacci2(int n) {
        long f0 = 0;
        long f1 = 1;
        for (int i = 2; i <= n; i++) {
            long temp = f1;
            f1 = f1 + f0;
            f0 = temp;
        }
        return f1;
    }
}
````