public class Monitor {
    int diagonal=0;
    int memory=0;
    public static int weightMonitor=0;

    public void monitor(monitorType type) {
        if (type.equals(monitorType.IPS)) {
            diagonal=24;
            weightMonitor=2356;
            System.out.println("Выбран экран: " + monitorType.IPS + " диагональ: "
                    + diagonal + " Вес: " + weightMonitor);
        }
        if (type.equals(monitorType.TN)) {
            diagonal=22;
            weightMonitor=1856;
            System.out.println("Выбран экран: " + monitorType.TN + " диагональ: "
                    + diagonal + " Вес: " + weightMonitor);
        }
        if (type.equals(monitorType.VA)) {
            diagonal=19;
            weightMonitor=1657;
            System.out.println("Выбран экран: " + monitorType.VA + " диагональ: "
                    + diagonal + " Вес: " + weightMonitor);
        }
        return;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public static int getWeightMonitor() {
        return weightMonitor;
    }

    public static void setWeightMonitor(int weightMonitor) {
        Monitor.weightMonitor = weightMonitor;
    }

}
