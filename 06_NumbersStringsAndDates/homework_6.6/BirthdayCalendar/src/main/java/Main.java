import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {



        int day = 27;
        int month = 6;
        int year = 2021;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        String weekNow = null;
        String result = "";

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        //System.out.println( new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) );

        String dayNow =  new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String monthNow =  new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        String yearNow =  new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        //System.out.println(dayNow);
        //System.out.println(monthNow);
        //System.out.println(yearNow);


        int k=0;

            for (int i = year; i <= Integer.parseInt(yearNow); i++) {

                if (i<Integer.parseInt(yearNow) || (i==Integer.parseInt(yearNow) && month<=Integer.parseInt(monthNow))  ) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(i, month - 1, day);
                    calendar.get(Calendar.DAY_OF_WEEK);
                    weekNow = formatDate(k, day, month, i,
                            calendar.get(Calendar.DAY_OF_WEEK));
                    result = result + weekNow + "\n";
                    k++;
                }

            }



        return result;
    }

    private static String formatDate(int number, int day, int month, int year, int dayOfWeek) {
        StringBuilder builder = new StringBuilder();
        builder.append(number).append(" - ");
        if (day < 10) {
            builder.append(0);
        }
        builder.append(day).append(".");
        if (month < 10) {
            builder.append(0);
        }
        builder.append(month).append(".").append(year).append(" - ").append(getDayOfWeek(dayOfWeek));
        return builder.toString();
    }

    private static String getDayOfWeek(int day) {
        switch (day) {
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tue";
            case 4:
                return "Wed";
            case 5:
                return "Thu";
            case 6:
                return "Fri";
            case 7:
                return "Sat";
        }
        return "";
    }
}
