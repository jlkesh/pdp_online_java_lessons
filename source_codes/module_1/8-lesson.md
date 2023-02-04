````java
public class ImmutableString {
    public static void main(String[] args) {
        String str = "Hi";
//        String str2 = "Hi" + " Guys";
//        System.out.println(str);
//        str.concat(" Guys");
//        System.out.println(str);
        String str2 = "           ";
        System.out.println(str2.isBlank());
        System.out.println(str2.isEmpty());
        System.out.println("Hi Hi Hi".indexOf("Hi"));
        System.out.println("Hi Hi Hi".lastIndexOf("Hi"));
        System.out.println("Hi Hi Hi".replace("Hi", "Hello"));
    }
}
````


````java
public class WorkingWithString {
    public static void main(String[] args) {
        int a = 12;
        String str = "hello"; // literal 1)
        String str2 = new String("Hello"); // 2)
        char[] array = new char[]{'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(array); // 3)
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
    }
}
````


````java
public class WorkingWithCompactString {
    public static void main(String[] args) {
        int a = 12; // 4 byte -> 32 bit
        String str = "hi";
        String str2 = "fsafafafafsafsaffsafafaf";
        // java 8 UTF-16; 16 bit
        // java 9 Latin-1;
        String str3 = "Hi"; // byte[].length = 2 byte;
        String str4 = "Hi€"; // byte[].length = 6 byte;

    }
}
````


````java
public class WorkingWithStringConstantPool {
    public static void main(String[] args) {
        String str5 = new String("PDP");
        String str6 = new String("PDP");
        System.out.println("System.identityHashCode(str5) = " + System.identityHashCode(str5));
        System.out.println("System.identityHashCode(str6) = " + System.identityHashCode(str6));
        String str7 = str6.intern();
        System.out.println(str7);
        System.out.println("System.identityHashCode(str7) = " + System.identityHashCode(str7));
        String str8 = "PDP";
        System.out.println("System.identityHashCode(str8) = " + System.identityHashCode(str8));
    }
}
````


````java
public class ProblemWithString {
    public static void main(String[] args) {
      /*String str = "hello->";
        for (int i = 0; i < 1e4; i++) {
            str = str.concat(String.valueOf(i)); // ?
        }
        System.out.println(str);*/

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello->");
        stringBuffer.append("hello->12");
        System.out.println(stringBuffer.capacity());
        stringBuffer.append("12");
        // 16 + 16 + 2
        System.out.println(stringBuffer.capacity());
        System.out.println(stringBuffer.length());
        StringBuffer str = new StringBuffer();
        for ( int i = 0; i < 1e4; i++ ) {
            str.append(i);
        }
        System.out.println(str);

    }
}
````


````java
import java.util.StringTokenizer;

public class WorkingWithStringTokenizer {
    public static void main(String[] args) {
        // " ",\t\n
        /*StringTokenizer stringTokenizer = new StringTokenizer("hello guys, how are you !",
                "o",
                true);
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }*/

        String str = "hello guys, how are you !";
        String[] split = str.split("o");
        for ( String s : split ) {
            System.out.println(s);
        }
    }
}
````

