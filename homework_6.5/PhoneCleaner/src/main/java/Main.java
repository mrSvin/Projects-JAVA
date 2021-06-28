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

      input=input.replaceAll("-", "");
      input=input.replaceAll(" ", "");
      input=input.replaceAll("\\(", "");
      input=input.replaceAll("\\)", "");
      input=input.replaceAll("\\+", "");

      Pattern patIn = Pattern.compile("[0-9]+");
      Matcher matcherIn = patIn.matcher(input);
      while (matcherIn.find()) {
        input=matcherIn.group();
      }

      if (input.length()>11 || input.length()<10) {
        System.out.println("Неверный формат номера");
        continue;
      }
      if (input.length()==10) {
          input=input.substring(1);
       // }
        System.out.println("79" + input);
      } else {
        char сheck = input.charAt(0);
        int a=Character.getNumericValue(сheck);
        if ( a>=7 && a<=8) {
          input = input.substring(1);
          input = input.substring(1);

          System.out.println("79" + input);
        } else {
          System.out.println("Неверный формат номера");
          continue;
        }
      }

    }
  }

}
