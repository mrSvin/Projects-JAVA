public class Dimensions {

    private final int width;
    private final int hight;
    private final int legth;
    public int volume;

    public Dimensions(int width, int hight, int legth) {
        this.width = width;
        this.hight = hight;
        this.legth = legth;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }

    public int getLegth() {
        return legth;
    }

    public void volume() {
        volume=width*legth*hight;
    }

}
