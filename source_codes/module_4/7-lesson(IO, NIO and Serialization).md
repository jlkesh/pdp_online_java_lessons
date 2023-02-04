# IO Classes

````java
package uz.pdp.javaio;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("io", "readme3.txt");
        System.out.println(file.delete());
        /*System.out.println(file.canExecute());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        if ( !file.exists() ) {
            file.createNewFile();
            System.out.println("new file created");
        }*/
        // System.out.println(file.getAbsolutePath());
        // System.out.println(file.getParent());
        File file2 = new File("io", "childpack1/childpack2/childpack3");
        System.out.println(file2.mkdirs());


    }
}
````


````java
package uz.pdp.javaio;

import java.io.*;

public class FileInputOutputStreamExample {
    public static void main(String[] args) {
        //inputstream();
        try ( InputStream is = new FileInputStream("io/readme.txt");
              OutputStream os = new FileOutputStream("io/readme2.txt")) {
            is.transferTo(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputstream() {
        try ( InputStream is = new FileInputStream("io/readme.txt") ) {
            byte[] bytes = is.readAllBytes();
            String data = new String(bytes);
            System.out.println("data = " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````


````java
package uz.pdp.javaio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderFileWriteExample {
    public static void main(String[] args) {
        // reader();
        File file = new File("io/readme.txt");
        try ( FileWriter fileWriter = new FileWriter(file, true) ) {
            fileWriter.write("Elmurodov Javohir\n");
            fileWriter.write("PDP academy\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reader() {
        File file = new File("io/readme.txt");
        try ( FileReader fileReader = new FileReader(file) ) {

            StringBuilder a = new StringBuilder();
            int i;
            while ( ( i = fileReader.read() ) != -1 ) {
                a.append((char) i);
            }
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````


````java
package uz.pdp.javaio;

import java.io.*;

public class DataInputOutputStreamExample {
    public static void main(String[] args) {
        // output();
        input();
    }

    private static void input() {
        try ( FileInputStream is = new FileInputStream("io/dataoutputstream.txt");
              DataInputStream dataInputStream = new DataInputStream(is) ) {
            double readDouble = dataInputStream.readDouble();
            System.out.println("readDouble = " + readDouble);
            long readLong = dataInputStream.readLong();
            System.out.println("readLong = " + readLong);
            int readInt = dataInputStream.readInt();
            System.out.println("readInt = " + readInt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void output() {
        try ( FileOutputStream fileOutputStream = new FileOutputStream("io/dataoutputstream.txt");
              DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream) ) {
            dataOutputStream.writeDouble(12D);
            dataOutputStream.writeLong(10000002L);
            dataOutputStream.writeInt(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````



````java
package uz.pdp.javaio;

import java.io.*;
import java.util.Date;
import java.util.List;

public class BufferedReaderBufferedWriterExample {
    public static void main(String[] args) {
        File file = new File("io/readme.txt");
        // reader(file);
        try ( FileWriter fileWriter = new FileWriter(file, true);
              BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) ) {
            bufferedWriter.append("Hello Guys\n");
            bufferedWriter.append(( "It's Time : " + new Date() + "\n" ));
        } catch (IOException e) {
        }
    }

    private static void reader(File file) {
        try ( FileReader fileReader = new FileReader(file);
              BufferedReader bufferedReader = new BufferedReader(fileReader) ) {
            while ( bufferedReader.ready() ) {
                String readLine = bufferedReader.readLine();
                System.out.println(readLine);
            }

            /*List<String> strings = bufferedReader.lines().toList();
            for ( int i = 0; i < strings.size(); i++ ) {
                System.out.printf("line number '%d' - %s %n", i + 1, strings.get(i));
            }*/
        } catch (IOException e) {
        }
    }
}
````
# New IO Classes

````java
package uz.pdp.javanio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        // Path path = Paths.get("/home");
        Path path = Path.of("nio", "readme.txt");
        System.out.println(path.isAbsolute());
        // path = path.resolve("testfolder");
        System.out.println(path);
        path = path.normalize().toAbsolutePath();
        System.out.println(path);
        System.out.println(path.getFileName());
        Path parentPath = path.getParent();
        System.out.println(parentPath);
        Path parentPathParent = parentPath.getParent();
        System.out.println(parentPathParent);
        System.out.println(parentPathParent.getParent());
        System.out.println(parentPathParent.getParent().getParent());
        System.out.println(parentPathParent.getParent().getParent().getParent());
        System.out.println(path.getRoot());
    }
}
````


````java
package uz.pdp.javanio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("io/readme.txt");
        /*String readString = Files.readString(path);
        System.out.println(readString);*/
        /*List<String> readAllLines = Files.readAllLines(path);
        readAllLines.forEach(System.out :: println);*/
        /*Path path1 = Path.of("nio", "readme.txt");
        // Files.writeString(path1, "Hello World " + new Date() + "\n", StandardOpenOption.APPEND);
        if ( !Files.exists(Path.of("nio", "readme2.txt")) ) {
            Files.createFile(Path.of("nio", "readme2.txt"));
        }

        Path dirs = Path.of("nio", "f1", "f2", "f3");
        if ( !Files.exists(dirs) ) {
            Files.createDirectories(dirs);
        }
        Path file = dirs.resolve("readme3.txt");
        Files.createFile(file);*/
        Path source = Path.of("io/readme2.txt");
        Path target = Path.of("nio/f1/f2/f3/copy.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        // Files.createTempFile(Path.of("")) linux -> /tmp, windows-> users/username/AppData
        // Files.createTempDirectory()
        Path walkPath = Path.of("/home/jlkesh/IdeaProjects/pdp/online_lessons/module4");
        for ( Path w : Files.walk(walkPath).toList() ) {
            //if ( Files.isRegularFile(w) ) {
            System.out.println(w);
            //}
        }
    }
}
````

# Serialization
````java
package uz.pdp.serializationanddesirialization;

import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {
    private String fullName;
    private String age;
    private transient String phoneNumber;

    public Employee(String fullName, String age, String phoneNumber) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
````

````java
package uz.pdp.serializationanddesirialization;

import java.io.*;

public class Employee2 implements Externalizable {
    private String fullName;
    private String age;
    private String phoneNumber;

    public Employee2(){}
    public Employee2(String fullName, String age, String phoneNumber) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.fullName.substring(0, 5));
        out.writeObject(this.phoneNumber.substring(5));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.fullName = (String) in.readObject();
        this.phoneNumber = (String) in.readObject();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
````


````java
package uz.pdp.serializationanddesirialization;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        try {
            Employee employee = new Employee("Elmurodov Javohir", "28", "+998900712021");
            File file = new File("serdeser/file.txt");
            FileInputStream out = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(out);
            Employee o = (Employee) objectInputStream.readObject();
            System.out.println(employee);
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        try {
            Employee employee = new Employee("Elmurodov Javohir", "28", "+998900712021");
            File file = new File("serdeser/file.txt");
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````

````java
package uz.pdp.serializationanddesirialization;

import java.io.*;

public class SerializationExample2 {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        try {
            File file = new File("serdeser/file.txt");
            FileInputStream out = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(out);
            Employee2 o = (Employee2) objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        try {
            Employee2 employee = new Employee2("Elmurodov Javohir", "28", "+998900712021");
            File file = new File("serdeser/file.txt");
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````


````java
package uz.pdp.serializationanddesirialization;

import java.io.Serializable;

public class Singleton implements Serializable {
    private volatile static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if ( singleton == null ) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(System.identityHashCode(singleton1));
        System.out.println(System.identityHashCode(singleton2));
    }

    public Object readResolve() {
        return singleton;
    }
}
````


````java
package uz.pdp.serializationanddesirialization;

import java.io.*;

public class SingletonBreakerExample {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        try {
            File file = new File("serdeser/file.txt");
            FileInputStream out = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(out);
            Singleton singleton = (Singleton) objectInputStream.readObject();
            System.out.println(System.identityHashCode(singleton));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        try {
            Singleton singleton = Singleton.getSingleton();
            System.out.println(System.identityHashCode(singleton));
            File file = new File("serdeser/file.txt");
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(singleton);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````
