public class Operator implements Employee {
    private int solary;
    private Company company;

    public Operator(Company company) {
        this.company = company;
        solary = 50000;
    }

    @Override
    public int getMonthSolary() {
        return solary;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getMonthSolary(),o2.getMonthSolary());
    }
}