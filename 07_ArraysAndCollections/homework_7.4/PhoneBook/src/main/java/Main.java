import java.util.Scanner;
import java.util.Set;

public class Main {

    private static PhoneBook phonebook = new PhoneBook();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        phonebook = new PhoneBook();

        String command;
        String text;

        while (true) {

            System.out.println("Введите номер, имя или команду:");

            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String searchCommand = null;

            String searchNumber = input.replaceAll("[^0-9]", "");
            String searchName = input.replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "");

            //
            if (searchName.equals("LIST")) {
                searchCommand = "LIST";
                phonebook.getAllContacts();
            }
            if (searchNumber.length() > 0 && searchNumber.length() == input.length() && searchName.equals("LIST") == false) {
                String checkNumber = phonebook.getNameByPhone(searchNumber);
                String name = String.valueOf(checkNumber);
                name = name.replace("[", "");
                int serchBeginName = name.indexOf(' ');
                name = name.substring(0, serchBeginName);


                if (name.equals("null") == true) {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера " + searchNumber);
                    Scanner scanner2 = new Scanner(System.in);
                    String inputName = scanner.nextLine();
                    phonebook.addContact(searchNumber, inputName);
                } else {
                    System.out.println("Такой контакт в книге уже есть с именем " + name);
                }

            }
            if (searchName.length() != input.length() && searchNumber.length() != input.length()) {
                System.out.println("Неверный формат ввода");
            }

            if (searchName.length() > 0 && searchName.length() == input.length() && searchName.equals("LIST") == false) {
                Set<String> checkName = phonebook.getPhonesByName(searchName);
                String phone = String.valueOf(checkName);
                phone = phone.replace(" -", "");
                phone = phone.replace("]", "");
                int serchBeginName = phone.indexOf(' ');
                phone = phone.substring(serchBeginName + 1, phone.length());


                if (phone.equals("null") == true) {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.println("Введите номер телефона для абонента " + searchName);
                    Scanner scanner2 = new Scanner(System.in);
                    String inputPhone = scanner.nextLine();
                    phonebook.addContact(inputPhone, searchName);
                } else {
                    System.out.println("Такой контакт в книге уже есть с номером " + phone);
                }

            }


        }
    }
}
