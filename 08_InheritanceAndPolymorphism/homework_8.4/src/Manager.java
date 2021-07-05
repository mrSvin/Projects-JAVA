public class Manager implements Employee {
    private int solary;

    public Manager() {
        solary = 60000 + (int) ((115000 + Math.random() * 25000) * 0.05);
    }

    @Override
    public int getMonthSolary() {
        return solary;
    }
}