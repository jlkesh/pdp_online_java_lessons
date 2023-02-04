````java
package uz.pdp.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("e.{2}");
        Matcher matcher = pattern.matcher("Hello PDP 535 Some random text 34");
        // System.out.println(matcher.matches());
        while ( matcher.find() ) {
            System.out.println("start=" + matcher.start() + ", end=" + matcher.end() + ", group=" + matcher.group());
        }
    }
}
````
````java
package uz.pdp.regex;

import java.util.Arrays;

public class StringRegexExample {
    public static void main(String[] args) {
        String input = "Some 12 random 3 Text 90 For Fun 2 oor 1243";
        /*String input = "12344567qw";*/
        /*String[] split = input.split("\\d+");*/
        /*System.out.println(Arrays.toString(split));*/
        /*System.out.println(input.matches("\\d{4,}"));*/
        /*input.replace("12","PDP");*/
        String welcomePdp = input.replaceAll("\\d+", "Welcome PDP");
        System.out.println(welcomePdp);
    }
}
````
````java
package uz.pdp.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static final Pattern VALID_EMAIL_PATTERN = Pattern.compile("(\\w+)@([\\w-]+)\\.(\\w{2,4})");
    public static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*\\d+)(?=.*[!@#$&*?><]+).{8,30}$");
    private static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile("^(\\+998)((71|88|9[01349])(\\d{7}))$");

    public static boolean isValidPhoneNumber(String input) {
        if ( input == null )
            throw new RuntimeException("Input can not be null");
        return VALID_PHONE_NUMBER_PATTERN.matcher(input).matches();
    }

    public static boolean isValidEmailAddress(String input) {
        if ( input == null )
            throw new RuntimeException("Input can not be null");
        return VALID_EMAIL_PATTERN.matcher(input).matches();
    }

    public static boolean isStrongPassword(String input) {
        if ( input == null )
            throw new RuntimeException("Input can not be null");
        return STRONG_PASSWORD_PATTERN.matcher(input).matches();
    }

    public static List<String> getWords(String input) {
        if ( input == null )
            throw new RuntimeException("Input can not be null");
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(input);

        List<String> words = new ArrayList<>();
        while ( matcher.find() )
            words.add(matcher.group());
        return words;
    }
}
````
````java
package uz.pdp.regex;

public class StringUtilsTest {
    public static void main(String[] args) {
        System.out.println(StringUtils.getWords("Hello PDP 12, Welcome to Bootcamp"));
    }

    private static void testStrongPassword() {
        System.out.println(StringUtils.isStrongPassword("123"));
        System.out.println(StringUtils.isStrongPassword("Q123"));
        System.out.println(StringUtils.isStrongPassword("Q1aqws2$3"));
    }

    private static void testEmailAddress() {
        System.out.println(StringUtils.isValidEmailAddress("john.asd"));
        System.out.println(StringUtils.isValidEmailAddress("john@.asd"));
        System.out.println(StringUtils.isValidEmailAddress("john@gmail.com"));
    }

    private static void testPhoneNumber() {
        System.out.println(StringUtils.isValidPhoneNumber("+998906775445"));
        System.out.println(StringUtils.isValidPhoneNumber("998906775445"));
        System.out.println(StringUtils.isValidPhoneNumber("+99890677544q"));
        System.out.println(StringUtils.isValidPhoneNumber("+99895677544q"));
        System.out.println(StringUtils.isValidPhoneNumber("+99995677544q"));
    }
}
````