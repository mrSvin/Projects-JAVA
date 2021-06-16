public class Product {
    private final String name;
    private final String barCode;

    private int price = 30;

    public Product(String name, int price, String barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public String getbarCode() {
        return barCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
