public class ArithmeticCalculator {
    public static int var1=0;
    public static int var2=0;

    //Enum current = Gearboxtype.ADD;

    public static class calculate extends ArithmeticCalculator {
        public calculate(int i, int i1, Gearboxtype op) {
            super();
            var1=i;
            var2=i1;
            System.out.println("На вход поданы: " + var1 +"," + var2 + " Операция: " + op);
            if (op.equals(Gearboxtype.ADD)) {
                int result=var1+var2;
                System.out.println("Результат: " + result);
            }
            if (op.equals(Gearboxtype.SUBTRACT)) {
                int result=var1-var2;
                System.out.println("Результат: " + result);
            }
            if (op.equals(Gearboxtype.MULTIPLY)) {
                int result=var1*var2;
                System.out.println("Результат: " + result);
            }
        }
    }
}
