<details>
<summary>Lesson 1 (Introduction)</summary>

* **Store** va **Item** nomli classlarni yozing. Store Classida Item classni fieldi sifatida e'lon qiling.
* XML Based konfiguratsiya bilan tepada yozilgan 2ta classni beanga aylantiring.
* **Store** va **Item** **bean** larini **SI** va **DI** bilan bog'lang.
* **SI** va **DI** ni amalga oshirayotgan vaqtingizda **c** va **p** **namespace** lardan foydalaning.
* Yuqoridagi **Class** lardan **bean** lar yasash hamda ularni **wire** qilishda **Java Config** ham **Auto Config**
  usullaridan ham foydalaning.
* **Student** nomli **bean** yarating va uni ichida fanlarni **List** va xar bitta fan va uni bahosini saqlaydigan **Map
  ** fieldlari bo'lsin.

</details>

------



<details>
<summary>Lesson 2 (Bean Scope, SpEL)</summary>

* XML Based konfiguratsiyadan foydalanib **City** nomli beani yarating va uni 3ta field
  bo'lsin `name`, `numberOfPeople`, `size` va ushbu bean scope ni prototype qiling.
* `city.properties` degan file dan yuqorida `city` `bean ini` `field` lariga qiymatlarni **SpEL** dan foydalangan xolda
  bering.
* Tepada aytib o'tilgan 2ta vazifani **Java Config** bilan amalga oshiring.

# Example

```java

@Component
public class SomethingBean {

    @Value("#{1 + 2}")
    public int somethingValue;

    // ...
}
```

</details>



------

<details>
<summary>Lesson 3 (AOP)</summary>

* `Transform` nomli class yarating va uni ichida **1..10** gacha bo'lgan sonlarni ekranga chiqaruvchi start()
  nomli `method`
  yozing va ushbu `method` chaqirilganda `method` bajarilishidan oldin va keyin log tashlaydigan dastur yozing. XML
  Based
  konfiguratsiyadan foydalanib. _**Before**, **After** va **AfterReturning** **Advice** laridan foydalaning_.
* `Transform` `class` ni start `method` chaqirilganda endi `exception` sodir bo'lsa log tashlaydigan dastur yozing.
* Va Yuqoridagi Topshiriqlarni **Java Config** yordamida amalga oshiring.

# Example

```java

@Aspect
@Component
public class TransformAspect {
    // ...
}
```

</details>

------

<details>
<summary>Lesson 4 (Spring MVC)</summary>

* `Todo` hamda `TodoController` degan `class` lar yarating.
* `TodoController` da `Todo` larni `List` tini saqlovchi field bo'lsin.
* `/todos` degan `api` yarating va undan todo larni `list` tini `html table` ga chizib response sifatida qaytaring.
* # THMELEAF VA HTML FAYLLARDAN FOYDALANILMASIN !

</details>

------

<details>
<summary>Lesson 5(Thymeleaf)</summary>

* **Todo Application** yarating.

```java 
import java.time.LocalDateTime;

class Todo {
    private Integer id;
    private String title;
    private String priority;
    private LocalDateTime createdAt;
    // constructors
    // getters and setters
}
```

* `todo` qo'shadigan, `todo` ni o'chiradigan qiladigan, `todo` ni update qiladigan `page` yarating.
* `todo` ni larni listini ko'rsatadigan `html page` yarating va shu `page` da `todo` larni listini chizing !
* `todo` listalarida eng oxirigi qo'shilgan todo eng biringchilikda chiqsin.

# Todo lar List DA saqlansin DataBase da emas

</details>

------

<details>
<summary>Lesson 6(Spring JDBC)</summary>

* Lesson 5 dagi vazifani `JdbcTemplate` bilan qiling !
* Lesson 5 vazifasidagi `insert` larni `SimpleJDBCInsert` bilan qiling qolgan operation larda(_delete, update,
  select_) `JdbcTemplate` dan foydalaning !
* Lesson 5 dagi vazifani `NamedParameterJdbcTemplate` bilan qiling !
* Lesson 5 dagi vazifani `SimpleJDBCCall` bilan qiling ! (`database` da _save, delete, update, getAll_ degan `function`
  lar yaratishingiz kerak bo'ladi.!)

</details>

------

<details>
<summary>Lesson 7(Spring Security)</summary>

* Lesson 6 dagi vazifaga `spring security` ni qo'shing.
* User `Login` va `Register` qilishi uchun `page` va `controller` lar yarating.
* Xar Bir `USER` o'ziga tegishli bo'lgan todo lar ustidagina `CRUD` amalini bajara olsin.
* Dastur da `USER` ham da `ADMIN` degan `Rollar` bo'lsin `ADMIN` lar oddiy userlar qila oladigan ishlarni qila olish
  bilan birga oddiy user larni `block` ham qila olsin. `block` langan userlar `login` qila olmasin.

</details>

------

<details>
<summary>Lesson 8(Upload and Download)</summary>

* Lesson 7 dagi vazifaga `user register` qilayotgan payt da `profil` uchun rasm ham yuklang.
* Va yuklangan rasm doyim `Login` qilinganidan keyin Barchar `Page` larda `navbar` da chiqib tursin kichik qilib.
* Va shu `application` ni `localization` qiling.

</details>

------

<details>
<summary>Lesson 9(Error Handling, Validation, Filter and Interceptor)</summary>

* Lesson 8 dagi vazifada `register user` qilayotgan vaqtingizda formaga validation qo'shing. Va Ma'lum tekshiruvlardan
  o'ta olmasaxatolik xabarini chiqaring.
* Lesson 8 dagi vazifada `create todo` qilayotgan vaqtingizda formaga validation qo'shing. Va Ma'lum tekshiruvlardan
  o'ta olmasaxatolik xabarini user ni `til`ida chiqaring.
* Masalan `/todos/2` ga `request` jo'natilganda agar `id` si `2` ga teng bo'lgan `todo`
  topilmasa `TodoNotFoundException` ni `throw` qiling va shu `TodoNotFoundException` uchun `ExceptionHandler` yozing.

</details>

------

<details>
<summary>Lesson 10( Project )</summary>

**Weather Service**. Ob havo ma'lumotlarni beruvchi dastur yozing. Ushbu dasturda **Admin** va **User** 
alohida API lar bo'ladi. Ob havo ma'lumotlarni **Admin**lari tomonidan yaratiladi va databaseda saqlanadi, so'ralganda 
databasedan olib keladi. Hech qanday API dan olib kelinmaydi.

* Admin API
  * `User List` - barcha userlarni list olishi mumkin
  * `User Detail` - user qaysi citylarga subscribe bo'lgani ro'yxatni va userga tegishli ma'lumotlarni olishi mumkin.
  * `User Edit` - user edit qilishi ham mumkin.
  * `Cities List` - Citylarni list olishi ham mumkin.
  * `Edit City` - City edit qila olishi ham mumkin.
  * `Add City` - City qo'sha olishi ham mumkin.
* User API
  * `Register` - user registeratsiya qilib keyin API foydalana olishi kerak.
  * `Login` - username va password orqali login qiladi.
  * `Cities List` - City larni list olishi mumkin.
  * `Subscribe To City` - City subscribe qila olishi mumkin.
  * `Get Subscriptions` - Subscribe bo'lgan Citylarni faqat ob havo ma'lumotlarni olishi mumkin.
  1 kunlik, 1 haftalik va 1 oylik
</details>

------
