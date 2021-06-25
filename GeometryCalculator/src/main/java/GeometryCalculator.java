import static java.lang.StrictMath.sqrt;

public class GeometryCalculator {
    private static boolean resultPossible;

    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
            double result = Math.PI * radius *radius;
            System.out.println("Площадь круга: " + result);
        return result;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double result = 4/3.0*Math.PI * radius *radius*radius;
        System.out.println("Объем шара: " + result);
        return result;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {

        if (a+b>c && b+c>a && c+a>b) {
            resultPossible=true;
        } else {resultPossible=false;}
        System.out.println("Возможность построения: " + resultPossible);
        return resultPossible;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        GeometryCalculator.isTrianglePossible(a,b,c);
        double result=0;
        if (resultPossible==true) {
            double p = (a + b + c) / 2;
            result = sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Площадь треугольника: " + result);
        } else {
            result=-1.0;
            System.out.println("Построение невозможно! " + result);
        }
            return result;
    }
}
