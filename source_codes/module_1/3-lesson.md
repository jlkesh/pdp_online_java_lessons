````java
public class ArithmeticOperators {

    public static void main(String[] args) {
        /*
        // sub
        int x = 2;
        int y = 4;
        int z = x - y; // +, *, /
        System.out.println(z);
        */
        /*
        // mul
        int x = 5;
        int y = 2;
        int z = x / y;
        System.out.println(z);
        */

        // modulus %
        int x = 8;
        int y = 3;
        int remainder = x % y;
        //System.out.println(remainder);
        //int error = x / 0;
        //System.out.println(error);
        double a = 0D;
        double zero = 0D;
        double divideByZero = a / zero;
        //double positiveInfinity = Double.POSITIVE_INFINITY;
        //System.out.println(positiveInfinity);
        //double negativeInfinity = Double.NEGATIVE_INFINITY;
        //System.out.println(negativeInfinity);
        double naN = Double.NaN;
        System.out.println(naN);
        System.out.println(divideByZero);
        System.out.println(naN == divideByZero);
        boolean isNan = Double.isNaN(divideByZero);
        System.out.println(isNan);
    }
}
````


````java
public class Assignments {
    public static void main(String[] args) {
        int x = 2;
        x = x + 4;
        System.out.println(x);
        x += 10; // x = x + 10
        System.out.println(x);
        x += 1.2; // x = (int)(x + 1.2)
        System.out.println(x);
    }
}
````


````java
public class BitwiseOperators {
    public static void main(String[] args) {
        // bitwise or
        // 2 -> 10
        // 3 -> 11
        // 4 -> 100
        // 5 -> 101
        // 6 -> 110
        int x = 4; // 100
        int y = 2; // 10
        // 4 | 2
        // 100
        // 010
        // 110
        // 4 | 4
        // 100
        // 100
        // 100
        System.out.println(x | y);
        // bitwise and
        // 4 | 2
        // 100
        // 010
        // 000
        System.out.println(x & y);
        // bitwise xor
        // 4 | 2
        // 100
        // 010
        // 110
        System.out.println(x ^ y);
        // bitwise complement
        System.out.println(~y);
    }
}
````


````java
public class ConditionalOperators {
    public static void main(String[] args) {
        int x = 23;
        int y = 123;
        int max = ( x > y ) ? x : y;
        System.out.println(max);
    }
}
````


````java
public class ConversionTypes {
    public static void main(String[] args) {
        byte a = 12;
        short sh = a;
        char ch = 'A';
        int int1 = sh;
        int int2 = ch;
        long l = int1;
//        System.out.println(sh);
//        System.out.println(int1);
//        System.out.println(int2);
//        System.out.println(l);
        /*
        int n = 123456789;
        float f = n;
        System.out.println(n);
        System.out.println(f);
        int fn = (int) f;
        System.out.println(fn);
        */

        /*
        double x = 12D;
        double y = 2D;
        // x(double) + y(double) =  double
        double z = x + y;
        */
//        int x = 12;
//        float y = 4F;
//        float z = x + y;
//        int x = 12;
//        int y = 4;
//        int z = x / y;

    }
}
````


````java
public class IncrementDecrement {
    public static void main(String[] args) {
        /*
         * Increment Example
         */
        /*
        int counter = 0;
        counter = counter + 1;
        System.out.println(counter);
        counter += 1;
        System.out.println(counter);
        counter++;
        System.out.println(counter);
        */
        /*
         * Decrement Example
         */
        /*
        int reverse = 10;
        reverse--;
        System.out.println(reverse);
        reverse--;
        System.out.println(reverse);
        */

        // 10++; invalid syntax
        // postfix n++
        // prefix ++n
        int m = 4;
        int n = 4;
        int a = 8 * ++m;
        int b = 8 * n++;
        System.out.println("n = ");
        System.out.println(n);
        System.out.println("m = ");
        System.out.println(m);
        System.out.println(a);
        System.out.println(b);
    }
}
````


````java
public class MathFunctions {

