public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008> 1234 <5678> 8912", "***");
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        int begin=text.indexOf('<');
        int end=text.indexOf('>')+1;
        int begin2=text.lastIndexOf('<');
        int end2=text.lastIndexOf('>')+1;
        if (begin>0 && end>0) {
            //System.out.println(begin + " " + end);
            String code = text.substring(begin, end);
            //System.out.println(code);
            String code2 = text.substring(begin2, end2);
            text = text.replace(code, placeholder);
            text = text.replace(code2, placeholder);
            System.out.println(text);
        }
        System.out.println(text);
        return text;
    }

}