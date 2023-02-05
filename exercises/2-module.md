# Ikkinchi Modul uchun Mashqlar

<details>
<summary>Lesson 1</summary>
<ul>
<details>
<summary>1. Book Class - Oson</summary>

* Kitob classini yarating
* Nomi, Muallifi, SahifaSoni nomli fieldlari bo'lsin
* Nom, muallifi, sahifaSoni malumotlarini chiqaruvchi
  print method bo'lsin va ekranga malumotlar chiqarilsin

</details>
</ul>

<ul>
<details>
<summary>2. Kalkulator class - Qiyin</summary>

* Kalkulator classi yaratilsin
* 2ta sonni saqlovchi first va second , belgi saqlovchi sign va natijani saqlochi result fieldi bo'lsin
* calculate methodi bo'lsin . First va second methodi sign orqali qiymatlarni hisoblasin.
  Masalan: signni qiymati ( + ) bo'ladigan bo'lsa first va secondni yi'gindisini resultga o'zlashtirsin;
* Print methodi ham bo'lsin. Malumotlarni "first sign second = result" ko'rinishida chop etsin

</details>
</ul>

<ul>
<details>
<summary>3. Todo Class - Juda Qiyin</summary>

* Todo Classi yaratilsin
* Nomi, tugash muddatini anglatuvchi day(kun),
  bajarilgani yoki yo'qligini bildiradigan isComplete(bajarilganmi),
  todo ni o'chirilgan yoki yo'qligini bildiruchi isDeleted(o'chirilganmi) nomli fieldlari bo'lsin.
* done(bajarildi), deleted(o'chirildi) va malumotlarni "Nomi day isCompleted" ko'rinishida print nomli methodlari bo'
  lsin.
* objectlar massivda saqlansin va ochilmaganlarini consolega chizing.

</details>
</ul>

### Pdp ning vazifalari

1 - topshiriq Oson
X va Y koordinatalarni ifodalovchi atributlari bor bo’lgan Point classini yozing.
Koordinatalarni “(45, 56)” shaklda chop etuvchi printXY() methodini yozing.

2 - topshiriq Oson
To’g’ri burchakli uchburchak klassini yarating. Uning barcha atributlari va
methodlariga mos nom va toifa tanlang. (Eni va bo’yi attributlari, Perimetrini
va Yuzasini hisoblaydigan 2 ta methodi bo’lsin).

3 - topshiriq Qiyin
Ikkita atribut: firstAtribut va secondAttribut larga ega MyClass nomli klass
yarating. Ushbu atributlar qiymatini aboutAttributes, yig’indisini sumAttributes,
kattasini maxAttribute ekranga chiqazadigan methodlarini yarating.

4 - topshiriq Qiyin
Quyidagi 3ta attribute bor bo’lgan Date klassini yarating: yil, oy va kun.
15.05.2020 formatdagi sanani chop etuvchi mehod yarating.

5 - topshiriq Qiyin
Quyidagi atributlari bor bo’lgan Student nomli klass yarating:
familiya, ismi, guruh nomeri, o’qiydigan fanlari (5 ta fandan iborat massiv).
O’qidigan fanlari ro’yxatini ekranga chiqazuvchi printSubjects nomli method yarating

</details>

<details>
<summary>Lesson 2</summary>

### Har bir topshiriq com.pdp.online.task.number o'ziga hos package yo'llarida yozilsin!

Masalan: com.pdp.online.task.one.Rectangle, com.pdp.online.task.two.User
<ul>
<details>
<summary>1. Rectangle(to'rtburchak) Class - Oson</summary>

* Width, height va result fieldlari bo'lgan Rectangle classini encapsulation prinsipi asosida yarating
* result ga to'rtburchakning yuzi hisoblanib o'zlashtiradigan calculate methodi bo'lsin
* "width * height = reult" ko'rinishida consolega chop etilsin.

</details>
</ul>

<ul>
<details>
<summary>2. User Class - Oson</summary>

* Ism, Familya, PhoneNumber, Age va isMale fieldlari bo'lgan User classini encapsulation prinsipi asosida yarating
* "Ismi: Familya Ism, yoshi: age, telefoni raqami: phoneNumber, Jinsi: isMale" ko'rinishida consolega chop etilsin.

</details>
</ul>

<ul>
<details>
<summary>3. ClassRoom Class - Qiyin</summary>

* roomNumber,teacherName,teacherPhoneNumber, studentName (bittadan ko'p bo'ladi) va studentCount
  fieldlari bo'lgan ClassRoom classini encapsulation prinsipi asosida yarating
* Malumotlar console orqali kiritilsin.
* roomnumber, teacherNmae va studentlarini chop eting

</details>
</ul>

<ul>
<details>
<summary>3. Pen Class - Juda Qiyin</summary>

* miqdor,clicked va oneLetter fieldlari bo'lgan Pen Classi encapsulation prinsplariga asoslangan holda yaratilsin.
* Miqdor -> ruchkani siyohi qanchaligi
* Clicked -> ruchka bosilganmi yoki yo'q
* OneLetter -> bitta harf uchun qancha siyoh ketishi
* write methodi orqali ruchka yoshishni boshlasin. Katta harf yozilganda kichkina harfga qaraganda
  2 barobar siyoh sarflasin, agarda bo'sh joy keladigan bo'lsa siyoh sarflanmasin. Agar siyoh tugasa ruchka yozishdan
  to'xtasin va yozilgan text consolega chiqarilsin.

</details>
</ul>

### Pdp ning vazifalari

1.Oson
Quyidagi 3ta attribute bor bo’lgan Time klassini encapsulation prinsipi asosida yarating: soat, minut, va sekund. “soat:
minut:sekund” (Masalan: 01:25:08) formatdagi vaqtni qaytaruvchi mehod yarating.

2.Qiyin
Quyidagi attributlardan iborat Book klassini encapsulation prinsipi asosida yarating: nomi, avtorlari (bir nechta
bo’lishi mumkin), ISBN(13 ta sondan iborat xalqaro kitob raqami, masalan 012345689112) va narxi.
Kitob nomi va avtorlarini chop etuvchi method yarating.

3.JudaQiyin
write methodini ruchka kotta harfni yozganda kichik harfga qaraganda 2 marta ko'p siyoh sarflaydigan, probel (bo'sh joy)
ni yozganda siyoh sarflanmaydigan va siyoh tugagan payt yozishdan to'xtaydigan qilib o'zgartirish

</details>

<details>
<summary> Lesson 3 </summary>

<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

<img src="../needed_sources/model2-lesson3-task1.png" alt="not found">

Rasmbda berilgan struktura asosida classlarni yarating.
</details>
</ul>

<ul>
<details>
<summary>2.Topshiriq - Juda Qiyin</summary>

<img src="../needed_sources/model2-lesson3-task3.png" alt="not found">

* Rasmbda berilgan struktura asosida classlarni yarating.
* Bir necha Student objectlar dan tashkil topgan massiv yarating
* Studentdan yangi object yarating va osha object massiv ichida teng bolgan
  objectni topib, massiv ichidan topilgan Student objectini passwordini o'zgartiring.
* Ozgartiryapganda oldPassword oldingi passwordga teng bo'lsa yangisini o'zlashtiring

</details>
</ul>

### Pdp vaziafalari

other topshiriq -
Har qanday hayvonning oyoqlari(nectaligi) va rangi bor. Ayrim hayvonlarning sut emizuvchilik xususiyati mavjud, Uy
havonining ismi(laqabi) bor. Qushlar ham hayvon bo’lib qanotining uzunligi bor va ular uchadigan yoki uchmaydigan
bo’lishadi. Tuyaqush uchmaydigan qush va ko’rshapalak sut emizuvchi hisoblanadi.
Hayvon (Animal) va uy hayvoni (Pet), qush(Bird), mushuk (Cat), it(Dog), sigir (Cow), Tuyaqush(Straus), Ko'rshapalak(
Bat), burgut(Eagle)  klasslarini OOPning inheritance prinsiplari asosida yarating. Klasslarning voris olish sxemasini
tuzing. main methodida harbir hayvondan 1 tadan object yarating.

<img src="../needed_sources/vazifa_4_1.png" alt="not found">
<img src="../needed_sources/vazifa_4_2.png" alt="not found">
<img src="../needed_sources/vazifa_4_3.png" alt="not found">

</details>

<details>
<summary>Lesson 4</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

<p>Har xil shaklarning premetrini hisoblovchi methodlari bor bo'lgan 
Figure classini polymorphismni overloading usulini qo’llagan holda yarating: </p>

* To'g'ri to'rtburchak(2 ta son beriladi)
* Uchburchak (3 ta son beriladi)
* Kvadrat (1 ta son beriladi)
* BeshBurchak (5 ta son beriladi)

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Qiyin</summary>

<p> Math classini o'zimiz polymorphism dan foydalanib yaratish. </br> 
MyMath classini yarating. 2 ta sonni qoshuvchi methodlarni overloading qiling</p>

* matn va sonni ni qo'shadigan
* matn va double ni qo'shadigan
* matn va matn ni qo'shadigan
* son va sonni ni qo'shadigan
* double va double ni qo'shadigan
* double va sonni ni qo'shadigan


</details>
</ul>
<ul>
<details>
<summary>3.Topshiriq - Qiyin</summary>

<p> Math classini o'zimiz polymorphism dan foydalanib yaratish. </br> 
MyMath classini yarating. 2 ta sonni qoshuvchi methodlarni overloading qiling</p>

* matn va sonni ni qo'shadigan
* matn va double ni qo'shadigan
* matn va matn ni qo'shadigan
* son va sonni ni qo'shadigan
* double va double ni qo'shadigan
* double va sonni ni qo'shadigan


</details>
</ul>


</details>

<details>
<summary>Lesson 5</summary>

* 1.Mashq. Absraction. Consolega nima chiqadi

```java
public class VehicleTypes {
    interface Vehicle {
        public int getNoOfWheels();
    }
}

public class Bus implements VehicleTypes.Vehicle {
    public int getNoOfWheels() {
        return 6;
    }
}

public class Car implements VehicleTypes.Vehicle {
    public int getNoOfWheels() {
        return 4;
    }
}

public class Bike implements VehicleTypes.Vehicle {
    public int getNoOfWheels() {
        return 2;
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Bus b = new Bus();
        System.out.println(b.getNoOfWheels());

        Car c = new Car();
        System.out.println(c.getNoOfWheels());

        Bike bk = new Bike();
        System.out.println(bk.getNoOfWheels());
    }
}
```

* 2.Mashq. Absraction. Consolega nima chiqadi

```java
public class Cube {
    protected interface Number {
        public void calculateCube(int n);
    }
}

public class Five implements Cube.Number {
    public void calculateCube(int n) {
        int cubeN = n * n * n;
        System.out.println("Cube of 5: " + cubeN);
    }
}

public class Ten implements Cube.Number {
    public void calculateCube(int n) {
        int cubeN = n * n * n;
        System.out.println("Cube of 10: " + cubeN);
    }
}

public class CubeTest {
    public static void main(String[] args) {
        Five f = new Five();
        f.calculateCube(5);

        Ten t = new Ten();
        t.calculateCube(10);
    }
}
```

</details>

<details>
<summary>Lesson 6</summary>

* 1.Mashq. Inner Class. Consolega nima chiqadi

```java
public class A {
    class B {
        public void m1() {
            System.out.println("Inner class method");
        }
    }

    void m2() {
        System.out.println("Outer class instance method");
        B b = new B();
        b.m1();
    }

    public static void main(String[] args) {
        A a = new A();
        a.m2();
    }
}
```

* 2.Mashq. Wrapper classes. Consolega nima chiqadi

```java
public class Wrapping {
    public static void main(String[] args) {
        int a = 50;
        Integer i = Integer.valueOf(a);
        Integer j = a;
        System.out.println(a + " " + i + " " + j);
    }
}
```

* 3.Mashq. Boxing. Consolega nima chiqadi

```java
public class One {
    void m1() {
        System.out.println("m1 method in class One");
    }
}

public class Two extends One {
    void m1() {
        System.out.println("m1 method in class Two");
    }
}

public class Test {
    public static void main(String[] args) {
        One o = (One) new Two();
        o.m1();
    }
}
```

</details>

<details>
<summary>Lesson 8</summary>

* 1.Mashq.Static and Instance Initializer Block. Consolega nima chiqadi

```java
public class MultipleIIB {
    MultipleIIB() {
        System.out.println("0-arg constructor");
    }

    MultipleIIB(int x) {
        System.out.println("1-arg constructor");
    }

    {
        System.out.println(" First IIB");
    }

    {
        System.out.println("Second IIB");
    }

    public static void main(String[] args) {
        new MultipleIIB();
        new MultipleIIB(5);
    }
}
```

* Flower outer class yarating va sealed orqali Flower classiga tegishli qilaslar
  voris ololadigan qilib cheklab qoying


* 2.Mashq. Non-access modifiers. Consolega nima chiqadi

```java

class Page {
    static int count = 0;

    void myMethod() {
        count++;
        System.out.println(count);
    }
}

class GFG {
    public static void main(String[] args) {
        Page obj1 = new Page();
        obj1.myMethod();
        Page obj2 = new Page();
        obj2.myMethod();
    }
}
```

* 3.Mashq. Non-access modifiers. Code muvaffaqiyat compile boladimi? Agar bo'lmasa xatoni toping.

```java
class SuperClass {
    final void myMethod() {
        System.out.println("method of SuperClass");
    }
}

class SubClass extends SuperClass {
    void myMethod() {
        System.out.println("Overrides SuperClass");
    }
}

class GFG {
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.myMethod();
    }
}
```

</details>

<details>
<summary>Lesson 9</summary>

* O'lchamlarni saqlovchi Size nomli Enum classi yaratilsin.
* Clothes nomli class yarating unda rangi va Size enumini ham saqlang
* Class yaratyapganda asosiy qoidalariga etibor bering
* Clothesdan object yaratib uni qiymatini saqlash uchun var keywordidan foyalaning

</details>

<details>
<summary>Lesson 10</summary>

* Dog class yarating nameini saqlovchi field bilam, va unda 2 ta object yaratib uni Objects classing equals methodi
  orqali tenglikka tekshiring
* Cat classni yarating UUID saqlovchi id,name fieldlari bilan, buni ham equals methodi orqali tekshiring
* Undan oldin hamma objectni requireNonNull method orqali tekshiring
* Va har bir field,method,class va package ga documentation yozing va JavaDocni generate qiling

</details>

