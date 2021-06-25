public class Keyboard {

    private String backlight="нет";
    private int weightKeyboard=0;

    public Keyboard(KeyboardType type) {
        if (type.equals(KeyboardType.mechanical)) {
            setBacklight("нет");
            setWeightKeyboard(856);
            System.out.println("Выбрана клавиатура: " + KeyboardType.mechanical + " подсветка: "
                    + backlight + " Вес: " + weightKeyboard);
        }
        if (type.equals(KeyboardType.touch)) {
            setBacklight("да");
            setWeightKeyboard(621);
            System.out.println("Выбрана клавиатура: " + KeyboardType.touch + " подсветка: "
                    + backlight + " Вес: " + weightKeyboard);
        }

    }

    public String getBacklight() {
        return backlight;
    }

    public void setBacklight(String backlight) {
        this.backlight = backlight;
    }

    public int getWeightKeyboard() {
        return weightKeyboard;
    }

    public void setWeightKeyboard(int weightKeyboard) {
        this.weightKeyboard = weightKeyboard;
    }

}
