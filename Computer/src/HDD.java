public class HDD {

    private String typeHDD="SSD";
    private int memory=0;
    private int weightHDD=0;

    public HDD(HddType type) {
        if (type.equals(HddType.HDD)) {
            setTypeHDD("HDD");
            setMemory(128);
            setWeightHDD(672);
            System.out.println("Выбран жесткий диск: " + HddType.HDD + " Память: "
                    + memory + " Вес: " + weightHDD);
        }
        if (type.equals(HddType.SSD)) {
            setTypeHDD("SSD");
            setMemory(256);
            setWeightHDD(215);
            System.out.println("Выбран жесткий диск: " + HddType.SSD + " Память: "
                    + memory + " Вес: " + weightHDD);
        }

    }

    public String getTypeHDD() {
        return typeHDD;
    }

    public void setTypeHDD(String typeHDD) {
        this.typeHDD = typeHDD;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getWeightHDD() {
        return weightHDD;
    }

    public void setWeightHDD(int weightHDD) {
        this.weightHDD = weightHDD;
    }

}
