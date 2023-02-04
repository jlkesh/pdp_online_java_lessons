

````java
public class App {
    public static void main(String[] args) {
        // System.out.println("Hello PDP");
        Book book = new Book("Spring in action", 670);
        // book.title = "Spring in action";// error
        // accessor, mutators
        System.out.println(book.getTitle());
        // book.title = "Concurrency in Practise"; // error
        book.setTitle("Concurrency in Practise");
        System.out.println(book.getTitle());
        // accessor -> getter
        // mutators -> setter
    }
}
````

````java
public class Book {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    /*
     * public String titleAccessor(){
     * return this.title;
     * }
     *
     * public void titleMutator(String newTitle){
     * this.title = newTitle;
     * }
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
````

````java
public class Student {

    private String fullname;
    private String studentId;

    public Student(String fullname, String studentId) {
        this.fullname = fullname;
        this.studentId = studentId;
    }

    public String getFullname() {
        return fullname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
````

````java
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Akbarov Akbar", "123");
    }
}
````


````java
public class Main {
    public static void main(String[] args) {
        // java.util.Date date = new java.util.Date(); // fully qualified name
        // java.sql.Date sqlDate = new java.sql.Date(0, 0, 0) ;
        Date date = new Date();
        System.out.println(date);
        System.out.println(sqrt(16));
        System.out.println(pow(12, 2));
        System.out.println(PI);
    }
}
````