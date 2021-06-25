public class DDR {

    private String typeDDR="DDR";
    private int memory=0;
    private int weightDDR=0;

    public void ddr(DdrType type) {
        if (type.equals(DdrType.ddr3)) {
            setTypeDDR("DDR3");
            setMemory(4096);
            setWeightDDR(159);
            System.out.println("Выбрана оперативная память: " + DdrType.ddr3 + " Память: "
                    + memory + " Вес: " + weightDDR);
        }
        if (type.equals(DdrType.ddr2)) {
            setTypeDDR("DDR2");
            setMemory(1024);
            setWeightDDR(164);
            System.out.println("Выбрана оперативная память: " + DdrType.ddr2 + " Память: "
                    + memory + " Вес: " + weightDDR);
        }
        return;
    }

    public String getTypeDDR() {
        return typeDDR;
    }

    public void setTypeDDR(String typeDDR) {
        this.typeDDR = typeDDR;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getWeightDDR() {
        return weightDDR;
    }

    public void setWeightDDR(int weightDDR) {
        this.weightDDR = weightDDR;
    }

}
