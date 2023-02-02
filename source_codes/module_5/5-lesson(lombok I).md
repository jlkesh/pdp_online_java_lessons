````java
@EqualsAndHashCode(of = "pan")
// @NoArgsConstructor(staticName = "getInstance"/*,access = AccessLevel.PRIVATE*/)
@AllArgsConstructor(staticName = "getInstance")
@ToString
@Setter
@Getter
public class Card {

    @NonNull
    private final   String holderName;

    @NonNull
    private final String pan;
    private final String expiry;
}
````

````java
/*
@ToString
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String email;
}
````

````java
@ToString(callSuper = true, includeFieldNames = false)
public class Manager extends User {
    
    private final String role;
    
    public Manager(Integer id, String username, String email, String role) {
        super(id, username, email);
        this.role = role;
    }
}
````

````java
@RequiredArgsConstructor
public class UserRegisterRequest {
 
    private final String username;
 
    @NonNull
    private String password;
 
    @NonNull
    private String email;
}
````

````java
public class Main {

    @Getter(lazy = true)
    private final String id = getUniqueId();

    private String getUniqueId() {
        System.out.println("Generating uniqueID");
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        /*
        Main main = new Main();
        System.out.println("Main object created");
        System.out.println(main.getId());
        */
        /* 
        User user = new User(1, "jlkesh", "john.lgd65@gmail.com");
        Manager manager = new Manager(1, "jlkesh", "john.lgd65@gmail.com", "SALES_MANAGER");
        System.out.println(manager);
        */
        /*
        Card card1 = Card.getInstance(null, "860021435678", "11/26");
        Card card2 = Card.getInstance("John", "860021435678", "02/26");
        Card card = Card.getInstance();
        System.out.println(card1.equals(card));
        System.out.println(card1);
        card.setPan(null);
        */
        UserRegisterRequest user = new UserRegisterRequest("jl", "123","xyz@gmail.com");
    }

}
````