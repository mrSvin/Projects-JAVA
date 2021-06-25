public class Main {
    public static void main(String[] args) {
        System.out.println("Ноутбук 1:");
        Computer computer = new Computer(CpuType.intel, DdrType.ddr3, HddType.SSD, KeyboardType.touch, MonitorType.IPS);
        System.out.println(computer);
        System.out.println("\n" + "Ноутбук 2:");
        Computer computer2 = new Computer(CpuType.amd, DdrType.ddr3, HddType.HDD, KeyboardType.touch, MonitorType.TN);
        System.out.println(computer2);
        System.out.println("\n" + "Ноутбук 3:");
        Computer computer3 = new Computer(CpuType.amd, DdrType.ddr2, HddType.HDD, KeyboardType.mechanical, MonitorType.VA);
        System.out.println(computer3);

    }

}
