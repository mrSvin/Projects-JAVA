import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static Company company = new Company();

    public static void main(String[] args) {

        company = new Company();
        company.hire("Топ1", "topManagers");
        company.hire("Топ2", "topManagers");
        company.hire("Топ3", "topManagers");

        company.hire("Упр1", "managers");
        company.hire("Упр2", "managers");
        company.hire("Упр3", "managers");

        company.hire("Оп1", "operators");
        company.hire("Оп2", "operators");
        company.hire("Оп3", "operators");

        ArrayList<String> personsTop=new ArrayList<>();
        for (int i=4; i<11; i++) {
            personsTop.add("Топ"+i);
        }
        company.hireAll(personsTop, "topManagers");

        ArrayList<String> personsManager=new ArrayList<>();
        for (int i=4; i<81; i++) {
            personsManager.add("Упр"+i);
        }
        company.hireAll(personsManager, "managers");

        ArrayList<String> personsOperators=new ArrayList<>();
        for (int i=4; i<181; i++) {
            personsOperators.add("Оп"+i);
        }
        company.hireAll(personsOperators, "operators");

    }
}
