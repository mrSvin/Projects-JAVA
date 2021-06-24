public class HDD {

    String typeHDD="SSD";
    int memory=0;
    public static int weightHDD=0;

    public void hdd(hddType type) {
        if (type.equals(hddType.HDD)) {
            typeHDD="HDD";
            memory=128;
            weightHDD=672;
            System.out.println("Выбран жесткий диск: " + hddType.HDD + " Память: "
                    + memory + " Вес: " + weightHDD);
        }
        if (type.equals(hddType.SSD)) {
            typeHDD="SSD";
            memory=256;
            weightHDD=215;
            System.out.println("Выбран жесткий диск: " + hddType.SSD + " Память: "
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

    public static int getWeightHDD() {
        return weightHDD;
    }

    public static void setWeightHDD(int weightHDD) {
        HDD.weightHDD = weightHDD;
    }

}
