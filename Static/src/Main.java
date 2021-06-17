public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");

        Basket.add_allPrice(45);
        Basket.add_allPrice(60);

        Basket.add_allCount(3);
        Basket.add_allCount(7);

        Basket.averagePrice();
        Basket.averageBasket();

    }

}
