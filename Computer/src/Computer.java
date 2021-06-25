public class Computer {

    private String vendor="China";
    private String name ="IBM";
    private int allWeight=0;
    private CPU cpu;
    private DDR ddr;
    private HDD hdd;
    private Keyboard keyboard;
    private Monitor monitor;

    public Computer (CpuType cpu, DdrType ddr, HddType hdd, KeyboardType keyboard, MonitorType monitor) {

        new CPU().cpu(cpu);
        new DDR().ddr(ddr);
        new HDD().hdd(hdd);
        new Monitor().monitor(monitor);
        new Keyboard().keyboard(keyboard);
        allWeight = CPU.getWeightCPU();
        System.out.println(allWeight);
       // allWeight();


        this.vendor = vendor;
        this.name = name;

    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

   // private void allWeight() {
   //        int weightCPU= CPU.getWeightCPU();
 //       allWeight=CPU.weightCPU + DDR.weightDDR + HDD.weightHDD + Monitor.weightMonitor + Keyboard.weightKeyboard;
   // }


    public String toString() {
        return "Производитель: " + vendor + " Название: " + name + " Общий вес: " + allWeight;
    }
















}
