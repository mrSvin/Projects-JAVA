public class Monitor {
    private int diagonal=0;
    private int memory=0;
    private int weightMonitor=0;

    public void monitor(MonitorType type) {
        if (type.equals(MonitorType.IPS)) {
            setDiagonal(24);
            setWeightMonitor(2356);
            System.out.println("Выбран экран: " + MonitorType.IPS + " диагональ: "
                    + diagonal + " Вес: " + weightMonitor);
        }
        if (type.equals(MonitorType.TN)) {
            setDiagonal(22);
            setWeightMonitor(1856);
            System.out.println("Выбран экран: " + MonitorType.TN + " диагональ: "
                    + diagonal + " Вес: " + weightMonitor);
        }
        if (type.equals(MonitorType.VA)) {
            setDiagonal(19);
            setWeightMonitor(1657);
            System.out.println("Выбран экран: " + MonitorType.VA + " диагональ: "
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

    public int getWeightMonitor() {
        return weightMonitor;
    }

    public void setWeightMonitor(int weightMonitor) {
        this.weightMonitor = weightMonitor;
    }

}
