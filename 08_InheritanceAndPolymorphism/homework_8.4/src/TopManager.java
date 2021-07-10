public class TopManager implements Employee {
    private Company company;
    private int solary;


    public TopManager(Company company) {
        this.company = company;
        if (company.getIncome() < 1_000_000) {
            solary = 250000;
        } else {
            solary = (int) (250000 * 1.5);
        }
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
