public class Computer {

    private String vendor="China";
    private String name ="IBM";
    static int allWeight=0;

    public Computer (cpuType cpu, ddrType ddr, hddType hdd, keyboardType keyboard, monitorType monitor) {
        new CPU().cpu(cpu);
        new DDR().ddr(ddr);
        new HDD().hdd(hdd);
        new Monitor().monitor(monitor);
        new Keyboard().keyboard(keyboard);
        allWeight();

        this.vendor = vendor;
        this.name = name;

    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    static void allWeight() {
        allWeight=CPU.weightCPU + DDR.weightDDR + HDD.weightHDD + Monitor.weightMonitor + Keyboard.weightKeyboard;
    }


    public String toString() {
        return "Производитель: " + vendor + " Название: " + name + " Общий вес: " + allWeight;
    }
















}
