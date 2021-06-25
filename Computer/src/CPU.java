public class CPU {

    private int freq=0;
    private int cores=0;
    private String manufac="USA";
    private int weightCPU=0;
    private CpuType cpuMod;

    public void cpu(CpuType type) {
        if (type.equals(CpuType.amd)) {
            setCpuMod(CpuType.amd);
            setFreq(3200);
            setCores(12);
            setManufac("США");
            setWeightCPU(326);
            System.out.println("Выбран процессор: " + CpuType.amd + " Частота: "
                    + freq + " Количество ядер: " + cores + " Производитель: " + manufac + " Вес: " + weightCPU);
        }
        if (type.equals(CpuType.intel)) {
            setCpuMod(CpuType.intel);
            setFreq(2800);
            setCores(8);
            setManufac("США");
            setWeightCPU(283);
            System.out.println("Выбран процессор: " + CpuType.intel + " Частота: "
                    + freq + " Количество ядер: " + cores + " Производитель: " + manufac + " Вес: " + weightCPU);
        }
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

    public int getWeightCPU() {
        return weightCPU;
    }

    public void setWeightCPU(int weightCPU) {
        this.weightCPU = weightCPU;
    }
    public CpuType getCpuMod() {
        return cpuMod;
    }

    public void setCpuMod(CpuType cpuMod) {
        this.cpuMod = cpuMod;
    }

}
