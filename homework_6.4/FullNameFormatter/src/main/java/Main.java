import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    boolean in=false;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      String input = scanner.nextLine();


      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      int k=0;
      for(int i = 0; i < input.length(); i++) {
        if(Character.UnicodeBlock.of(input.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || String.valueOf(input.charAt(i)).equals("-") || String.valueOf(input.charAt(i)).equals(" ")) {
          k++;
        }
      }
      if (k==input.length()) {
        in=true;
      } else {
        in=false;
      }

      int space1=input.indexOf(" ");
      int space2=input.indexOf(" ",space1+1);
      int space3=input.indexOf(" ", space2+1);
      //System.out.println(space1);
      //System.out.println(space2);
      //System.out.println(space3);

      if (space1>0 && space2>0 && space3<0 && in==true) {
        int endSurname = input.indexOf(" ");
        int endName = input.lastIndexOf(" ");
        int lengthFIO = input.length();
        String surname = input.substring(0, endSurname);
        String name = input.substring(endSurname+1, endName);
        String fathername = input.substring(endName+1, lengthFIO);
        System.out.println("Фамилия: " + surname);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + fathername);


      } else {
        System.out.println("Введенная строка не является ФИО");


      }


    }
  }

}