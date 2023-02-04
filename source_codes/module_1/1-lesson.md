````java
public class Main {
    public static void main(String[] args) {
        System.out.println("We do not use hello world :))");
    }
}
````

````java
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
````

```python
def hello():
    print("inside hello method")
    print(123/'hello world')

def run():
    print("run method called")
    hello()

run()
````

````java
public class App {

    public static void main(String[] args) {
        System.out.println("main method called");
        hello();
    }

    static void hello() {
        System.out.println("Inside hello method");
        System.out.println(123);
    }
}
````

````java
public class CLA {

    public static void main(String[] args) {

        System.out.println("Programming languages");

        for ( String lang : args ) {
            System.out.println(lang);
        }
    }
}
````