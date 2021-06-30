import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount {

    int year=0;
    int month=0;
    int dayOfMonth=0;

    double checkTime=0;

    private LocalDate date;
    private LocalDate lastIncome;

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            account = account + amountToPut;
            date=LocalDate.now();;

            int year = date.getYear();
            int month = date.getMonthValue();
            int dayOfMonth = date.getDayOfMonth();

            checkTime=year+1 + month/12.0 + dayOfMonth/365.0;

            System.out.println(checkTime);
        }
    }

    public void take(double amountToTake) {

        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();

        double futureTime = year + month/12.0 + dayOfMonth/365.0;
        System.out.println(futureTime);

        if (amountToTake<account && futureTime<checkTime) {
            account = account - amountToTake;
        }

    }

}
