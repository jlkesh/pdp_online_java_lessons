<details>
<summary>Lesson 1</summary>

````json
  {
  "id": 1,
  "name": "Leanne Graham",
  "username": "Bret",
  "email": "Sincere@april.biz",
  "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  },
  "phone": "1-770-736-8031 x56442",
  "website": "hildegard.org",
  "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
  }
}
````

## [Ko'proq userlar uchun json ni manashu linkdan oling](https://jsonplaceholder.typicode.com/users)

* Yuqoridagi **json** ga mos **users** nomli **collection** yarating.
* **users** ustida **CRUD** qiling.
* **zipcode** 4 yoki 9 bilan tugaydigan Userlari listini qaytaradigan Query Yozing.
* **geo** ni ichidagi **lat** manfiy ishora bilan boshlanadigan Userlarni listini qaytaradigan Query Yozing.
* **website** **.com** bilan tugaydigan Userlari listini qaytaradigan Query Yozing.
* **user** larni **id** bo'yicha company ni ichidagi **catchPhrase** fildini va **address** ni ichidagi **lng** fildini
  update
  qiladigan Query yozing ?

</details>

----
<details>

<summary>Lesson 2(Mongodb with Java)</summary>

* Oldingi darsdagi **users** **collection** ga mos **Java** klaslar yarating. Masalan :
    * User
    * Address
    * Geo
    * Company
* Oldingi darsdagi barcha shartlarni **Java** orqali amalga oshiring.

---

```java
public class Student {
    private String id;
    private String name;
    private Integer age;
    private Date birthDate;
    private Gender gender;
    // .... getters and setters
}
```

```java
public enum Gender {
    MALE, FEMALE
}
```

```java
public class Group {
    private String id;
    private String name;
}
```

1. `Spring Data Mongodb` foydalanib bitta kichik CRUD API dastur yozing `Student` classi ustida.
2. **@Query** annotation-dan foydalangan holda berilgan `Gender` mos studentlarni olib chiqadigan **API** yozing.
3. **Student**larni pageable olib chiqadigan **API** yozing.
4. Istalgan **Group id** berilganda ushbu groupga tegishli studentlarni olib chiqadigan API yozing.
5. **Student** larni listini berilgan **field** ga ko'ra istalgan **order da(asc, desc)** ko'rishinishida chiqaradigan
   API yozing.

* Yuqoridagi 1...5 gacha tasklarni **MongoTemplate** bilan qiling.

</details>

---

<details>

<summary>Lesson 3(Calling External APIs)</summary>

* **DemoAPI-0.0.1.jar** file run qiling.
  ```shell
  java -jar DemoAPI-0.0.1.jar
  ```
* Shu dastur da API lar bor.
    * _/v1/product/create_ **POST request** - Kirib keluvchi `ProductDTO` .
    * _/v1/product/update_ **PUT request** - Kirib keluvchi `ProductDTO` .
    * _/v1/product/delete/{id}_ **DELETE request** - Kirib keluvchi path variable tipi Integer .
    * _/v1/product/get/{id}_ **GET request** - Kirib keluvchi path variable tipi Integer .
    * _/v1/product/list_ **GET request** - Ixtiyoriy kirib keluvchi parameterlar- `ProductCriteria` .
* **Consumer** nomli application yarating va shu application yuqoridagi API larni chaqiradigan **ConsumerService** lar
  yarating va  **DemoAPI** ning API larini chaqirishda **RestTemplate**, **WebClient**, **OpenFeign** lardan
  foydalaning.

```java
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Date date;
}
```

```java
public class ProductCriteria {
    private Long page;
    private Long size;
}
```

</details>

-----

<details>
<summary>Lesson 4(Migrations Tools)</summary>

