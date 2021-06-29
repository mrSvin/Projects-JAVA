import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmailList {

    public ArrayList<String> emailList = new ArrayList<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется
        int checkOne = email.indexOf('@');
        int checkTwo = email.indexOf('.');

        int checkDuplicate = 0;

        email = email.toLowerCase();
        for (int i = 0; i < emailList.size(); i++) {

            if (emailList.get(i).equals(email)) {
                checkDuplicate++;
            }
        }
        if (checkOne > 0 && checkTwo > 0 && checkDuplicate == 0) {
            emailList.add(email);
        }


    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке

        Collections.sort(emailList);
        System.out.println(emailList);
        return emailList;
    }

}
