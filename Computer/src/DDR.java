public class DDR {

    String typeDDR="DDR";
    int memory=0;
    public static int weightDDR=0;

    public void ddr(ddrType type) {
        if (type.equals(ddrType.ddr3)) {
            typeDDR="DDR3";
            memory=4096;
            weightDDR=159;
            System.out.println("Выбрана оперативная память: " + ddrType.ddr3 + " Память: "
                    + memory + " Вес: " + weightDDR);
        }
        if (type.equals(ddrType.ddr2)) {
            typeDDR="DDR2";
            memory=1024;
            weightDDR=164;
            System.out.println("Выбрана оперативная память: " + ddrType.ddr2 + " Память: "
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

    public static int getWeightDDR() {
        return weightDDR;
    }

    public static void setWeightDDR(int weightDDR) {
        DDR.weightDDR = weightDDR;
    }

}
