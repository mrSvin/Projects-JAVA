import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    Pattern pat= Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
    Matcher matcher=pat.matcher(text);
    int sum=0;
    while (matcher.find()) {
      sum=sum+Integer.parseInt(matcher.group());
    };
    System.out.println(sum);
  }

}