public class Country {

    private static String countryName = "";
    private static int populationSize = 0;
    private static int area = 0;
    private static String capital = "";
    private static boolean presenceSea = false;



    public Country() {
        setCountryName("Россия");
        getCountryName();

        setPopulationSize(144000000);
        getPopulationSize();

        setArea(17130000);
        getArea();

        setСapital("Москва");
        getСapital();

        setPresenceSea(true);
        getPresenceSea();

        System.out.println("Страна: " + countryName + " Численность населения: " + populationSize + " Площадь: " + area + " Наличие моря: " + true);

    }

    public static String getCountryName() {
        return countryName;
    }

    public static void setCountryName(String countryName) {
        countryName = countryName;
    }



    public static int getPopulationSize() {
        return populationSize;
    }

    public static void setPopulationSize(int populationSize) {
        populationSize = populationSize;
    }

    public static int getArea() {
        return area;
    }

    public static void setArea(int area) {
        area = area;
    }

    public static String getСapital() {
        return capital;
    }

    public static void setСapital(String сapital) {
        capital = сapital;
    }

    public static boolean getPresenceSea() {
        return presenceSea;
    }

    public static void setPresenceSea(boolean presenceSea) {
        presenceSea = presenceSea;
    }






}
