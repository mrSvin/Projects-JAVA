import java.time.LocalDate;
import java.time.Period;

public class Main {

    public static void main(String[] args) {
        getPeriodFromBirthday(LocalDate.of(1995, 5, 23));
    }

    private static String getPeriodFromBirthday(LocalDate birthday) {

        LocalDate endDate = LocalDate.now();
        System.out.println(endDate);

        Period period = Period.between(birthday, endDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        System.out.println(years + " years " + months + " months " + days + " days");


        return years + " years " + months + " months " + days + " days";
    }

}
