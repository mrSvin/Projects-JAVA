import java.util.*;

public class PhoneBook {

    TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        phoneBook.put(phone, name);
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
        String allContact = "";

        //String resultSearch = Arrays.toString(phoneBook.entrySet().toArray());


        for (String key : phoneBook.keySet()) {
            if (allContact.equals("") == false) {
                allContact = allContact + ", ";
            }
            int lengthKey = phoneBook.get(key).length();
            if (lengthKey>0) {
                allContact = allContact + phoneBook.get(key) + " - " + key;
            }
        }
        //Set<String> expected = Set.of("Маша - 79001234567", "Миша - 79991234567");
        return Set.of(allContact);
    }

}