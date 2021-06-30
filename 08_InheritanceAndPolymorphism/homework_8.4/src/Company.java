import java.util.ArrayList;


public class Company {

    public static ArrayList<String> topManagers=new ArrayList<>();
    public ArrayList<String> managers=new ArrayList<>();
    public ArrayList<String> operators=new ArrayList<>();


    //выводим сотрудников с самыми высокими зарплатами
    public ArrayList<Employee> getTopSolaryStaff(int count) {
        return null;
    }

    //выводим сотрудников с самыми низкими зарплатами
    public ArrayList<Employee> getLowestSolaryStaff(int count) {
        return null;
    }

    public void hire(String name, String position) {
        if (position.equals("topManagers")) {
            topManagers.add(name);
            System.out.println(topManagers);
        }
        if (position.equals("managers")) {
            managers.add(name);
            System.out.println(managers);
        }
        if (position.equals("operators")) {
            operators.add(name);
            System.out.println(operators);
        }
    }


    public void hireAll(ArrayList<String> names, String position) {
        if (position.equals("topManagers")) {
            for (int i=0; i<names.size(); i++) {
                topManagers.add(names.get(i));
            }
            System.out.println(topManagers);
        }
        if (position.equals("managers")) {
            for (int i=0; i<names.size(); i++) {
                managers.add(names.get(i));
            }
            System.out.println(managers);
        }
        if (position.equals("operators")) {
            for (int i=0; i<names.size(); i++) {
                operators.add(names.get(i));
            }
            System.out.println(operators);
        }


    }

    public void fire(String name) {

    }

    public void getIncome() {

    }

}
