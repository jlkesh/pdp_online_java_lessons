<details>
<summary>Lesson 1</summary>

1. O'zinggizni gmailingiz orqali email jo'nating.
2. mailtrap dan account ochib, ushbu ochgan accountingiz bilan email jo'nating
3. Jo'natadigan emailingiz html email bo'lib emailingizda image/vedio/audio va attachmentlar ham bo'lsin

</details>

<details>
<summary>Lesson 2</summary>

1. **runnable jar** yarating.

</details>


<details>
<summary>Lesson 3</summary>

1. Base64 dan Foydlangan Xolatda Tanasida audio, image va video bo'lgan email jo'nating

_HTML kodlar_

```html

<audio controls="controls" autoplay="autoplay">
    <source src="data:audio/wav;base64, AAAABMYXZmNTguMTIuMTAw. . . "/>
</audio>
```

```html

<video width="320" height="240" controls>
    <source src="data:video/mp4;base64, AAAABMYXZmNTguMTIuMTAw. . ." type="video/mp4">
</video>
```

```html
<img src="data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAABkAAAAZCAYAAA. . .">
```

</details>


<details>
<summary>Lesson 7</summary>

1. **Seeder.jar** degan application yarating. ushbu dastur orqali siz json, sql, va csv fayllar ko'rinishida ma'lumotlarni yaratib olishingiz mumkin bo'lsin. [bu yerda dasturingiz qandey ishlashi ko'rsatilgan](https://drive.google.com/file/d/1TLzS4FIyc5BuZHoTPKlWnjWgmYaQW2sS/view?usp=sharing)

</details>

<details>
<summary>Lesson 12</summary>

1. O'zingizni comparatoringizni yozing. HTML dagi **table** ko'rinishida bo'lsin ya'ni quyidagi ko'rinishda
```html
<table>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>gender</th>
        <th>age</th>
    </tr>


    <tr>
        <td>1</td>
        <td>Tarra Prohaska</td>
        <td>MALE</td>
        <td>16</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Allen Dicki</td>
        <td>FEMALE</td>
        <td>29</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Jack Davis DVM</td>
        <td>MALE</td>
        <td>17</td>
    </tr>
</table>
```
**va natijani xyz.html degan fayl ga qo'yib uni brauser da ochsangiz mana bunday ko'rinishda bo'ladi**

<html>
<head>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>gender</th>
        <th>age</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Tarra Prohaska</td>
        <td>MALE</td>
        <td>16</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Allen Dicki</td>
        <td>FEMALE</td>
        <td>29</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Jack Davis DVM</td>
        <td>MALE</td>
        <td>17</td>
    </tr>
</table>
</body>
</html>

</details>
