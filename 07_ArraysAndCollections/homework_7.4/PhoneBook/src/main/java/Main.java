import java.util.Scanner;

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

            String searchNumber= input.replaceAll("[^0-9]", "");
            String searchName= input.replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "");

            //
            if (searchName.equals("LIST")) {
                searchCommand = "LIST";
                phonebook.getAllContacts();
            }
            if (searchNumber.length()>0 && searchNumber.length()==input.length()) {
            String checkNumber =  phonebook.getNameByPhone(searchNumber);
            //System.out.println(checkNumber);
                if (checkNumber!=null) {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера " + searchNumber);
                    Scanner scanner2 = new Scanner(System.in);
                    String inputName = scanner.nextLine();
                    phonebook.addContact(searchNumber, inputName);
                }


            }


        }
    }
}
