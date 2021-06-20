public class ArithmeticCalculator {
    public static int var1=0;
    public static int var2=0;
    public static int result=0;

        public int calculate(int i, int i1, Gearboxtype op) {
            var1=i;
            var2=i1;
            System.out.println("На вход поданы: " + var1 +"," + var2 + " Операция: " + op);
            if (op.equals(Gearboxtype.ADD)) {
                result=var1+var2;
                System.out.println("Результат: " + result);
            }
            if (op.equals(Gearboxtype.SUBTRACT)) {
                result=var1-var2;
                System.out.println("Результат: " + result);
            }
            if (op.equals(Gearboxtype.MULTIPLY)) {
                result=var1*var2;
                System.out.println("Результат: " + result);
            }
            return result;
        }

}
