[Qo'shimcha Malumot uchun](https://www.oracle.com/technical-resources/articles/java/javareflection.html)

````java
public class MyClass {
    private final String message;

    /*  
    private MyClass() {
    }
    */

    public MyClass(String message) {
        this.message = message;
    }

    public void hi() {
        System.out.println("Hello PDP!");
        System.out.println(message);
    }

    private Date showMessage() {
        System.out.println(message);
        return new Date();
    }

    private int sum(int x, int y) {
        System.out.println("sum = " + ( x + y ));
        return x + y;
    }

    public String getMessage() {
        return message;
    }
}
````

````java
public class Main {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass("Hello This is reflection");
        // Class<MyClass> clazz = (Class<MyClass>) Class.forName("uz.pdp.reflections_api.MyClass");
        Class<? extends MyClass> clazz = myClass.getClass();
        /*Constructor<MyClass> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        MyClass myClass = constructor.newInstance("Hello from Reflections");
        myClass.hi();*/

        /*for ( Method declaredMethod : clazz.getDeclaredMethods() ) {
            System.out.println(declaredMethod.getName());
        }*/
        /*Method method = clazz.getDeclaredMethod("showMessage");
        method.setAccessible(true);
        Object o = method.invoke(myClass);
        System.out.println(o);*/
        /*Method method = clazz.getDeclaredMethod("sum", int.class, int.class);
        method.setAccessible(true);
        Object o = method.invoke(myClass, 23, 4);
        System.out.println(o);*/

        System.out.println(myClass.getMessage());
        Field field = clazz.getDeclaredField("message");
        field.setAccessible(true);
        field.set(myClass, "Volaaa. Bu Reflection bilan hamma narsa qilsa bolar ekan");
        System.out.println(myClass.getMessage());
    }
}
````