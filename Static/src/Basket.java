public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    private static double allPrice=0;
    private static double allCount=0;
    private static int countBasket=0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public static void add_allPrice(double addPrice) {
        allPrice=allPrice+addPrice;
        System.out.println("Добавлена сумма к корзине: "+ addPrice + " Общая сумма в корзине: " + allPrice);
    }
    public static void add_allCount(double addCount) {
        allCount=allCount+addCount;
        countBasket++;
        System.out.println("Добавлено количества товаров в корзину: "+ allCount + " Общее количество товаров в корзине: " + addCount);
    }

    public static void averagePrice() {
        double averagePrice=allPrice/allCount;
        System.out.println("Средняя цена в товаров в корзинах: " + averagePrice);
    }

    public static void averageBasket() {
        double averageBasket=allPrice/countBasket;
        System.out.println("Средняя цена в корзинe: " + averageBasket + " Количкство корзин: " + countBasket);
    }



    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
