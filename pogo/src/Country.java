public class Country {

    private static String CountryName = "";
    private static int PopulationSize = 0;
    private static int Area = 0;
    private static String Сapital = "";
    private static boolean PresenceSea = false;

    public static void main(String[] args) {

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

        System.out.println("Страна: " + CountryName + " Численность населения: " + PopulationSize + " Площадь: " + Area + " Наличие моря: " + true);

    }

    public Country() {
    }

    public static String getCountryName() {
        return CountryName;
    }

    public static void setCountryName(String countryName) {
        CountryName = countryName;
    }



    public static int getPopulationSize() {
        return PopulationSize;
    }

    public static void setPopulationSize(int populationSize) {
        PopulationSize = populationSize;
    }

    public static int getArea() {
        return Area;
    }

    public static void setArea(int area) {
        Area = area;
    }

    public static String getСapital() {
        return Сapital;
    }

    public static void setСapital(String сapital) {
        Сapital = сapital;
    }

    public static boolean getPresenceSea() {
        return PresenceSea;
    }

    public static void setPresenceSea(boolean presenceSea) {
        PresenceSea = presenceSea;
    }






}
