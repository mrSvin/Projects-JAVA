import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            String regex = "[0123456789!@#$%^&*()_+=qwertyuiop{}asdfghjklzxcvbnm{}:'<>?/|QWERTYUIOPASDFGHJKLZXCVBNM]+";

            Pattern pattern = Pattern.compile(regex);
            Matcher m = pattern.matcher(input);

            int k = 0;
            String[] splitArray = input.split(" ");
            for (String split : splitArray) {
                k++;
                //System.out.println(k);
            }


            if (m.find() || k != 3) {
                System.out.println("Введенная строка не является ФИО");
            } else {
                int i = 0;
                String[] FIO = new String[3];
                FIO[0] = "Фамилия: ";
                FIO[1] = "Имя: ";
                FIO[2] = "Отчество: ";

                for (String split : splitArray) {
                    System.out.println(FIO[i] + split);
                    FIO[i] = split;
                    //System.out.println(i);
                    i++;
                }

            }

        }
    }

}