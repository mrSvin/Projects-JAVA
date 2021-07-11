import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Movements {

    public ArrayList<Double> income = new ArrayList<Double>();
    public ArrayList<Double> expense = new ArrayList<Double>();

    public List<String> groupName = new ArrayList<String>();
    public ArrayList<Double> groupExpene = new ArrayList<Double>();

    public Movements(String pathMovementsCsv) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                int indexOf = line.indexOf("MCC");
                if (fragments.length == 1 && indexOf > 0) {
                    String fragmentSearch = line.substring(indexOf, line.length());
                    fragmentSearch = fragmentSearch.substring(fragmentSearch.indexOf(",") + 1, fragmentSearch.length());
                    //System.out.println(fragmentSearch);
                    //Получаем Приход
                    if (fragmentSearch.charAt(0) != '"') {
                        String incomeString = fragmentSearch.substring(0, fragmentSearch.indexOf(","));
                        //System.out.println(incomeString);
                        income.add(Double.parseDouble(incomeString));
                    } else {
                        String incomeString = fragmentSearch.substring(1, fragmentSearch.indexOf("\","));
                        incomeString = incomeString.replaceAll(",", ".");
                        //System.out.println(incomeString);
                        income.add(Double.parseDouble(incomeString));
                    }

                    //Получаем Расход
                    if (fragmentSearch.charAt(fragmentSearch.length() - 1) != '"') {
                        String expenseString = fragmentSearch.substring(fragmentSearch.lastIndexOf(",") + 1, fragmentSearch.length());
                        //System.out.println(expenseString);
                        expense.add(Double.parseDouble(expenseString));
                    } else {
                        String expenseString = fragmentSearch.substring(fragmentSearch.indexOf(",\"") + 2, fragmentSearch.length() - 1);
                        expenseString = expenseString.replaceAll(",", ".");
                        //System.out.println(expenseString);
                        expense.add(Double.parseDouble(expenseString));
                    }

                    //Получаем Имя конторы
                    String lineUnificat = line.replace("/", "\\");
                    //System.out.println(lineUnificat);
                    int indexBeginName = lineUnificat.lastIndexOf("\\");
                    if (indexBeginName > 0) {
                        lineUnificat = lineUnificat.substring(indexBeginName, lineUnificat.length());
                        //System.out.println(lineUnificat);
                        int indexEndName = lineUnificat.indexOf("   ");
                        String name = lineUnificat.substring(1, indexEndName);
                        //System.out.println(name);
                        groupName.add(name);
                    }
                }
            }
            //groupExpense();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        System.out.println("Сумма расходов: " + expense.stream()
                .mapToDouble(Double::doubleValue)
                .sum());
        return expense.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getIncomeSum() {
        System.out.println("Сумма доходов: " + income.stream()
                .mapToDouble(Double::doubleValue)
                .sum());
        return income.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public void groupExpense() {
        double sum = 0;
        ArrayList<String> organizations = new ArrayList<String>();

        //organizations.add(groupName.get(0));
        System.out.println("Суммы расходов по организациям: ");

        //Формируем уникальный список компаний
        organizations = (ArrayList<String>) groupName.stream().distinct().collect(Collectors.toList());
        //System.out.println(organizations);

        for (int i = 0; i < organizations.size(); i++) {
            for (int k = 0; k < groupName.size(); k++) {
                if (organizations.get(i).equals(groupName.get(k))) {
                    sum = sum + expense.get(k);
                }
            }
            System.out.println(organizations.get(i) + "   " + sum + " руб.");
            sum=0;
        }



    }

}
