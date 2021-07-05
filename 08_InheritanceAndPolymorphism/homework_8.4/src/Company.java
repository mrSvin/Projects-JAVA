import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Company {

    public static List<String> topManagers = new ArrayList<>();
    public static List<String> managers = new ArrayList<>();
    public static List<String> operators = new ArrayList<>();

    public static List<Integer> topManagersSolary = new ArrayList<>();
    public static List<Integer> managersSolary = new ArrayList<>();
    public static List<Integer> operatorsSolary = new ArrayList<>();
    public static List<Integer> allSolary = new ArrayList<>();

    private int income = 100_000_000;

    Company company;


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
            for (int i = 0; i < names.size(); i++) {
                topManagers.add(names.get(i));
            }
            System.out.println(topManagers);
        }
        if (position.equals("managers")) {
            for (int i = 0; i < names.size(); i++) {
                managers.add(names.get(i));
            }
            System.out.println(managers);
        }
        if (position.equals("operators")) {
            for (int i = 0; i < names.size(); i++) {
                operators.add(names.get(i));
            }
            System.out.println(operators);
        }

    }

    public void fire(String name, String position) {
        if (position.equals("topManagers")) {
            for (int i = 0; i < topManagers.size(); i++) {
                if (topManagers.get(i).equals(name)) {
                    topManagers.remove(i);
                    System.out.println("Уволен Топ Менеджер " + name);
                }
            }
        }

        if (position.equals("managers")) {
            for (int i = 0; i < managers.size(); i++) {
                if (managers.get(i).equals(name)) {
                    managers.remove(i);
                    System.out.println("Уволен Менеджер " + name);
                }
            }
        }

        if (position.equals("operators")) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i).equals(name)) {
                    operators.remove(i);
                    System.out.println("Уволен Оператор " + name);
                }
            }
        }

    }

    public List<Integer> getLowestSalaryStaff(int count) {
        solary();
        Collections.sort(allSolary);
        System.out.println("Самые низкие зарплаты: " + allSolary.subList(0, count));
        return allSolary.subList(0, count);
    }

    public List<Integer> getTopSalaryStaff(int count) {
        solary();
        //System.out.println("до сортировки " + allSolary);
        Collections.sort(allSolary, Collections.reverseOrder());
        //System.out.println("после сортировки " + allSolary);
        System.out.println("Самые высокие зарплаты: " + allSolary.subList(0, count));
        return allSolary.subList(0, count);
    }

    public int getIncome() {
        return income;
    }

    public static void solary() {
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
        topManagersSolary = new ArrayList<>();
        operatorsSolary = new ArrayList<>();
        managersSolary = new ArrayList<>();

        for (int i = 0; i < managers.size(); i++) {
            managersSolary.add(manager.getMonthSolary());
            //System.out.println(manager.getMonthSolary());
        }
        for (int i = 0; i < operators.size(); i++) {
            operatorsSolary.add(operator.getMonthSolary());
            //System.out.println(operator.getMonthSolary());
        }
        for (int i = 0; i < topManagers.size(); i++) {
            topManagersSolary.add(topManager.getMonthSolary());
            //System.out.println(topManager.getMonthSolary());
        }
        allSolary = new ArrayList<>();
        allSolary.addAll(managersSolary);
        allSolary.addAll(operatorsSolary);
        allSolary.addAll(topManagersSolary);
        //System.out.println(allSolary.size());

    }

}
