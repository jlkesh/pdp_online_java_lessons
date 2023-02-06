# Uchinchi Modul uchun mashqlar

<details>
<summary>Lesson 1</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* Name, owner, releaseDate fieldlaridan iborat ProgrammingLanguage classini yarating.
* null qiymatlar ham berib classdan object oling va ekranga chop eting
* Null qiymatini olish jarayonida yuzaga keladigan NullPointerExceptioni catching qiling (tuting)

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Qiyin</summary>

* int[]array=new int[10];
* 10 ta elemnti bor massiv yarating va qiymatlar bilan to'ldiring
* user 1 dan 10 gacha son kiritsin va kirilgan son boyicha massivdagi sonni ekranga chiqaring
* agar user kiritgan son 0 dan kichik yoki 10 dan katta bo'ladigan bo'lsa NoFoundNumberException exceptionini tashlang
* NoFoundNumberException exception classini o'zingiz yarating

</details>
</ul>
<ul>
<details>
<summary>3.Topshiriq - Juda Qiyin</summary>

* Qavat, Rangi, RoomCount va PersonName fieldlardan iborat Home classini yarating
* Class dan object olyapganda fieldlarning qiymati bo'lmasa har bir field uchun o'ziga xos exception oting
* qavat 0 dak kichik bo'lsa -> QavatCantBeLessThanZeroException
* rangi null yoki "" bo'sh bo'ladigan bo'lsa -> RangCantBeBlankException
* roomCount 10 dan kichik bo'lsa -> RoomCountCantBeLessThanTenException
* PersonName null yoki "" bo'sh bo'lsa -> PersonNameCantBeBlankException

</details>
</ul>
</details>
<details>
<summary>Lesson 2</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* Genericdan foydalanib method yozing. Methodga faqat Comparable interfacedan
  voris olgan class kirib kelsin. Method int turini qaytarsin va 2 ta generic tuiridagi
  qiymatlar kirib kelsin. Method ichida 2 la elementni compareTo() methodi orqali solishtirib qiymat qaytaring

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Qiyin</summary>

* Animal, Cat, Dog, Horse, Sheep classlarini yarating
* Hamma hayvonlar Animal classidan extend olsin
* Genericdan foydalanib AnimalHouse classini yarating,
* Ichida Generic fieldi va generic setter,getter methodlari bo'lsin
* AnimalHouse classiga faqat Animaldan extend olgan classlar kirib kelsin

</details>
</ul>
<ul>
<details>
<summary>3.Topshiriq - Juda Qiyin</summary>

* Genericdan foydalanib ArrayListni sodda versiyasini yozing
* Unda add(element),remove(index),get(index),size(),clear(),isEmpty() methodlari bo'lsin
* Va yaratilgan sodda ArrayList ni hamma methodlarini ishlatib qiymatlarini ekranga chop eting

</details>
</ul>
</details>
<details>
<summary>Lesson 3</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* sonlarni saqlovchi uzunligi 30 bo'lgan list yarating. va 100 gacha bo'lgan random sonlar
  bilan to'ldiring. Indexdan foydalangan holda listni qiymatlarini chizing
  Listning sizegacha bo'lgan random son orqali osha indexdagi elementni olib tashlansin
  va qayta chizing elementlarni

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Qiyin</summary>

* Ismlar listini yarating 20 tacha ismlar qoshing dublikat ismlarni ham bo'lsin.
* dublikat ismlarni listdan o'chirib tashlang
* Itirator method orqali list elementlarini ekranga chiqaring

</details>
</ul>
<ul>
<details>
<summary>3.Topshiriq - Juda Qiyin</summary>

* Book classini yarating uni ichida book larni saqlovchi list1 va list2 listlarini yarating
  list1 ni 10 book objectni bilan toldiring. list2 ni esa random son orqali list1dan tanlab olingan
  5 ta element ni bering.
* Ikkala listni ham ekranga chizing
* list1 dan list2 da bor elementlarni ochirib tashlang
* Qaytadan 2la listni ham qayta ekranga chiqaring

</details>
</ul>

</details>
<details>
<summary>Lesson 4</summary>

<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* Ikkita LinkedList dan foydalanib list yarting. Birinchi listga 10 tacha,
  ikkinchisiga 5 tacha ism bilan to'diring.
* birinchi listdagi elementlarni ikkinchi listga qoshing 15 ta element bo'ladi jami.
* Ikkinchi listning firinchisiga va oxirgisiga o'z ismingizni qo'shing
* Iterator orqali elementlarni chop eting

</details>
</ul>

* 3 - darsdagi ArrayList bilan qilingan tasklarni LinkedList bilan qiling

