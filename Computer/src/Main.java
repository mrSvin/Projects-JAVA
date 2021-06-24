public class Main {
    public static void main(String[] args) {
        System.out.println("Ноутбук 1:");
        Computer computer = new Computer(cpuType.intel, ddrType.ddr3, hddType.SSD, keyboardType.touch, monitorType.IPS);
        System.out.println(computer);
        System.out.println("\n" + "Ноутбук 2:");
        Computer computer2 = new Computer(cpuType.amd, ddrType.ddr3, hddType.HDD, keyboardType.touch, monitorType.TN);
        System.out.println(computer2);
        System.out.println("\n" + "Ноутбук 3:");
        Computer computer3 = new Computer(cpuType.amd, ddrType.ddr2, hddType.HDD, keyboardType.mechanical, monitorType.VA);
        System.out.println(computer3);

    }

}
