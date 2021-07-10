public class Manager implements Employee {
    private int solary;
    private Company company;

    public Manager(Company company) {
        this.company = company;
        solary = 60000 + (int) ((115000 + Math.random() * 25000) * 0.05);
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