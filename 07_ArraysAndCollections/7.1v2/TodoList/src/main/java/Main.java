import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();


    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        todoList = new TodoList();

        String command;
        String text;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String commandText = scanner.nextLine();

            int endStringCommand = commandText.indexOf(' ');
            //int lengthCommandText=commandText.length();
            if (endStringCommand > 0) {
                command = commandText.substring(0, endStringCommand);
                text = commandText.substring(endStringCommand + 1, commandText.length());
            } else {
                command = commandText.substring(0, commandText.length());
                text = "";
            }

            if (command.equals("ADD")) {
                todoList.add(text);
                System.out.println("Добавлено дело " + text);
            }
            if (command.equals("LIST")) {
                todoList.getTodos();
            }
            if (command.equals("EDIT")) {

                Pattern patIn = Pattern.compile("[0-9]+");
                Matcher matcherIn = patIn.matcher(text);
                String number = null;
                while (matcherIn.find()) {
                    number = matcherIn.group();
                }
                text = text.replaceAll(number, "");
                text = text.replaceAll(" ", "");
                ;
                String oldText = todoList.getArrayList().get(Integer.parseInt(number));
                todoList.edit(text, Integer.parseInt(number));
                System.out.println("Дело \"" + oldText + "\" заменено на " + text);
            }

            if (command.equals("DELETE")) {
                Pattern patIn = Pattern.compile("[0-9]+");
                Matcher matcherIn = patIn.matcher(text);
                String number = null;
                while (matcherIn.find()) {
                    number = matcherIn.group();
                }
                if (Integer.parseInt(number)<todoList.getArrayList().size()) {
                text = text.replaceAll(number, "");
                text = text.replaceAll(" ", "");
                String oldText = todoList.getArrayList().get(Integer.parseInt(number));
                    todoList.delete(Integer.parseInt(number));
                    System.out.println("Дело \"" + oldText + "\" удалено");
                } else {
                    System.out.println("Дело с таким номером не существует");
                }
            }


        }
    }
}
