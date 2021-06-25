public class Main {
    public static void main(String[] args) {
        byte minByte = -128;
        byte maxByte = 127;
        System.out.println("Минимальное: " +minByte + " Максимальное: " + maxByte);
        short minShort = -32768;
        short maxShort = 32767;
        System.out.println("Минимальное: " +minShort + " Максимальное: " + maxShort);
        int minInt = -2147483648;
        int maxInt = 2147483647;
        System.out.println("Минимальное: " +minInt + " Максимальное: " + maxInt);
        long minLong = -9223372036854775808L;
        long maxLong = 9223372036854775807L;
        System.out.println("Минимальное: " +minLong + " Максимальное: " + maxLong);
        double minDouble = 4.9e-324;
        double maxDouble = 1.7e+308;
        System.out.println("Минимальное: " +minDouble + " Максимальное: " + maxDouble);
        float minFloat = 1.4e-45f;
        float maxFloat = 3.4e+38f;
        System.out.println("Минимальное: " +minFloat + " Максимальное: " + maxFloat);
    }
}
