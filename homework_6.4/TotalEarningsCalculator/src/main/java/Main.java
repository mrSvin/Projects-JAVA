public class Main {

  public static void main(String[] args) {
  // indexOf(),lastIndexOf(), substring() и trim().
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    String textTrim=text.trim();
    //TODO: напишите ваш код, результат вывести в консоль
    int numb5=textTrim.indexOf('5');
    String firstNumber=textTrim.substring(numb5,numb5+4);

    int numb7=text.indexOf('7');
    String twoNumber=text.substring(numb7,numb7+4);

    int numb3=text.lastIndexOf('3');
    String lustNumber=text.substring(numb3,numb3+5);

    int result=Integer.parseInt(firstNumber)+Integer.parseInt(twoNumber)+Integer.parseInt(lustNumber);

    System.out.println("Результат: " + result);
  }

}