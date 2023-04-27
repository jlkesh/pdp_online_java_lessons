<details>
<summary>Lesson 1 (Spring MVC)</summary>

* `Spring MVC` da `Book` `class` uchun kichik `CRUD` dasturni yozing va qo'shimcha `Book` larni `search` qiladigan (
  qidiradigan) qismi ham bo'lsin.
  `Book` larni `title`, `description` va `author` `field` lari bo'yicha `search` qilsin. Yani text
  kelganda `title`, `description` yoki
  `author` `field` laridan biriga to'g'ri kelsa yoki shu `field` lar ichida bo'lsa ekranga chiqazing.
  ```java
    public class Book {
        private String title;
        private String description;
        private Double price;
        private String author;
        // .... constructors, getters, settters 
    }
    ```

</details>

<details>
<summary>Lesson 2 (Spring REST API)</summary>

* `Store` va `Item` class uchun `CRUD` API chiqaring.
  ```java
    public class Item {
        private Long id;
        private String name;
        private String description;
        private Double price;
        private String path; // file upload qilingan url shu yerda bo'lishi kerak
  
        // .... constructors, getters, settters
    }
    
    public class Store {
        private Long id;
        private String name;
        private String desc;
        
        // .... constructors, getters, settters
    }
    ```
* `File upload` qiladigan va yuklab oladigan API-lar chiqaring. `Upload` qiladigan API dan `Upload object` qaytsin va
  ushbu `object` dan `uploadedPath field` ni qiymatini `Item` `class`ni `path field` ga saqlab keting.
  ````java
  public class Upload{ 
    private String originalName;
    private String generatedName;
    private long size;
    private String mimeType;
    private String uploadedPath;
    // .... constructors, getters, settters
  }
  ````

</details>

# untill done

<details>
<summary>Lesson 3 (Data Jackson)</summary>

* `Car` nomli `class` yarating. Ushbu `class`ni `object`ni `json-ga` o'tkazadigan va `json-dan` `object` ga o'tkazadigan
  methodlar yozing.
  ```java
  public class Car {
        private String color;
        private String type;
        // .... constructors, getters, settters
  }
    ```
* Endi tepadagi `method` larni qayta yozing faqat `Car` object bilan emas objectlarni list json-ga aylantiradigan va
  json-dan `Car` list aylantiradigan methodlarni yozing.
* Endi `Car` objectga yangi property qo'shing va ushbu propertyni json-dan object convert qilayotgan paytda ignore
  qiling.
* `JsonGenerator` pastdagi classni json yarating.
    * ```java
  public class Transaction {

        private Long id;
        private BigDecimal amount;
        private Status status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    
        // standard getters setters
  }

  public enum Status {
  SUCCESS, FAIL
  }
    ```
* Tepadagi `Transaction` classni yaml filega yozadigan va ushbu filedan o'qib object-ga convert qiladigan methodlarni
  yozing.
* `JsonNode` orqali `String` ko'rinshidagi json-dan `amount` va `status` olib qaytaradigan methodlar yozing.
    * ```json
  {
  "id" : 1,
  "amount" : 7534675.43,
  "status" : "SUCCESS",
  "createdAt" : "2019-03-27T10:15:30",
  "updatedAt" : "2022-03-14T11:05:20"
  }
    ```
* `Person` nomli Immutable class yozing. Ushbu classni json ko'rinishda faylga yozadigan va fayldan o'qiydigan
  methodlarni yozing.
    * ```java
  public final class Person {

        private final String firstName;
        private final String lastName;
        private final int age;
        
        // standard getters setters
  }
    ```
* `XmlMapper` dan foydalanib `Person` objectlarni `List` file yozadigan va file o'qiydigan methodlar yozing.
* `@JsonPropertyOrder` annotation foydalanib `Transaction` classni teskari tartibda file yozing.

</details>

<details>
<summary>Lesson 4 (Spring Data JPA)</summary>

* `ObjectMapper` dan foydalanib students va groups json filelaridagi datalarni Object-ga convert qiling va ushbu
  objectlarni
  `JPA` dan foydalanib database-ga saqlang.
    * ```java
  @Entity
  @Table(name = "STUDENT")
  public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)
        private String name;
        
        @Transient
        private Integer age;
        
        @Temporal(TemporalType.DATE)
        private Date birthDate;
        
        @Enumerated(EnumType.STRING)
        private Gender gender;

        // other fields, getters and setters
  }

  public enum Gender {
  MEN, WOMEN
  }
    ```
    * ```java
    @Entity
    @Table(name = "GROUP")
    public class Group {
        
        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        
        @Column(name = "GROUP_NAME", length = 50, nullable = false)
        private String name;
        
        // ...
    }
    ```
