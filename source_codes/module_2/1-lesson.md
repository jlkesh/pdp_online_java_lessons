````java
/**
 * @author Elmurodov Javohir
 * @time 11/1/2022 8:58 AM
 * @project lesson_1_2
 */
public class Book {

    public String title; // field
    public int pageCount; // field

    public void displayBook() {
        System.out.printf("Book name : %s%nBook Page Count : %d", title, pageCount);
    }

}
````


````java
/**
 * @author Elmurodov Javohir
 * @time 11/1/2022 8:57 AM
 * @project lesson_1_2
 */
public class PlayWithClassesAndObjects {

    public static void main(String[] args) {
        int x;
        Book book1 = new Book();
        /*book1.title = "Spring in Action 6th edition";
        book1.pageCount = 670;*/
        book1.displayBook();
    }
}
````


````java
/**
 * @author Elmurodov Javohir
 * @time 11/1/2022 9:19 AM
 * @project lesson_1_3
 */
public class Book {
    public int id;
    public String title;
    public int pageCount;


    // no args constructor
    public Book() {

    }

    // Parametrized constructor
    public Book(String title, int pageCount) {
        System.out.println("2 argument constructor");
        this.title = title;
        this.pageCount = pageCount;
    }

    public Book(int id, String title, int pageCount) {
        // this(title, pageCount);
        this.id = id;
        this.title = title;
        this.pageCount = pageCount;
        System.out.println("3 argument constructor");
    }

    // copy constructor
    public Book(Book book) {
        this.title = "new -> " + book.title;
        this.pageCount = 1000 + book.pageCount;
    }


    public void displayBook() {
        System.out.printf("Book name : %s%nBook Page Count : %d%n", title, pageCount);
    }
}
````


````java
/**
 * @author Elmurodov Javohir
 * @time 11/1/2022 9:19 AM
 * @project lesson_1_3
 */
public class Constructors {
    public static void main(String[] args) {
        // Book book = new Book("Spring in action", 670);
        // Book book2 = new Book(book);
        Book book3 = new Book(1, "Concurrency in Practise", 1000);
        book3.displayBook();
        //book.displayBook();
        //book2.displayBook();
    }
}
````