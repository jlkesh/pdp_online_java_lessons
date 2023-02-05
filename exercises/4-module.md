# To'rtinchi Modul uchun Execsicelar

<details>
<summary>Lesson 1</summary>

* Thread classi orqali thread yarating.
* Runnable interface orqali thread yarating
* Thread va Runnable orqali yangi thread yaratib ularni nomini ekranga chiqazing.
* Runnable run() methodi ichida Thread classni sleep() method ishlatib threadni ishlating.
* Daemon thread o'zinigiz yaratib ishlatib ko'ring.
* Bir nechta threadlarni yarating va ularga 1-10 orlig'ida prioritylar bering.

</details>

<details>
<summary>Lesson 2</summary>

* Bitta Counter classini yozing. uni ichida bitta field bo'lsin type int va ichida qiymati bitta oshiruvchi bitta method
  bo'lsin.

```java
public class Counter {

    private int sum = 0;

    public void counter() {
        setSum(getSum() + 1);
    }

    // Standard getters and setters
}
```

* **Synchronized** keywordidan foydalinib tepadagi methodini qayta yozing.
* **Synchronized** method va blocklardan foydalanib dastur yozing.
* **Race condition** ga misol yozing.
* **Race condition** oldini olish uchun Synchronized keywordidan foydalanib tepadagi classga o'xshagan class yozing.
* **Race condition** oldini olish uchun Lock lardan foydalanib tepadagi classga o'xshagan class yozing.
* **Field Visibility** muammosini xosil qiling va shu muammoni xal qilishda **Volatile** keywordidan foydalanib tepadagi classga o'xshagan class yozing.
* **Deadlock** ga tushuvchi class yozing.


</details>

<details>
<summary>Lesson 3</summary>

* Race condition olidini olish uchun Atomic Classlardan foydalanib pastdagi codeni qayta yozing.

```java
public class Counter {

    private int sum = 0;

    public void counter() {
        setSum(getSum() + 1);
    }

    // Standard getters and setters
}
```

* Race condition olidini olish uchun Atomic Classlardan foydalanib dastur yozing.
* Thread-safe collection ishlatgan holda dastur yozing.
* ArrayList thread-safe qilib ushbu collectionni ustida CRUD operastsiyalarni bajaradi dastur yozing.
* Immutable class yozing.

</details>

<details>
<summary>Lesson 4</summary>

* Istagan bitta Executordan foydalanib tasklarni execute qiladigan class yozing.
* Runnable tasklarni alohida, Callable tasklarni alohida execute qiladigan methodlarni ham yozing.
* Callable tasklarni execute qiladigan dastur yozing va Callabledan qaytgan resultni Future tekshiring agar bajarilgan
  bo'lsa ekranga chiqazing.
* Tepada yozgan Callable tasklarni execute qiladigan methodimiz overload qilib qayta yozing va Callabledan qaytgan
  resultni Future tekshiring agar bajarilgan bo'lsa ekranga chiqazing
* ThreadLocal foydalanib har bir userni alohida datalarni saqlaydigan class yozing. ThreadLocal classni methodlaridan
  foydalaning

</details>

<details>
<summary>Lesson 5</summary>

* Fork/Join dan foydalanib tasklarni execute qiladigan dastur yozing.
* CompletableFuture foydalanib asynchron ishlaydigan dastur yozing.
* CompletableFuture foydalanib asynchron ishlaydigan calculator yozing.
* Singleton Pattern mos keladigan class yozing.

</details>

<details>
<summary>Lesson 6</summary>

* Hozirgi vaqtni qaytradigan bir nechta methodlar yozing barcha Time API classlaridan foydalanib
* String qabul qiladigan va LocalDate parse qilib LocalDate qaytaradigan dastur yozing.
* Har 1 minutda ekranga hozirgi vaqtni chiqaruvchi dastur yozing.
* SimpleDateFormat classidan foydalanib Stringni Date parse qiladigan class yozing.
* Time API foydalanib TODO app yozing va taskni vaqti yetib kelganda ekranga habar chiqarsin.
![todo picture](https://github.com/jlkesh/pdp_online_java_lessons/tree/main/statics/img_1.png)
</details>

<details>
<summary>Lesson 7</summary>

* FileReader va FileWriter foydalanib filega yozadigan va o'qiydigan class yozing.
* Object Serialize qilib filega yozing va uni deserialize qilib objectga aylantiring.
* Huddi tepadagi ishni Externalizable bilan qiling.
* transient keywordidan foydalanib serialization bo'ladigan objectni ba'zi fieldlarni qiymatni saqlamang.
* BufferedReader va BufferedWriter foydalanib filega yozadigan va o'qiydigan class yozing.
* File classidan foydalanib file yaratadigan class yozing. Hamda usha yaratilgan filega yozish hamda o'qish
  imkoni bo'lsin
* Boshqa filedan textlarini o'qib yangi file yaratib usha filega yozadigan class yozing.

</details>

<details>
<summary>Lesson 8</summary>

* Presentatsiyada bor.

</details>

<details>
<summary>Lesson 9</summary>

* cmd orqali githubda repository oching va usha repositoryga fileni yuklang.

</details>

<details>
<summary>Lesson 10</summary>

* Tepadagi(Lesson-6 dagi) TODO appni ekranga log tashlaydigan qilib qayta yozing.

</details>

<details>
<summary>Module uchun Mashq</summary>

* Chat App yozing. Barcha ma'lumotlarni fileda saqlang. Authorization qilib keyin chatni ishlata olsin!
  email orqali registeratsiya qila olsin faqat. Login ham email orqali bo'ladi regexpdan foydalanib userni barcha
  ma'lumotlarni tekshiruvdan o'tkazing. Barcha mufaqiyatli bo'lsa log tashlang. User qachon registeratsiya bo'lgani Time
  classlaridan biridan foydalanib filega yozing filedan o'qib usha classga parse qiling. Barcha chatlashuvlarni
  ozi bilan qachon yozilganigacha vaqtni saqlab keting. Dastur yozib bo'lganingizdan keyin githubga qo'ying.

</details>

