public class TopManager implements Employee {
    private int solary;


    public TopManager() {
        Company company = new Company();
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
}
