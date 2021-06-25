public class Computer {

    private String vendor="China";
    private String name ="IBM";
    private int allWeight=0;
    private CPU cpuComputer;
    private DDR ddrComputer;
    private HDD hddComputer;
    private Keyboard keyboardComputer;
    private Monitor monitorComputer;

    public Computer (CpuType cpu, DdrType ddr, HddType hdd, KeyboardType keyboard, MonitorType monitor) {

        cpuComputer = new CPU(cpu);
        cpuComputer.getFreq();
        cpuComputer.getCores();
        cpuComputer.getManufac();
        ddrComputer= new DDR(ddr);
        ddrComputer.getTypeDDR();
        ddrComputer.getMemory();
        hddComputer= new HDD(hdd);
        hddComputer.getTypeHDD();
        hddComputer.getMemory();
        monitorComputer=new Monitor(monitor);
        monitorComputer.getDiagonal();
        keyboardComputer=new Keyboard(keyboard);
        keyboardComputer.getBacklight();

          allWeight = cpuComputer.getWeightCPU()+ddrComputer.getWeightDDR()+hddComputer.getWeightHDD()
                  +monitorComputer.getWeightMonitor()+keyboardComputer.getWeightKeyboard();

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