    public static void main(String[] args) {
        /*
        int abs = Math.abs(-100);
        System.out.println(abs);
        int x = 90;
        int y = 101;
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        System.out.println(max);
        System.out.println(min);

        double a = 12.1;
        double aCeil = Math.ceil(a);
        System.out.println(aCeil);

        double b = 12.9;
        double bFloor = Math.floor(b);
        System.out.println(bFloor);

        double c  = 12.4;
        long cRound = Math.round(c);
        System.out.println(cRound);

        double d = 12.5;
        long dRound = Math.round(d);
        System.out.println(dRound);
        */
        double random = Math.random();
        //System.out.println(random);
        int a = 10;
        int b = 20;
        // 0.0 <= random < 0.9(9)
        /* random 0.0 =>
                random * b = 0
                result = 0 + a
           random 0.999999999 =>
                random * b > 19.5 + a;
        random = 0.9999
        random * (b - a) + a;
        */
        double result = random * ( b - a ) + a;
        System.out.println(result);
        long roundedResult = Math.round(result);
        System.out.println(roundedResult);
        System.out.println(Math.E);
        System.out.println(Math.PI);
    }
}
````


````java
public class MathNotes {
    public static void main(String[] args) {
        int a = 1000000000;
        int b = 3;
        //int c = a * b;
        //System.out.println(c);
//        int multiplyExact = Math.multiplyExact(a, b);
//        System.out.println(multiplyExact);
    }
}
````


````java
public class NarrowingCast {
    public static void main(String[] args) {
        long a = 123L;
        int b = (int) a;
        short sh = (short) b;
    }
}
````


````java
public class OperatorPrecedence {

    public static void main(String[] args) {
        int a = 4;
        int b = 9;
        int c = 11;
        a += b += c;
        // right to left (a += (b += c))
        // c=11;
        // b=20;
        // a=24
//        System.out.println(a);
//        System.out.println(b);
        int x = 12;
        int y = 5;
        int z = x+(++y); // x++ yoki ++y
        System.out.println(z);
        System.out.println("Java\u2122");
        System.out.println("Java ");
        System.out.println("Java \u1613");
        System.out.println("Java \u1f480");
        System.out.println("Java \u0041");
        System.out.println("Java \u6771");
        char[] chars = Character.toChars(0x10400);
        System.out.println(new String(chars));
    }
}
````



````java
public class Relational {
    public static void main(String[] args) {
        int x = 12;
        int y = 3;
        // == -> equality sign
        // != -> inequality sign
        // x == y
        //boolean isEqual = (x == y);
        //boolean isNotEqual = (x != y);
        //System.out.println(isEqual);
        //System.out.println(isNotEqual);

        // logical and &&
        // expression1 && expression2
        //boolean expression1 = 12 > 3;
        //boolean expression2 = 12 < 21;
        //boolean isNumberBetween3And21 = expression1 && expression2;
        //System.out.println(isNumberBetween3And21);
        // logical or
        // expression1 || expression2
        //boolean expression1 = 12 > 3;
        //boolean expression2 = 12 < 3;
        //boolean isNumberGreaterThen12OrSmallerThen3 = expression1 || expression2;
        //System.out.println(isNumberGreaterThen12OrSmallerThen3);
        // not
        // !expression1
        //boolean expression1 = 12 < 4; //false
        //System.out.println(expression1);
        //System.out.println(!expression1);
        System.out.println(12 > 4);//gt
        System.out.println(12 > 12);//gt
        System.out.println(12 >= 12);//gte
        System.out.println(12 < 21);//lt
        System.out.println(21 < 21);//lt
        System.out.println(21 <= 21);//lte
    }
}
````


````java
public class ShiftingOperators {
    public static void main(String[] args) {
//        int x = 4; //00...0000000000001000
//        // 6 -> 110
//        // 7 -> 111
//        // 8 -> 1000
//        int shiftedX = x << 1;
//        int a = 0b1000;
//        System.out.println(shiftedX);
//        System.out.println(a);

//        int x = 4; //000...00000000000010
//        int shiftedX = x >> 1;
//        int a = 0b10;
//        System.out.println(shiftedX);
//        System.out.println(a);
        int x = 12;
        int a = x >> 2;
        int b = x / 4;
//        System.out.println(a);
//        System.out.println(b);
        int shiftedX = x << 1 >> 2 << 3 >> 2 << 2;
        int shiftedXWithNewApproach = ((((x * 2) / 4) * 8) / 4) * 4;
        System.out.println(shiftedX);
        System.out.println(shiftedXWithNewApproach);
        int twoToThePower10 = 1 << 5;
        System.out.println(twoToThePower10);
    }
}
````