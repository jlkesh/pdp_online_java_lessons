<details>
<summary>Lesson 1</summary>

* Store va Item nomli classlarni yozing. Store Classida Item classni propertysi sifatida e'lon qiling. 
* XML Based konfiguratsiya bilan tepada yozilgan 2ta classni beanga aylantiring. Company Bean c-namespace orqali 
propertysini ishga tushiring. Item Bean p-namespace orqali propertylarni ishga tushiring.
* Java Based konfiguratsiya bilan tepada yozilgan 2ta classni Beanga aylantiring. Ushbu Beanlarni propertylarni 
postConstruct va preDestroy methodlari yordamida ishga tushiring.
* Student nomli bean yarating va uni ichida subjectlarni **List** va har bitta fan va uni bahosini saqlaydigan **Map** 
fieldlari bo'lsin.

</details>

------

<details>
<summary>Lesson 2 (Bean, SpEL)</summary>

* XML Based konfiguratsiyadan foydalanib **Company** va **Address** nomli beanlarni yarating va ularda istalgan typedagi 
propertylarni yozing.
* va ushbu beanlarni propertylarga **SpEL** orqali value bering.
* Huddi shu ishni ya'ni **SpEL** orqali propertylarga value berishini **Annotation** Based konfiguratsiya orqali qiling.
pastda example bor.

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

* Transform nomli class yarating va uni ichida 1..10 gacha bo'lgan sonlarni ekranga chiqaruvchi start() nomli method 
yozing va ushbu method chaqirilganda method bajarilishidan oldin va keyin log tashlaydigan dastur yozing. XML Based 
konfiguratsiyadan foydalanib, **Before**, **After** va **AfterReturning** **Advice** laridan ham foydalaning.
* Transform classni start method chaqirilganda endi exception sodir bo'lsa log tashlaydigan dastur yozing. Java Based
konfiguratsiyadan foydalanib. **TransformAspect** classida barcha Advicelarni (**@Before**, **@After**, **@AfterReturning** va 
**@AfterThrowing**) yozing.

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

* Spring MVC dan foydalanib databasedan userlarni olib ekran chiqazuvchi dastur yozing.
* Har bir userni to'liq ma'lumotlarni ko'rish uchun ham alohida pageda ko'rsatadigan API bo'lsin.

</details>

------

<details>
<summary>Lesson 5(Thymeleaf)</summary>

* 4chi darsda yozgan dasturimizni thymeleafdan foydalanib CRUD amallarni qila olish imkoniyatlarni ham qo'shing.

</details>

------

<details>
<summary>Lesson 6(Spring JDBC)</summary>

* Spring JDBC dan foydalanib CRUD qiling va API chiqazing.

</details>

------

<details>
<summary>Lesson 7(Spring Security)</summary>

* Spring Security o'zingiz qaytadan yozing va endi username bilan emas, email orqali kira oladigan qiling.
* va Thymeleaf orqali login va register page yarating.

</details>

------

<details>
<summary>Lesson 8(Upload and Download)</summary>

* Multi File qabul qiladigan va yuklab bo'lgandan so'ng filelarni pathni List qilib qaytaradigan Rest API yozing.

</details>

------

<details>
<summary>Lesson 9(Error Handling, Validation, Filter and Interceptor)</summary>

* Blog yaratadigan dastur yozing.
* Agar Blog toplimasa Error ni ushlang va ekranga 404 page chiqazing.
* Blog Create qiloyotgan paytda validatorlar qo'shing. Agar fieldlardan biri valid bo'lmasa error tashlangan.
* Errorlarni user tanlagan tilga qarab textlarni o'zgartiring.

</details>