* `Post` classini FlyWay Migration Toolni Java Based Configuratsiyasi orqali H2 Databasega table yarating va
  boshlang'ich ma'lumotlar insert qiling. **id** auto increment bo'lsin yani id databasega saqlanganda automatik set
  qilinsin.
  ````java
  public class Post {
  
      private Long id; // auto increment
      private String title;
      private String description;
      private String author;
  
      public Post(String title, String description, String author) {
          this.author = author;
          this.title = title;
          this.description = description;
      }
      // Getters and Setters
  }
  ````

* Ushbu pastdagi `Author` va `Post` classlarni many to one relation bilan bir biriga ulab SQL based configuratsiya bilan
  H2 databasega **FlyWay migratsiya** dan foydalanib tabla lar yarating va malumotlar yozing.
  ```java
    public class Author {
    
      private Long id;
      private String firstName;
      private String lastName;
    
      // Standard Getters and Setters
    }
    
    public class Post {
    
      private Long id; // auto increment
      private String title;
      private String description;
      private Long authorId; // authorId -> Author.id
    
      public Post(String title, String description, String author) {
          this.author = author;
          this.title = title;
          this.description = description;
      }
      
      // Standard Getters and Setters 
    }
  ```


* Quyidagi `Job` nomli class Liquibase orqali XML configuratsiya bilan databasega migratsiya qiling ya'ni table yarating
  va boshlang'ich ma'lumotlar insert qiling.
  ```java
  public class Job {
    private String title;
    private Long minSalary;
    private Long maxSalary;
  }
  ```
* minSalary va maxSalary larga qandaydir **check** lar qo'shing. masalan: mminSalary > 0, maxSalary <= 10_000. Bu
  o'zgarishlar **Liquibase** bilan qilinsin.

</details>

---

<details>
<summary>Lesson 5 (Event Oriented Programming)</summary>

* **User** class ustida kichik **CRUD** qiling. database H2 dan foydalaning. User **Create** va **Update** bo'lganda mos
  ravishda **UserCreatedEvent** va **UserUpdatedEvent** eventlarni **publish** qiling va ushbu event larga mos
  ravishda *
  *UserCreatedEventHandler** va **UserUpdatedEventHandler** yarating.
* **UserCreatedEventHandler** da User create bo'lgan event ushlab create bo'lgan user-ni topib **createdAt** fieldga
  hozirgi vaqtni berib update qiling.
* **UserUpdatedEventHandler** da User update bo'lganda ham huddi shunday update bo'lgan userni topib **updatedAt**
  fieldga hozirgi vaqtni berib update qiling.

  ```java
  public class User {
    private String name;
    private Integer age;
    private Instant createdAt;
    private Instant updatedAt;
    // ... other fields
  }
  ```
* **Blog** va **Comment** **class**lari ustida kichik CRUD yozing. **Blog** delete bo'lganda **BlogDeletedEvent** *
  *publish** qiling.
* **BlogDeletedEvent** uchun **BlogDeletedEventHandler** yarating va **BlogDeletedEventHandler** event qabul qilganda
  shu **blog** ga tegishli barcha comment larni ochirib yuboradigan **code** yozing.
  ````java
  public class Blog {
    private String title;
    private String description;
  }
  ````
  ````java
  public class Comment {
      private String author;
      private String message;
      private Blog blog;
  }
  ````  

</details>

---

<details>
<summary>Lesson 6 (Caching)</summary>

* Quyidagi **Student Entity** si uchun **CRUD API** qiling.
* Va ushbu API uchun ConcurrentHashMap dan foydalanib **cacheability principle** ni implement qiling.

* ```java
  public class Student {
    private Long id;
    private String name;
    private int age;
  }
  ```
* Yuqoridagi **Task**ni **Spring-Boot-Cache** orqali qiling.
* Yuqoridagi **Task**ni **Spring-Boot-Cache** va **redis**" orqali qiling.
* Yuqoridagi **Task**ni **Caffiene** orqali qiling.
    * ## Eslatma => Caffiene Cache ni darsda o'rganmaganmiz o'zingiz netdan o'rganib qilasiz bu taskni ?

</details>

---

<details>
<summary>Lesson 7 (Testing)</summary>

