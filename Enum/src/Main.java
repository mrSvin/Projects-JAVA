public class Main {

    public static void main(String[] args) {

        ArithmeticCalculator.calculate add = ArithmeticCalculator.calculate.ADD;
        System.out.println("Результат сложения: " + add.action(12, 3));

        ArithmeticCalculator.calculate sub = ArithmeticCalculator.calculate.SUBTRACT;
        System.out.println("Результат вычитания: " + sub.action(15, 5));

        ArithmeticCalculator.calculate mul = ArithmeticCalculator.calculate.MULTIPLY;
        System.out.println("Результат умножения: " + mul.action(16, 2));


    }
}
