public class CPU {

    int freq=0;
    int cores=0;
    String manufac="USA";
    public static int weightCPU=0;

    public String cpu(cpuType type) {
        if (type.equals(cpuType.amd)) {
            freq=3200;
            cores=12;
            manufac="США";
            weightCPU=326;
            System.out.println("Выбран процессор: " + cpuType.amd + " Частота: "
                    + freq + " Количество ядер: " + cores + " Производитель: " + manufac + " Вес: " + weightCPU);
        }
        if (type.equals(cpuType.intel)) {
            freq=2800;
            cores=8;
            manufac="США";
            weightCPU=286;
            System.out.println("Выбран процессор: " + cpuType.intel + " Частота: "
                    + freq + " Количество ядер: " + cores + " Производитель: " + manufac + " Вес: " + weightCPU);
        }
        return null;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getManufac() {
        return manufac;
    }

    public void setManufac(String manufac) {
        this.manufac = manufac;
    }

    public static int getWeightCPU() {
        return weightCPU;
    }

    public static void setWeightCPU(int weightCPU) {
        CPU.weightCPU = weightCPU;
    }

}
