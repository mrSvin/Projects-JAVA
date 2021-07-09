import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Company implements Comparator<Employee> {

    List<Employee> employees = new ArrayList<>();

    private int income = 100_000_000;


    public void hire(Employee employee) {
        employees.add(employee);
    }


    public void hireAll(List<Employee> employees) {
        for (Employee e : employees) {
            hire(e);
        }

    }

    public void fire(Employee employee) {
        employees.remove(employee);

    }

    public List<Employee> getLowestSalaryStaff(int count) {

        employees.sort(this);

        return employees.subList(0, count);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(this);
        Collections.reverse(employees);
        return employees.subList(0, count);
    }

    public int getIncome() {
        return income;
    }


    @Override
    public int compare(Employee o1, Employee o2) {
        return 0;
    }
}
