public class Operator implements Employee {
    private int solary;

    public Operator() {
        solary = 50000;
    }

    @Override
    public int getMonthSolary() {
        return solary;
    }
}