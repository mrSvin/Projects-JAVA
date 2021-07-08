import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount {

    int year=0;
    int month=0;
    int dayOfMonth=0;

    double checkTime=0;

    LocalDate lastIncome;

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            account = account + amountToPut;
            lastIncome=LocalDate.now();;

            year = lastIncome.getYear();
            month = lastIncome.getMonthValue();
            dayOfMonth = lastIncome.getDayOfMonth();

            checkTime=year+1 + month/12.0 + dayOfMonth/365.0;

            System.out.println(checkTime);
        }
    }

    public void take(double amountToTake) {

        year = lastIncome.getYear();
        month = lastIncome.getMonthValue();
        dayOfMonth = lastIncome.getDayOfMonth();

        double futureTime = year + month/12.0 + dayOfMonth/365.0;
        System.out.println(futureTime);

        if (amountToTake<account && futureTime<checkTime) {
            account = account - amountToTake;
        }

    }

}
