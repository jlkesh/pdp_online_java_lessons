# Behaviour Parametrization


````java

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );

        List<Employee> uzbEmployees = getEmployeesBy(empList, new EmployeeFilterByCountry("UZB"));
        List<Employee> usEmployees = getEmployeesBy(empList, new EmployeeFilterByCountry("US"));
        List<Employee> employeesWhoseAgeGreaterThan25 = getEmployeesBy(empList, new EmployeeFilterByAge(24));
        List<Employee> employeesByPosition = getEmployeesBy(empList, new EmployeeFilterByPosition("MANAGER"));
        System.out.println(uzbEmployees);
        System.out.println(usEmployees);
        System.out.println(employeesWhoseAgeGreaterThan25);
        System.out.println(employeesByPosition);
    }

    private static List<Employee> getEmployeesBy(List<Employee> empList, Filter filter) {
        List<Employee> employees = new ArrayList<>();
        for ( Employee employee : empList ) {
            if ( filter.test(employee) ) {
                employees.add(employee);
            }
        }
        return employees;
    }

}

interface Filter {
    boolean test(Employee employee);
}

class EmployeeFilterByCountry implements Filter {
    private final String country;

    EmployeeFilterByCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getCountry().equals(country);
    }
}

class EmployeeFilterByAge implements Filter {
    private final int age;

    EmployeeFilterByAge(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > age;
    }
}


class EmployeeFilterByPosition implements Filter {
    private final String position;

    EmployeeFilterByPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getPosition().equals(position);
    }
}

@Data
@AllArgsConstructor
class Employee {
    private String name;
    private String country;
    private String position;
    private int age;
}
````

# Lambda Expressions

````java

public class Main {

    /*private Function<Integer, String> func = (i) -> "HELLO";
    private static int a = 123;*/

    public static void main(String[] args) throws Exception {
        //introductionToLambdas();
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );

        Filter uzFilter = employee -> employee.getCountry().equals("UZB");
        Filter usFilter = employee -> employee.getCountry().equals("US");

        List<Employee> uzb = getEmployeesBy(empList, uzFilter);
        List<Employee> us = getEmployeesBy(empList, usFilter);

        List<Employee> manager = getEmployeesBy(empList, employee -> employee.getPosition().equals("MANAGER"));
        List<Employee> under29 = getEmployeesBy(empList, employee -> employee.getAge() < 29);

        System.out.println(uzb);
        System.out.println(us);
        System.out.println(manager);
        System.out.println(under29);
    }

    private static List<Employee> getEmployeesBy(List<Employee> empList, Filter filter) {
        List<Employee> employees = new ArrayList<>();
        for ( Employee employee : empList ) {
            if ( filter.test(employee) ) {
                employees.add(employee);
            }
        }
        return employees;
    }

    private static void introductionToLambdas() {
        Callable<Integer> callable = () -> "Hello PDP!".length();
        int b = 12;
        Runnable runnable = () -> {
            int a = 90;
            System.out.println(a);
            System.out.println(b);
        };
        runnable.run();
        // b = 90;
    }
}
````

````java
@FunctionalInterface
public interface Filter {
    boolean test(Employee employee);
}
````


````java
@FunctionalInterface
public interface EmployeePredicate {
    boolean testA(Object o);
}

````


````java
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private String country;
    private String position;
    private int age;
}
````