* `Spring Data JPA` foydalanib bitta kichik CRUD API dastur yozing `Student` classi ustida.
* `JPA` dan foydalanib Studentlarni tug'ilgan yiliga qarab berilgan yillar o'ralig'idagi studentlarni olib chiqadigan
  method yozing.
    * '2004, 2006' berilsa 2004 va 2006 yilda tugilgan studentlarni olib chiqsin
* `@NamedQuery` annotation-dan foydalangan holda berilgan `Gender` mos studentlarni olib chiqadigan query yozing.
  Ushbu queryni Repository-ni qaysidur methodda foydalaning.
* Tepadagi ishni endi `@NamedNativeQuery` orqali qiling.
* Repository-da Studentlarni `List` pageable orqali olib chiqadigan method yozing.
* `Student` va `Group` nomli 2ta entity-ni `OneToMany` RelationShip-dan foydalanib bir birga bog'lang. Ya'ni
  bitta `Group`
  da bir nechta `Student`lar bo'ladi.
* Istalgan `Group`.id berilganda ushbu groupga tegishli studentlarni olib chiqadigan repository-da method yozing.
* `Student` va `Group` entitylaridan o'zgarish bo'lganda log tashlaydi class yozing. `Slf4j` dan foydalaning log yozish
  uchun
    * Example: Yangi `Student` yaratilsa, update bo'lsa yoki delete bo'lsa log tashlasin.`Group` entitysi uchun ham
      huddi
      shu operatsiyalar sodir bo'lgan log tashlasin.
* `Query Creation` dan foydalanib Repository Group.name teng bo'lgan Group olib chiqadigan method yozing.

</details>

<details>
<summary>Lesson 5 (HATEOAS and Data REST)</summary>

* Entities
    * ```java
  @Entity
  @Table(name = "auth_user", uniqueConstraints = {
  @UniqueConstraint(columnNames = "id")
  })
  public class AuthUserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name = "username", unique = true, nullable = false)
        private String username;
    
        @Column(name = "password", nullable = false)
        private String password;
        
        // ... other fields
  }
    ```
* Spring HATEOAS dan foydalanib CRUD API chiqaring.
* Spring Data REST dan foydalanib ham CRUD API yozing.
* Spring Data REST dan foydalanib `AuthUser` larni `Pageable` orqali olib chiqadigan API chiqazing.

</details>

<details>
<summary>Lesson 6 (Securing REST API)</summary>

* Dars davomida yozilgan security o'zingiz qayta yozib ko'ring!.
* `Item` API lariga faqat ADMIN kiritadigan, `Store` API lariga esa faqat USER kiritadigan check qo'ying method levelda.
    * ```java
  @RestController
  @RequestMapping(value = "/item/*")
  public class ItemController {

        @RequestMapping(value = "create", method = RequestMethod.POST)
        public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        }

        @RequestMapping(value = "update", method = RequestMethod.PUT)
        public ResponseEntity<Item> update(@Valid @RequestBody Item item) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
    
        @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
        public ResponseEntity<String> delete(@PathVariable Long id) {
            return new ResponseEntity<>("Successfully Deleted - Item", HttpStatus.NO_CONTENT);
        }

        @RequestMapping(value = "get/{id}", method = RequestMethod.POST)
        public ResponseEntity<Item> get(@PathVariable Long id) {
            return new ResponseEntity<>(new Item(id,"Swagger", "Lorem Ipsum", 216.86D), HttpStatus.OK);
        }
  }
    ```
    * ```java
    @RestController
    @RequestMapping(value = "/store/*")
    public class StoreController {
    
        @RequestMapping(value = "create", method = RequestMethod.POST)
        public ResponseEntity<Store> create(@Valid @RequestBody Store entity) {
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
        
        @RequestMapping(value = "update", method = RequestMethod.PUT)
        public ResponseEntity<Store> update(@Valid @RequestBody Store entity) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        
        @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<String> delete(@PathVariable Long id) {
            return new ResponseEntity<>("Successfully Deleted - Store", HttpStatus.NO_CONTENT);
        }
        
        @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
        public ResponseEntity<Store> get(@PathVariable Long id) {
            return new ResponseEntity<>(new Store(id, "Store", ".....@gmail.com",
                    20, "The point of using Lorem Ipsum is that it"), HttpStatus.OK);
        }

    }
    ```

</details>

<details>
<summary>Lesson 7 (Swagger UI)</summary>

