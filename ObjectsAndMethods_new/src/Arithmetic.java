public class Arithmetic {

    private int var1;
    private int var2;


    public  Arithmetic(int var1, int var2) {
    }

    public Arithmetic() {
    }

    public void sum(int var1, int var2) {
        int sum =var1+var2;
        System.out.println("Сумма: " + sum);
    }
    public void razn(int var1, int var2) {
        int razn =var1-var2;
        System.out.println("Разница: " + razn);
    }
    public void sup(int var1, int var2) {
        int sup =var1*var2;
        System.out.println("Произведение: " + sup);
    }
    public void sredn(int var1, int var2) {
        int sredn =(var1+var2)/2;
        System.out.println("Среднее: " + sredn);
    }
    public void max(int var1, int var2) {
        int max =0;
        if (var1>var2) {max=var1;} else {max=var2;}
        System.out.println("Максимальное: " + max);
    }
    public void min(int var1, int var2) {
        int min =0;
        if (var1<var2) {min=var1;} else {min=var2;}
        System.out.println("Минимальное: " + min);
    }
}
