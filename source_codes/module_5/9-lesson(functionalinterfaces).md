# Lesson Source Code (Functional Interfaces)
````java
class PredicateTest {
    public static void main(String[] args) {
        int[] array = {5, 4, 8, -3, -4, 10};
        Predicate<Integer> odd = (number) -> number % 2 != 0;
        System.out.println(filter(array, odd));

        Predicate<Integer> even = (number) -> number % 2 == 0;
        System.out.println(filter(array, even));

        Predicate<Integer> negative = (number) -> number < 0;
        System.out.println(filter(array, negative));

        Predicate<Integer> negativeAndEven = negative.and(even);
        System.out.println(filter(array, negativeAndEven));

        Predicate<Integer> negativeOrOdd = negative.or(odd);
        System.out.println(filter(array, negativeOrOdd));
    }

    public static List<Integer> filter(int[] array, Predicate<Integer> predicate) {
        List<Integer> numbers = new ArrayList<>();
        for ( int i : array ) {
            if ( predicate.test(i) )
                numbers.add(i);
        }
        return numbers;
    }
}

class ConsumerTest {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );

        Consumer<Employee> printOnConsole = ( System.out :: println );
        Consumer<Employee> storeInDB = ( e -> System.out.println(e.toString() + " saving database") );
        Consumer<Employee> priConsumerThenStoreInDB = printOnConsole.andThen(storeInDB);
        forEach(empList, priConsumerThenStoreInDB);
    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        int nullCount = 0;
        for ( T t : list ) {
            if ( t != null ) {
                consumer.accept(t);
            } else {
                nullCount++;
            }
        }
        System.out.printf("%d null entries count  in the list.\n", nullCount);
    }
}

class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> charsCount = String :: length;
        Integer helloPdp = charsCount.apply("Hello PDP");
        System.out.println(helloPdp);
    }
}

class SupplierTest {
    public static void main(String[] args) {
        Supplier<Throwable> supplier = () -> new RuntimeException("Exception occur");
    }
}


class PrimitiveFunctionalInterface {

    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1, 1000000).toArray();
        BinaryOperator<Integer> f1 =  Integer :: sum ;
        IntBinaryOperator f2 = Integer :: sum;
        RunningTime.calculate(v -> reduceWrapper(arr, f1));
        RunningTime.calculate(v -> reducePrimitive(arr, f2));
    }

    static int reduceWrapper(int[] arr, BinaryOperator<Integer> operator) {
        int result = arr[0];
        for ( int i = 1; i < arr.length; i++ ) {
            result = operator.apply(result, arr[i]);  // Boxing and Unboxing here
        }
        return result;
    }

    static int reducePrimitive(int[] arr, IntBinaryOperator operator) {
        int result = arr[0];
        for ( int i = 1; i < arr.length; i++ ) {
            result = operator.applyAsInt(result, arr[i]);
        }
        return result;
    }
}

class RunningTime {
    public static void calculate(Consumer<Void> consumer) {
        long begin = System.currentTimeMillis();
        consumer.accept(null);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
````

# Method reference
````java
public class MethodReferenceExample {
    public static void main(String[] args) {
       /* List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for ( int i = 0; i < 10; i++ ) {
            numbers.add(random.nextInt(3, 200));
        }
        System.out.println(numbers);
        Consumer<List<Integer>> sortList = Collections :: sort; // static method ref
        sortList.accept(numbers);
        System.out.println(numbers);
        MethodReferenceExample o = new MethodReferenceExample();
        Function<String, Integer> nn = o :: toInteger;
        System.out.println(nn.apply("12"));
        Function<String, Integer> mm = String :: length;
        System.out.println(mm.apply("123"));*/
        Function<UserRegisterDTO, User> toUserMapper = User :: new;

        UserRegisterDTO userRegisterDTO = new UserRegisterDTO("john", "123");
        User user = toUserMapper.apply(userRegisterDTO);
        System.out.println(user);
    }

    public int toInteger(String s) {
        return Integer.parseInt(s) * 2;
    }
}
````

````java
@Data
public class User {
    private String username;
    private String password;
    private String role;
    private LocalDateTime createdAt;
    public User(UserRegisterDTO dto) {
        this.setUsername(dto.getUsername());
        this.setPassword(dto.getPassword());
        this.setRole("USER");
        this.setCreatedAt(LocalDateTime.now());
    }
}
````
````java
@Data
public class UserRegisterDTO {
    private final String username;
    private final String password;
}
````

----
# Extra code samples
### Predicate


````java
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> evenNums = ( num -> num % 2 == 0 );
        Predicate<Integer> oddNums = ( num -> num % 2 != 0 );
        Predicate<Integer> positiveNums = ( num -> num > 0 );
        int[] array = {5, 4, 8, -3, -4, 10};
        System.out.println(filter(array, evenNums));
        System.out.println(filter(array, oddNums));
        System.out.println(filter(array, positiveNums));
    }