* Istalgan bitta CRUD API uchun Annotation based configuratsiyadan foydalanib Documentatsiya yozing. `@Operation`,
  `@ApiResponse` va `@ApiResponses` annotationlardan foydalaning
    * ```java
  @Operation(summary = "Create New Store", description = "Lorem Ipsum is simply dummy text of the printing and
  typesetting industry")
  @ApiResponses(value = {
  @ApiResponse(responseCode = "201", description = "Successfully Created", content = {
  @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
  schema = @Schema(implementation = Store.class))
  }),
  @ApiResponse(responseCode = "400", description = "Bad Request", content = {
  @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
  schema = @Schema(implementation = RuntimeException.class))
  }),
  @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
  @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
  schema = @Schema(implementation = RuntimeException.class))
  })
  })
  @RequestMapping(value = "create", method = RequestMethod.POST)
  public ResponseEntity<Store> create(@Valid @RequestBody Store entity) {
  return new ResponseEntity<br>(entity, HttpStatus.CREATED);
  }
    ```
* Har bitta API uchun JWT token qo'shib jo'natadigan Component qo'shing Annotation Configuratsiya bilan.
* API ishlatilingan entity va dto lari uchun ham Documentatsiya yozing. Annotation based Configuratsiya bilan.
    * ```java
  @ParameterObject
  public class Store {

        @Min(1)
        @NotNull
        @Parameter(description = "Store Identifier", required = true)
        private Long id;
    
        @NotBlank
        @Size(min = 3, max = 120)
        @Parameter(description = "Store Name", required = true)
        private String name;
        
        @NotBlank
        @Size(min = 9, max = 250)
        @Parameter(description = "Store Email", required = true)
        private String email;
        
        @NotNull
        @Min(1)
        @Parameter(description = "Store EmployeeCount", required = true)
        private int employeeCount;
        
        @Parameter(description = "Store Description", required = false)
        private String desc;

  }
    ```
* Admin va User uchun API-larni alohida grouplarda chiqaring.
    * ![img](../statics/springdocopenapi_grouped_swagger_options.png)

</details>

<details>
<summary>Lesson 8 (MapStruct, Properties and Yaml, Asynchronous)</summary>

* ```java
  public class Source {
     private String name;
     private String description;
     // getters and setters
  }
  
  public class Destination {
     private String name;
     private String description;
     // getters and setters
  }
  ```

* Tepada e'lon qilingan 2ta class bir birga map qiladigan Mapper class yozing.
* Endi Ushbu `Source` class objectlarni List-ni `Destination` objectlarni List-ga aylantirib beradigan Mapper yozing.
* `EmployeeDTO` va `Employee` classlari bor ularni fieldlarni nomi bir birga tog'ri kelmaydi. EmployeeDTO ni Employee
  va shuni teskarsini bajaradigan methodlarni yozing Mapper classida. `@Mapping` annotatsiyasidan foydalaning
    * ```java
  public class EmployeeDTO {
  private int employeeId;
  private String employeeName;
  // getters and setters
  }

  public class Employee {
  private int id;
  private String name;
  // getters and setters
  }
    ```
* istalgan CarDTO ni Car parse qilayotgan paytda Car.id siga random id generatsiya qilib set qiladigan method yozing.
    * ```java
  Car toEntity(CarDTO carDTO);
    ```
* Bir nechta DTO larni bitta DTO ga aylantirib beradigan method yozing.
* Pastdagi properties filedagi propertylarni Java Objectga parse qiling.
    * ```properties
  database.url=jdbc:postgresql:/localhost:5432/instance
  database.username=foo
  database.password=bar
  secret=foo
    ```
* `@Value` annotation bilan pastdagi classni fieldlariga properties filedagi qiymatlarni bering.
    * ```java
  public class Person {
  private Long id;
  private String name;
  private Integer age;
  }
    ```
    * ```properties
    person.id=1
    person.name=John
    person.age=28
    ```
* Huddi shu ishni endi `@ConfigurationProperties` annotation bilan qiling.
* Endi Tepadagi classga yaml filedan qiymat oladigan qiling.
* yaml fileda name List e'lon qiling va ushbu List Java Object-ga parse qiling.
    * ```yaml
  config:
  env:
    - dev
    - qa
    - prod
      ```
* Async ishlaydigan CRUD API yozing. `@Async` annotation foydalaning.
* Async Exceptionlar ushlaydigan Handler yozing.

</details>

<details>
<summary>Lesson 9 (Profiling, Mailing, Task Scheduling, Logging)</summary>

