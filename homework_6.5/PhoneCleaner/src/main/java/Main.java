import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      int result=0;

      input=input.replaceAll("-", "");
      System.out.println(input);
      if (input.length()>11 || input.length()<10) {
        System.out.println("номер неверный");
      }
      if (input.length()==10) {

        Pattern pat = Pattern.compile("[0-9]+");
        Matcher matcher = pat.matcher(input);

        while (matcher.find()) {
          result = Integer.parseInt(matcher.group());
        }
        ;
        System.out.println("7" + result);
      } else {
        input.substring(1);
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher matcher = pat.matcher(input);

        while (matcher.find()) {
          result = Integer.parseInt(matcher.group());
        }
        ;
        System.out.println(result);
      }

    }
  }

}