    public static List<Integer> filter(int[] array, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for ( int t : array ) {
            if ( predicate.test(t) )
                result.add(t);
        }
        return result;
    }
}
````

### Consumer

````java
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Employee> printOnConsole = ( e -> System.out.print(e) );
        Consumer<Employee> storeInDB = ( e -> DaoUtil.save(e) );

        forEach(empList, printOnConsole);
        forEach(empList, storeInDB);
        forEach(empList, printOnConsole.andThen(storeInDB));
    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        int nullCount = 0;
        for ( T t : list ) {
            if ( t != null ) {
                consumer.accept(t);
            } else {
                nullCount++;
            }
        }
        System.out.printf("%d null entries count  in the list.\n", nullCount);
    }
}
````

### Function

````java
public class FunctionTest {

    public static void main(String[] args) {
        Function<Employee, String> empPrimaryId = ( emp -> emp.getEmployeeId() );
        Function<Department, String> deptPrimaryId = ( dept -> dept.getLocation() + dept.getName() );

        toMap(employeeList, empPrimaryId);
        toMap(deptList, deptPrimaryId);
    }

    static <T, K> Map<K, T> toMap(List<T> list, Function<T, K> keyMapper) {
        Map<K, T> map = new HashMap<>();
        for ( T t : list ) {
            map.put(keyMapper.apply(t), t);
        }
        return map;
    }
}
````

### Supplier

````java
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Long> randomId = () -> new Random().nextLong();
        Supplier<UUID> uuid = () -> UUID.randomUUID();

        Trade trade = new Trade();
        populate(trade, randomId);
        populate(trade, uuid);
    }

    static <R> void populate(Trade t, Supplier<R> supplier) {
        t.tradeDate = new Date();
        t.tradeId = (String) supplier.get();
        t.location = "XYZ Hub";
    }

    static class Trade {
        String tradeId;
        Date tradeDate;
        String location;
    }
}
````

### Primitive FunctionalInterface

````java
public class PrimitiveFunctionalInterface {

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 500000).toArray();
        BinaryOperator<Integer> f1 = Integer :: sum;
        IntBinaryOperator f2 = Integer :: sum;
        RunningTime.calculate(v -> reduceWrapper(arr, f1));
        RunningTime.calculate(v -> reducePrimitive(arr, f2));
    }

    static int reduceWrapper(int[] arr, BinaryOperator<Integer> operator) {
        int result = arr[0];
        for ( int i = 1; i < arr.length; i++ ) {
            result = operator.apply(result, arr[i]);  // Boxing and Unboxing here
        }
        return result;
    }

    static int reducePrimitive(int[] arr, IntBinaryOperator operator) {
        int result = arr[0];
        for ( int i = 1; i < arr.length; i++ ) {
            result = operator.applyAsInt(result, arr[i]);
        }
        return result;
    }
}

````

````java
public class RunningTime {
    public static void calculate(Consumer<Void> consumer) {
        long begin = System.currentTimeMillis();
        consumer.accept(null);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}

````