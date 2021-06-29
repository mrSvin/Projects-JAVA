import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений

        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> searchArray = new ArrayList<String>();

        while (matcher.find()) {
            String searchData = text.substring(matcher.start(), matcher.end());
            System.out.println(searchData);
            searchArray.add(searchData);
            System.out.println(searchArray);
        }
        if (searchArray.size()>0) {
            text = text.replace(searchArray.get(0), placeholder);
        }
        if (searchArray.size()==2) {
            text = text.replace(searchArray.get(1), placeholder);
        }

        return text;
    }

}