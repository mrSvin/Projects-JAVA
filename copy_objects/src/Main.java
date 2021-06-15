public class Main {

    public static void main(String[] args) {


        Dimensions dimensions = new Dimensions(25,35,45);
        dimensions.volume();

        Cargo cargo = new Cargo(dimensions.volume, "100 kg", "Porosyatkovo", "Переворачиваемый", "1658daq2", "true");
        //cargo.setAdress("sddsdsd");
        System.out.println(cargo + "\n");

        Cargo copy_adress = new Cargo(
                cargo.getDimensions(),
                cargo.getMassa(),
                "Kurochkino",
                cargo.getProperty(),
                cargo.getNumber(),
                cargo.getFragile());

        System.out.println(copy_adress + "\n");

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
                copy_dimensions.volume,
                cargo.getMassa(),
                cargo.getAdress(),
                cargo.getProperty(),
                cargo.getNumber(),
                cargo.getFragile());

        System.out.println(copy_volume + "\n");

    }
}
