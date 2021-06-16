public class Main {

    public static void main(String[] args) {


        Dimensions dimensions = new Dimensions(25,35,45);
        dimensions.volume();

        Cargo cargo = new Cargo(dimensions, "100 kg", "Porosyatkovo", "Переворачиваемый", "1658daq2", "true");

        System.out.println( dimensions.volume + "\n" + cargo + "\n");

        Cargo copy_adress = new Cargo(
                dimensions,
                cargo.getMassa(),
                "Kurochkino",
                cargo.getProperty(),
                cargo.getNumber(),
                cargo.getFragile());

        System.out.println(dimensions.volume + "\n" + copy_adress + "\n");

        Cargo copy_massa = new Cargo(
                cargo.getDimensions(),
                "50 kg",
                cargo.getAdress(),
                cargo.getProperty(),
                cargo.getNumber(),
                cargo.getFragile());

        System.out.println(copy_massa + "\n");

        Dimensions copy_dimensions= new Dimensions(10, 10, 10);
        copy_dimensions.volume();

        Cargo copy_volume = new Cargo(
                copy_dimensions,
                cargo.getMassa(),
                cargo.getAdress(),
                cargo.getProperty(),
                cargo.getNumber(),
                cargo.getFragile());

        System.out.println(copy_dimensions.volume + "\n" + copy_volume + "\n");

    }
}
