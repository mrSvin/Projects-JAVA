public class Main {
    //For new commit
    public static String folder = "D:\\VasilievAV\\Desktop\\test\\movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(folder);
        movements.getExpenseSum();
        movements.getIncomeSum();
        movements.groupExpense();

    }
}
