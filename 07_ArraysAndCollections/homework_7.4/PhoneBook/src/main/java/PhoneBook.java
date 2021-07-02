import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    public TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        String numberOnly= phone.replaceAll("[^0-9]", "");
        String lettersOnly= name.replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "");
        //System.out.println(numberOnly);
        //System.out.println(lettersOnly);

        if (lettersOnly.length() > 0 && numberOnly.length() > 0) {
            phoneBook.put(phone, name);
        }
        System.out.println("Контакт сохранен!");

    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String resultSearch = phoneBook.get(phone) + " - " + phone;
        return resultSearch;
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        String phone = null;
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                phone = entry.getKey();
            }
        }

        String resultSearch = name + " - " + phone;
        return Set.of(resultSearch);
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        //String allContact = "";

        //String resultSearch = Arrays.toString(phoneBook.entrySet().toArray());
        TreeSet<String> states = new TreeSet<String>();

        for (String key : phoneBook.keySet()) {
            // if (allContact.equals("") == false) {
            //      allContact = allContact + ", "; }

            int lengthKey = phoneBook.get(key).length();
            if (lengthKey > 0) {
                //allContact = allContact + phoneBook.get(key) + " - " + key;
                states.add(phoneBook.get(key) + " - " + key);
            }
        }
        System.out.println(states);

        return states;
    }

}