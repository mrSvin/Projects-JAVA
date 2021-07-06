import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        //исключение количество слов
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format");
        }
        //исключение неверный номер
        String searchPhone = null;
        Pattern patIn = Pattern.compile("[0-9]+");
        Matcher matcherIn = patIn.matcher(components[INDEX_PHONE]);
        while (matcherIn.find()) {
            searchPhone = matcherIn.group();
        }
        if (searchPhone.length() != 11) {
            throw new IllegalArgumentException("Wrong format");
        }
        //исключение email
        String searchEmail = components[INDEX_EMAIL];
        int checkOne = searchEmail.indexOf('@');
        int checkTwo = searchEmail.indexOf('.');
        if (checkOne == -1 && checkTwo == -1) {
            throw new IllegalArgumentException("Wrong format");
        }

        try {
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}