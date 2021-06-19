public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");

        Basket.addAllPrice(45);
        Basket.addAllPrice(60);

        Basket.addAllCount(3);
        Basket.addAllCount(7);

        Basket.averagePrice();
        Basket.averageBasket();

    }

}
