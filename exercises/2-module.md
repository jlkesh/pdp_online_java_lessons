# Ikkinchi Modul uchun Mashqlar

<details>
    <summary>Lesson 1</summary>
    Mashina classini yarating. Class ishida mashinaga xos xusiyatlari 
    (field) va vazifalarini (method) yarating . Mashina classidan constructor orqali 10 ta object yarating.
</details>

<details>
    <summary>Lesson 2</summary>
    <b>package com.pdp.uz</b> packageda joylashgan 
    Animal nomli class yarating. Va unda Encapsulationni taminlang .
    5ta Telefon objectini yaratib methodlar oqrali consolega chiqaring.
</details>

<details>
<summary> Lesson 3 </summary>

* 1.Mashq Quyidagi nima chiqadi

```java
   public class P {
    int a = 30;
}

public class Q extends P {
    int a = 50;
}

public class Test extends Q {
    public static void main(String[] args) {
        Q q = new Q();
        System.out.println(" Value of a: " + q.a);
        P p = new Q();
        System.out.println("Value of a: " + p.a);
    }
  }
  ```

* 2.Mashq. Consolega nima chiqadi

```java
    public class Baseclass {
    private int x = 30;
    protected int y = 50;

    private void m1() {
        System.out.println("Base class m1 method");
    }

    protected void m2() {
        System.out.println("Base class m2 method");
    }
}

public class Derivedclass extends Baseclass {

}

public class MainClass {
    public static void main(String[] args) {
        Derivedclass d = new Derivedclass();
        d.m2();
        System.out.println("y = " + d.y);
    }
}
  ```

* 3.Mashq. Consolega nima chiqadi

```java
public class Calculation {
    int calArea(int length, int breadth) {
        return (length * breadth);
    }
}

public class Rectangle {
    Calculation cal; // Use of Aggregation.

    int area(int length, int breadth) {
        cal = new Calculation();
        int areaRec = cal.calArea(length, breadth); // code reusability.
        return areaRec;
    }
}

public class Test {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        int result = rec.area(25, 60);
        System.out.println("Area of rectangle: " + result);

    }
}
```

</details>

<details>
<summary>Lesson 4</summary>

* 1.Mashq. Consolega nima chiqadi

```java
public class Lion {
    public Lion() {
        System.out.println("Lion constructor worked");
    }

    private void eat() {
        System.out.println("Lion eats flesh");
    }

    static void live() {
        System.out.println("Lion lives in Jungle");
    }

    public static void main(String[] args) {
        Lion l = new Lion();
        l.eat();
        Lion.live();
    }
}
```

* 2.Mashq. Overloading Consolega nima chiqadi

```java
public class A {
}

public class B extends A {
}

public class C extends B {
}

public class OverLoadingScenarios {
    void m1(A a) {
        System.out.println(" I am in m1-A");
    }

    void m1(B b) {
        System.out.println("I am in m1-B");
    }

    void m1(C c) {
        System.out.println("I am in m1-C");
    }
}

public class OverLoadingTest {
    public static void main(String[] args) {
        OverLoadingScenarios obj = new OverLoadingScenarios();
        A a = new A();
        obj.m1(a);
        B b = new B();
        obj.m1(b);
        C c = new C();
        obj.m1(c);
        B bc = new C();
        obj.m1(bc);
        A ab = new B();
        obj.m1(ab);
    }
}
```

* 3.Mashq. Overriding Consolega nima chiqadi

```java
public class A {
    protected void m1() {
        System.out.println("m1-A");
    }
}

public class B extends A {
    public final void m1() {
        System.out.println("m1-B");
    }

    public static void main(String[] args) {
        B b = new B();
        b.m1();
        A a = new B();
        a.m1();
    }
}
```

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
class SuperClass{
   final void myMethod(){
      System.out.println("method of SuperClass");
   }
}
class SubClass extends SuperClass{
   void myMethod(){
      System.out.println("Overrides SuperClass");
   }
}
class GFG{
   public static void main(String[] args) {
      SubClass obj=new SubClass();
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

* Dog class yarating nameini saqlovchi field bilam, va unda 2 ta object yaratib uni Objects classing equals methodi orqali tenglikka tekshiring
* Cat classni yarating UUID saqlovchi id,name fieldlari bilan, buni ham equals methodi orqali tekshiring
* Undan oldin hamma objectni  requireNonNull method orqali tekshiring
* Va har bir field,method,class va package ga documentation yozing va JavaDocni generate qiling
</details>

