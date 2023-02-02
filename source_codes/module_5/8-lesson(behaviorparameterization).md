
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

````java
public interface EmployeePredicate {
    boolean test(Employee e);
}
````
````java
@RequiredArgsConstructor
class EmployeeFilterByAgeGreaterThan implements EmployeePredicate {
    private final int age;
    @Override
    public boolean test(Employee e) {
        return e.getAge() >= age;
    }
}
````
````java
@RequiredArgsConstructor
class EmployeeFilterByCountry implements EmployeePredicate {
    private final String country;
    @Override
    public boolean test(Employee e) {
        return e.getCountry().equalsIgnoreCase(country);
    }
}
````

````java
public class BehaviorParametrization {
    public static void main(String[] args) throws Exception {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );

        System.out.println(getUZBEmp(empList));
        System.out.println(getEmpByCountry(empList, "GER"));
        System.out.println(getEmpByCountry(empList, "US"));
        System.out.println(getEmpByCountry(empList, "UZB"));

        System.out.println(getEmp(empList, new EmployeeFilterByCountry("US")));
        System.out.println(getEmp(empList, new EmployeeFilterByAgeGreaterThan(26)));
    }

    private static List<Employee> getUZBEmp(List<Employee> empList) {
        List<Employee> result = new ArrayList<>();
        for ( Employee emp : empList ) {
            if ( emp.getCountry().equals("UZB") ) {
                result.add(emp);
            }
        }
        return result;
    }

    private static List<Employee> getEmpByCountry(List<Employee> empList, String country) {
        List<Employee> result = new ArrayList<>();
        for ( Employee emp : empList ) {
            if ( emp.getCountry().equals(country) ) {
                result.add(emp);
            }
        }
        return result;
    }


    private static List<Employee> getEmp(List<Employee> empList, EmployeePredicate predicate) {
        List<Employee> result = new ArrayList<>();
        for ( Employee emp : empList ) {
            if ( predicate.test(emp) ) {
                result.add(emp);
            }
        }
        return result;
    }
}
````

````java
public class LambdaExample{
    public static void main(String[] args) {
        // ..........................
        System.out.println(getEmp(empList, (e) -> e.getPosition().equalsIgnoreCase("manager")));
        // ..........................
    }
}
````
