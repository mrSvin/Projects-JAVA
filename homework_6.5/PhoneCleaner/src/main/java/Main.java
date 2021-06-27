import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  String result;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      input=input.replaceAll("-", "");
      System.out.println(input);
      if (input.length()>11 || input.length()<10) {
        System.out.println("номер неверный");
      }
      if () {
        n = n % (int) Math.pow(10, (int) Math.log10(n));
      }

      Pattern pat= Pattern.compile("[0-9]+");
      Matcher matcher=pat.matcher(input);
      int result=0;
      while (matcher.find()) {
        result=Integer.parseInt(matcher.group());
      };
      System.out.println(result);

    }
  }

}