* Quyidagi **Math** classini barcha **method lari** uchun **unit test** yozing.
* Yozgan **Unit test** larningiz **F.I.R.S.T** ning talablarini to'liq qondirsin.
* Shu yozgan testlaringiz uchun **test report** hamda **test coverage** yarating(_fire-sure va jacoco dan foydalaning_).
  ```java
  public class Math {
    public int sum(int... args) {
        if ( args == null )
            throw new IllegalArgumentException("Arguments can not be null");
        return Arrays.stream(args)
                .reduce(Integer :: sum)
                .orElse(0);
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        if ( b == 0 )
            throw new IllegalArgumentException("Divider can not be zero");
        return a / b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int pow(int number, int power) {
        int result = 1;
        for ( int i = 0; i < power; i++ )
            result = result * number;
        return result;
    }
  }
  ```

</details>

---

<details>
<summary>Lesson 8 (Mock Testing)</summary>

* Quyidagi **AuthUserController** uchun integration test yozing va **AuthUserService** ni Mock qilib yarating.
    * _Eslatma => @WebMvcTest annotatsiyasidan foydalaning._
* **AuthUserRepository** uchun **integration test** yozing.
    * _Eslatma => @DataJpaTest annotatsiyasidan foydalaning._
* **AuthUserController** uchun **integration test** yozing.
    * _Eslatma => @SpringBootTest annotatsiyasidan foydalaning._

  ```java
  @RestController
  @RequestMapping("/api/authuser")
  public class AuthUserController {
    
    private final AuthUserService service;
  
    public AuthUserController(AuthUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody AuthUserCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>("Successfully Created - User", HttpStatus.CREATED);
    }
  
    @PutMapping
    public ResponseEntity<String> update(@Valid @RequestBody AuthUserUpdateDTO dto) {
        service.update(dto);
        return new ResponseEntity<>("Successfully Updated - User", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>("Successfully Deleted - User", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthUserGetDTO> get(@PathVariable String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthUserGetDTO>> list(@Valid AuthUserCriteria criteria) {
        return new ResponseEntity<>(service.list(criteria), HttpStatus.OK);
    }
  
  }
  ```

</details>

---

<details>
<summary>Lesson 9 (Spring Shell)</summary>

* **Password Manager** dasturini tuzing. Foydalanuvchilarga parollarini **xavfsiz saqlash** va kerak bo'lganda olish
  imkonini beruvchi **command-line** dasturini ishlab chiqing.

  **Dasturda**
    * _add password_
    * _get password_
    * _create password with length_
    * _create strong password_

  kabi **command** lar bo'lsin.
* **URL shortener** dasturi yozing.

  **Dasturda**
    * shorten url
    * get url
    * delete url

  kabi **command** lar bo'lsin.

</details>

---

<details>

<summary>Lesson 10 (GraphQL)</summary>

```java

class Todo {
    private Integer id;
    private String title;
    private String description;
    private Category category;
    private Level level;
    private LocalDate deadLine;
    private boolean completed;
}

class User {
    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private List<Todo> todos;
}

enum Category {
    ENTERTAINMENT,
    STUDY,
    WORK
}

enum Level {
    LOW,
    MEDIUM,
    HIGH
}
```

* Yuqoridagi class lardan foydalanib **Todo Application** qiling va **GraphQL** da API chiqaring.
* Siz chiqaradigan API larda quyidagilarni imkoni bo'lsin.
    * **User** Yaratish
    * Aynan bir **User** ni ma'lumotlarni olib kelish
    * **User** larni listini olib kelish
    * **Todo** yaratish
    * **Todo** ni complete qilish
    * **Todo** ni o'chirish
    * **Todo** ni update qilish
    * **Todo** larni Listini level bo'yicha olish
    * **Todo** larni listini category bo'yicha olish
    * **Todo** larni listini deadLine bo'yicha olish
    * Xar bir **User** ni ma'lumotlari bilan birga shu **User** ga tegishli **Todo** larni listini ham chiqarish.
</details>
