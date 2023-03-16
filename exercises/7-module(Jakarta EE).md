 <details>
<summary style="font-size:40px;">Lesson 1</summary>

1. Rasmdagi page ni HTML,CSS dan foydalanib yarating !
   ![example](../needed_sources/jakata_ee_lesson_1_exercise_1_img.png)
2. Yuqoridagi rasmdagi page ni HTML,BOOTSTRAP dan foydalanib yarating !
3. HTML, CSS, JS dan foydalanib calculator yarating ?

</details>

------

<details>
<summary style="font-size:40px;">Lesson 2</summary>

1. Qandaydir XYZ Servlet yarating ?
2. XYZ Servlet ni **xml** va **Annotation** yordamida deployment descriptor ga register qiling ?

</details>

------

<details>
<summary style="font-size:40px;">Lesson 3</summary>

1. **_Sonni_**  **Istalgan sanoq sistemasidan** (_2,8,10,16_) **Istalgan sanoq sistemasiga** (_2,8,10,16_) o'tkazadigan
   dasturni JSP va Servlet lardan foydalangan xolda yarating !

</details>

------

<details>
<summary style="font-size:40px;">Lesson 4</summary>

1. Rasmlar Galeriyasi Dasturini Yarating
    * Rasm Yuklay Oling
    * Va Yuklangan Barcha Rasmlarni gallery.jsp file da ko'rsatib bering.

![gallery](../needed_sources/gallery.png)

</details>

------

<details>
<summary style="font-size:40px;">Lesson 5</summary>

# OGOHLANTIRISH (quyidagi topshiriqlarni bajarishda ma'lumotlarni database ga yozish uchun JDBC API dan foydalanib yozing)

1. **Guruh** nomli class yarating va darsdagi book uchun qilingan **crud** kabi guruh ustida crud amalini bararuvchi
   dastur tuzing !
    * **Guruh** classida [_guruh nomi, guruh id, qachon yaratilganligi,talabalar soni_] kabi **field** lari
      bo'n !
2. **Talaba** nomli class yarating va darsdagi book uchun qilingan **crud** kabi guruh ustida crud amalini bararuvchi
   dastur tuzing !
    * **Talaba** classida [_talaba id, qachon yaratilganligi,talabani toliq ismi , talabani yoshi, guruh id si(qaysi
      guruhda o'qishligini ko'rsatib turishi uchun)_] kabi **field** lari bo'lsin !

## Masalan 👇👇👇👇

````java
import java.time.LocalDateTime;

class Group {
    private String id;
    private String name;
    private LocalDateTime createdAt;
    private int studentCount;
    // constructors, getters, setters
}

class Student {
    private String id;
    private String fullName;
    private LocalDateTime createdAt;
    private String groupID;
    private int age;
    // constructors, getters, setters
}
````

</details>

------

<details>
<summary style="font-size:40px;">Lesson 6</summary>

# OGOHLANTIRISH (quyidagi topshiriqlarni bajarishda ma'lumotlarni database ga yozish uchun JDBC API dan foydalanib yozing)

1. **User** nomli class yarating va darsdagi book uchun qilingan **crud** kabi guruh ustida crud amalini bararuvchi
   dastur tuzing !
    * **User** classida [_user id, username_] kabi **field** lari bo'lsin !

   # Masalan

   ````java
   class User {
       private String id;
       private String username;
       //constructors, getters, setters 
   } 
   ````

2. **Login Servlet yarating !**
    * **LoginServlet** ning **doGet** methodida `/views/login.jsp` ga forward qiling.
    * `/views/login.jsp` da 👇👇👇 quyidagiday username ni kiritsin ! ![img](../needed_sources/loginform.png)
    * Login button bosilganda **LoginServlet** ning **doPost** methodiga request ketsin va o'sha yerda database dan
      username orqali user topib **user id** session ga yozib qoyilsin.

3. 5-darsning uyga vazifasidagi code lardan foydalaning va guruh yaratiladigan servlet ga hamda talaba yaratiladigan
   servlet ga filter qo'ying, **Agar** session da **user id** bo'lmasa login page redirect qiling va u yerda login
   qiling (**tepada o'zingiz yozgan login page ga**).
4. 5-darsning uyga vazifasidagi Guruh va Talaba class lariga **createdBy**(kim tomonidan yaratilganligi) degan field
   qo'shing va talaba yoki guruh yaratilayotgan payt **user_id** ni ushbu (talaba/guruh) objectlarning **createdBy**
   degan fieldiga set qilib database yozing.

</details>

------

<details>
<summary style="font-size:40px;">Lesson 7</summary>

1. Lesson 5 dagi vazifalarni database bilan bo'ladigan aloqalarni JPQL dan foydalanib bajaring !

</details>


------

<details>
<summary style="font-size:40px;">Lesson 8</summary>

1. ManyToMany Bo'glanish ga bitta misol yozing !
2. Lesson 6 dagi barcha database bilan bo'ladigan aloqalarni JPQL dan foydalaning  !

</details>

------

<details>
<summary style="font-size:40px;">Lesson 9</summary>
1. Lesson 6 dagi barcha database bilan bo'ladigan aloqalarda Jakarta Bean Validation dan foydalaning  !

# masalan

* Yangi talaba yaratayotgan paytingizda !
* Talabani update qilayotgan paytingizda !
* Yangi Guruh yaratayotgan paytingizda !
* Guruhni update qilayotgan paytingizda !

# OGOHLANTIRISH (Vazifalarni JPQL dan foydalanib bajaring)

</details>


<details>
<summary style="font-size:40px;">Lesson 10</summary>
1. Video da aytib ketilgan !
</details>


