import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year


        Stream<Employee> stream = staff.stream();
        //stream.filter(employee -> (employee.getWorkStart().getYear() + 1900) == year).max(Comparator.comparing(Employee::getSalary))
          //      .ifPresent(System.out::println);
        //staff.stream().max(Comparator.comparing(Employee::getSalary))
        //        .ifPresent(System.out::println);

        Employee result = stream.filter(employee -> (employee.getWorkStart().getYear() + 1900) == year).max(Comparator.comparing(Employee::getSalary)).orElse(null);

        return result;
    }
}