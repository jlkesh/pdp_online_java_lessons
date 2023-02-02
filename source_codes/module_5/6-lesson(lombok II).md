````java
@Builder/*(builderMethodName = "quruvchi",buildMethodName = "qurish")*/
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String fullName;
    private int age;
}
````

````java
@ToString(callSuper = true)
public class Manager extends Employee {
    @Builder.Default
    private String role = "SALES_MAN";

    @Builder(builderMethodName = "childBuilder")
    public Manager(String fullName, int age, String role) {
        super(fullName, age);
        this.role = role;
    }
}
````


````java
@Log
public class Main {

    // private static Logger logger = Logger.getLogger(Main.class.getSimpleName());
    /*@SneakyThrows*/
    public static void main(String[] args) throws IOException {

        /*
        @Cleanup FileInputStream fileInputStream = new FileInputStream("");
        @Cleanup FileOutputStream fileOutputStream = new FileOutputStream("");
        */
        /*
        Employee employee = Employee.builder()
                .fullName("Elmurodov Javohir")
                .age(28)
                .build();
        System.out.println("Hello PDP");
        System.out.println(employee);
        */
        Manager manager = Manager.childBuilder()
                .fullName("Elmurodov Javohir")
                .age(28)
                .build();
        System.out.println(manager);
        /*FileInputStream fileInputStream = new FileInputStream("file.txt");*/
        log.info("Info message logged");
    }
}
````

````java
public class DeclaringVariables {
    public static void main(String[] args) {
        var message = "Hello PDP !";
        val mes = "Hello PDP !";
        System.out.println(message);
        System.out.println(mes);
        message = "Hello PDP Guys";
        //mes = "Hello PDP Guys";
        System.out.println(message);
        System.out.println(mes);
    }
}
````