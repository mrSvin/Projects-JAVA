public class Cargo {

    private final int dimensions;
    private final String massa;
    private final String adress;
    private final String property;
    private final String number;
    private final String fragile;

    public Cargo(int dimensions, String massa, String adress, String property, String number, String fragile) {
        this.dimensions = dimensions;
        this.massa = massa;
        this.adress = adress;
        this.property = property;
        this.number = number;
        this.fragile = fragile;
    }

    public int getDimensions() {
        return dimensions;
    }

    public Cargo setDimensions(int dimensions) {
       return new Cargo(dimensions, massa, adress, property, number, fragile);
    }

    public String getMassa() {
        return massa;
    }

    public Cargo setMassa(String massa) {
        return new Cargo(dimensions, massa, adress, property, number, fragile);
    }

    public String getAdress() {
        return adress;
    }

    public Cargo setAdress(String adress) {
        return new Cargo(dimensions, massa, adress, property, number, fragile);
    }

    public String getProperty() {
        return property;
    }

    public Cargo setProperty(String property) {
        return new Cargo(dimensions, massa, adress, property, number, fragile);
    }

    public String getNumber() {
        return number;
    }

    public Cargo setNumber(String number) {
        return new Cargo(dimensions, massa, adress, property, number, fragile);
    }

    public String getFragile() {
        return fragile;
    }

    public Cargo setFragile(String fragile) {
        return new Cargo(dimensions, massa, adress, property, number, fragile);
    }

    public String toString() {
        return dimensions + "\n" + massa + "\n" + adress + "\n" + property + "\n" + number + "\n" + fragile;
    }



}