</details>
<details>
<summary>Lesson 5</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* a dan z gacha bo'lgan harflarni saqlovchi set yarating
  forEach orqali ekranga chop eting

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Oson</summary>

* 1 dan 10 gacha sonlarni TreeSetga saqlang va ekranga chiqaring

</details>
</ul>
<ul>
<details>
<summary>3.Topshiriq - Juda Qiyin</summary>

* Name, Phone fieldlaridan iborat User classini yarating.
  Comparator orqali name ba phone boyicha sortlagan holda TreeSetda saqlang
* Set elementlarini ekranga chizing

</details>
</ul>

</details>
<details>
<summary>Lesson 6</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* 10 ta natural sondan iborat queue yarating
* elementlarni ekranga chop eting
* birinchi sonni ochirib oxirga 100 snoni qoshing
* elementlarni ekranga chop eting

</details>
</ul>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* Name,Phone fieldlaridan iborat User larni saqlovchi PriorityQueue yaraqting
* elementlarini ekranga chiqaring
* peek() methodingi natijaini
* poll() methodini natijasini chiqaring
* elementlarini ekranga chiqaring

</details>
</ul>
</details>
<details>
<summary>Lesson 7</summary>
<ul>
<details>
<summary>1.Topshiriq - Qiyin</summary>

* Name, color, model fiieldlardan iborat Car clasini yarating
* Car classini va price ni saqlovchi map yarating
* map elementlari ekranga chizilsin
* berilgan price chegari bo'yicha yani berilgan pricedan kichik bo'lgan mashinalar malumotlari price bilan ekranga
  chiqaradigan method ham yozing

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Juda Qiyin</summary>

* Uy raqamini va shu uyda yashaydigan Userlar listini saqlovchi map yarating
* User classi name, phone, Role Enum fieldlaridan iborat
* Role Enum classi -> GRANDPA, GRANDMA, FATHER, MOTHER ,CHILD qiymatlardan iborat
* Mapni elementlarini "uy raqami va u uyda yashovchi odamlar" ko'rinishida ekranga chiqaring

</details>
</ul>
<ul>
<details>
<summary>3.Topshiriq - Juda Qiyin</summary>

* Lug'at yaratish
* Uzbekcha so'z va uning bir nechta englishcha tarjimalarini saqlaydigan list dan map yarating
* Uzbekcha so'z -> uning tarjimalari ko'rinishida elementlarni ekranga chizing
* Consoldan uzbekcha so'z kiritilgandan map dan o'shani topib tarjimalarini yozadigan yoki
  englishcha so'z kiritilganda uzbekcha tarjimasini ekranga chiqaradigan method yozing.

</details>
</ul>
</details>
<details>
<summary>Lesson 8</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* Name, color, model fiieldlardan iborat Car clasini yarating
* Car dan iborat list ham yarating
* Iterator orqali ekranga chizing
* ListIterator orqali ekranga chizing

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Qiyin</summary>

* User classi name, phone, Role Enum fieldlaridan iborat
* Role Enum classi -> FATHER, MOTHER ,CHILD qiymatlardan iborat
* 2 ta list yarating shallowCopies and deepCopies degan
* shallowCopies ni user clasining shallow copy lari bilan to'ldiring
* deepCopies ni user clasining deep copy lari bilan to'ldiring
* ListIterator dan foydanalib 2 tomonlama aylanib elementlarni ekranga chizing

</details>
</ul>
<ul>
<details>
<summary>3.Topshiriq - Juda Qiyin</summary>

* Lug'at yaratish
* Uzbekcha so'z va uning bir nechta englishcha tarjimalarini saqlaydigan list dan map yarating
* Uzbekcha so'z -> uning tarjimalari ko'rinishida elementlarni ekranga chizing
* Consoldan uzbekcha so'z kiritilgandan map dan o'shani topib tarjimalarini yozadigan yoki
  englishcha so'z kiritilganda uzbekcha tarjimasini ekranga chiqaradigan method yozing.

</details>
</ul>
</details>
<details>
<summary>Lesson 9</summary>
<ul>
<details>
<summary>1.Topshiriq - Oson</summary>

* Ismlardan iborat uzunligi yigirma bo'lgan massiv yarating
* Uni Collection listiga o'giring va shuffle qiling
* listni soritng qilib optionalga orab bervoring
* optional bo'sh bo'lmasa optionaldan listni olib list elementlarini chop eting

</details>
</ul>
<ul>
<details>
<summary>2.Topshiriq - Qiyin</summary>

* SOLID ning har bir prinsibiga to'gri keladigan struktura misol sifatida yozing

</details>
</ul>
</details>
<details>
<summary>Lesson 10</summary>


</details>
