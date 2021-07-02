import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static EmailList emailList = new EmailList();

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        emailList = new EmailList();

        String command;
        String text;

        while (true) {

            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            //TODO: write code here

            int endStringCommand = input.indexOf(' ');
            //int lengthCommandText=commandText.length();
            if (endStringCommand > 0) {
                command = input.substring(0, endStringCommand);
                text = input.substring(endStringCommand + 1, input.length());
            } else {
                command = input.substring(0, input.length());
                text = "";
            }

            if (command.equals("ADD")) {
            emailList.add(text);
            }
            if (command.equals("LIST")) {
            emailList.getSortedEmails();
            }

            
        }
    }
}
