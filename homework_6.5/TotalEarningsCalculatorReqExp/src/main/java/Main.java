import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

  public static void main(String[] args) {

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    Pattern pat= Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
    Matcher matcher=pat.matcher(text);
    int sum=0;
    while (matcher.find()) {
      sum=sum+Integer.parseInt(matcher.group());
    };
    System.out.println(sum);
    return sum;
  }

}