* Project-ni `test` profile bilan run qilganda dastur h2 databaseda ishlasin. `dev` profile bilan run qilinganda esa
  postgresql databaseda ishlasin.
* Pastdagi yaml propertylarni qiymatlarni Java Object-ga parse qiling. Profilega qarab! yani test
  profile bo'ladigan bo'lsa tepadagini, prod profile bo'ladigan bo'lsa pastdagi propertylarni olsin.
    * ```yaml
  spring:
  config:
  activate:
  on-profile: test
  name: test-YAML
  environment: testing
  enabled: false
  servers:
    - www.abc.test.com
    - www.xyz.test.com

  ---
  spring:
  config:
  activate:
  on-profile: prod
  name: prod-YAML
  environment: production
  enabled: true
  servers:
    - www.abc.com
    - www.xyz.com
  ```
* `FreeMarker`dan foydalanib login va register pagelarni yasang.
* Bundan oldin taskda `FreeMarker` orqali yasalgan login pagega User login qilingda `MailSender` orqali gmailga habar
  yuboradigan qiling.
    * Istalgan habar yuborishingiz mumkin. misol uchun - `Successfully Authorization`
* kichik TODO dastur yozing va dasturda qo'shimcha har kuni ertalab va kechqurun gmail-ga hali bajarilmagan todolarni
  list yuboradigan scheduler yozing.
* `@RequestMapping` annotation qo'yilgan method chaqirilganda, method bajarilishidan oldin log tashlaydigan dastur
  yozing.
* `@Service` annotation qoyil classlarni istal method chaqirilgan log tashlaydigan dastur yozing. log method
  bajarilishidan
  oldin va bajarib bo'lgandan keyin 2marta tashlansin. Methodda exception sodir bo'lganda ham log tashlansin.

</details>

<details>
<summary>Lesson 10 (Project)</summary>

* Airline Reservation System. Bu mijozlar avia chiptalarni buyurtma berishlari va parvoz ma'lumotlarni tekshirish
  uchun foydalanishlari mumkin bo'lgan online platforma. ushbu tizim 3ta tomonlama bo'ladi (Admin, Agent va Customer).
  Ushbu tizimga Companylar o'zlari istagan shaharning istagan airportda parvozlarni amalga oshirishlari mumkin.
  Companylar
  har bir airport uchun bittadan Agent yaratadi ushbu Agent tomonidan parvozlar amalga oshiriladi. Companylarga Agent
  yaratishni
  `Admin`lari tomonidan amalga oshiriladi.
* `Customer`
    * mijozlar dasturdan foydalanishlari uchun ro'yxatdan o'tadilar.
    * mijozlar dasturga kirgandan so'ng yashash shaharlarni tanlaydilar. Keyin esa shahardagi istalgan airportni
      tanlab ushbu airportdagi parvozlar ro'yxat, chiptalari soni, narx va boshqalarni ko'rishlari mumkin bo'ladi.
    * avia chipta olishlar va bekor qilishlari mumkin.
* `Admin`
    * Shaharlar, Airportlar va Companylar, Companylarga tegishli Agentlarni boshqarishilari mumkin bo'ladi yani
      qo'shish, o'chirish va hokazo.
    * Shuningdek admin customer va agentlarni bloklashlari, blokdan ochishlar va shunga o'xshash ishlarni qila olishlari
      mumkin.
* `Agent`
    * Companiya Agentlari haftalik yoki oylik parvozlar ro'yxatni dasturdan ro'yxatdan o'tkazadilar. Misol uchun:
      FlyEmirates bu 2ta parvozni amalga oshirmoqchi. Turkish Airlines bo'lsa 4ta shu haqida oldin ma'lumot beriladi.
      file ko'rinishida json yoki yaml.
    * Keyin Parvoz vaqt o'zgarishi yoki chipta narx yana boshqa o'zgarishlarni ham Agentlar qila oladi.
    * Parvoz vaqt yoki shunga o'xshash muhim o'zgarishla sodir bo'lsa ushbu parvozga chipta olgan barchani gmailga habar
      yuborilsin.
* Ushbu dasturni faqat RESTful APIlar bo'ladi. Frontend yozish shart emas. API larga annotation based configuratsiyadan
  foydalanib swagger-ni yozing va 3ta tomon har bir uchun alohida group oching. Admin uchun adminlarga tegishli API.
  Customer uchun esa customerga tegishli API lar bo'lsin. Agentlar yangi parvoz ro'yxatni tashlaganlarida mijozlarni
  qiziqtirish uchun gmail lariga habar yuboradigan qiling.

</details>