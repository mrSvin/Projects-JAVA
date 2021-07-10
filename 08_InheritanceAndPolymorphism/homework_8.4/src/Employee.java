import java.util.Comparator;

public interface Employee extends Comparator<Employee> {
    int getMonthSolary();

    default int compareTo(Employee o) {
        return Integer.compare(o.getMonthSolary(), o.getMonthSolary());
    }

}
