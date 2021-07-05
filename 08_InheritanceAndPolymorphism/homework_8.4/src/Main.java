import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Company company = new Company();
//        TopManager topManager = new TopManager();
//        Operator operator = new Operator();
//        Manager manager = new Manager();
//        Employee topManagerEmp = new TopManager();
//        Employee operatorEmp = new Operator();
//        Employee managerEmp = new Manager();


        company.hire("Топ1", "topManagers");
        company.hire("Топ2", "topManagers");
        company.hire("Топ3", "topManagers");

        company.hire("Упр1", "managers");
        company.hire("Упр2", "managers");
        company.hire("Упр3", "managers");

        company.hire("Оп1", "operators");
        company.hire("Оп2", "operators");
        company.hire("Оп3", "operators");

        ArrayList<String> personsTop = new ArrayList<>();
        for (int i = 4; i < 11; i++) {
            personsTop.add("Топ" + i);
        }
        company.hireAll(personsTop, "topManagers");

        ArrayList<String> personsManager = new ArrayList<>();
        for (int i = 4; i < 81; i++) {
            personsManager.add("Упр" + i);
        }
        company.hireAll(personsManager, "managers");

        ArrayList<String> personsOperators = new ArrayList<>();
        for (int i = 4; i < 181; i++) {
            personsOperators.add("Оп" + i);
        }
        company.hireAll(personsOperators, "operators");

        //company.fire("Топ3", "topManagers");


        List<Integer> getLowestSalaryStaff = company.getLowestSalaryStaff(30);
        List<Integer> getTopSalaryStaff = company.getTopSalaryStaff(15);

        for (int i = 1; i < 6; i++) {
            company.fire("Топ" + i, "topManagers");
        }
        for (int i = 1; i < 41; i++) {
            company.fire("Упр" + i, "managers");
        }
        for (int i = 1; i < 91; i++) {
            company.fire("Оп" + i, "operators");
        }

        company.getLowestSalaryStaff(30);
        company.getTopSalaryStaff(15);


    }
}
