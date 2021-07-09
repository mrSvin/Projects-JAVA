import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Company company = new Company();

        List<Employee> workers = new ArrayList<>();


        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
            System.out.println("Устроился оператор " + (i + 1));
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Manager());
            System.out.println("Устроился менеджер " + (i + 1));
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager());
            System.out.println("Устроился Топ менеджер " + (i + 1));
        }
        company.hireAll(workers);


        List<Employee> getLowSalaryStaff = company.getLowestSalaryStaff(30);
        System.out.println("Самые низкие зарплаты по возрастанию:");
        for (Employee e : getLowSalaryStaff) {
            System.out.println(e.getMonthSolary());
        }
        List<Employee> getTopSalaryStaff = company.getTopSalaryStaff(15);
        System.out.println("Самые высокие зарплаты по убыванию:");
        for (Employee e : getTopSalaryStaff) {
            System.out.println(e.getMonthSolary());
        }

        //System.out.println(company.employees.size());
        System.out.println("Уволены 50% сотрудников");
        int sizeList = company.employees.size() / 2;
        for (int i = 0; i < sizeList; i++) {
            //company.fire(company.employees.get(i));
        }
        System.out.println(company.employees.size());

        System.out.println("Самые высокие зарплаты после увольнения по убыванию:");
        for (Employee e : company.getLowestSalaryStaff(15)) {
            System.out.println(e.getMonthSolary());
        }

        System.out.println("Самые низкие зарплаты после увольнения по возрастанию:");
        for (Employee e : company.getTopSalaryStaff(30)) {
            System.out.println(e.getMonthSolary());
        }


    }
}
