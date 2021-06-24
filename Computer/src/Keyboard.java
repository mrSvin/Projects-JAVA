public class Keyboard {

    String backlight="нет";
    public static int weightKeyboard=0;

    public void keyboard(keyboardType type) {
        if (type.equals(keyboardType.mechanical)) {
            backlight="нет";
            weightKeyboard=856;
            System.out.println("Выбрана клавиатура: " + keyboardType.mechanical + " подсветка: "
                    + backlight + " Вес: " + weightKeyboard);
        }
        if (type.equals(keyboardType.touch)) {
            backlight="да";
            weightKeyboard=621;
            System.out.println("Выбрана клавиатура: " + keyboardType.touch + " подсветка: "
                    + backlight + " Вес: " + weightKeyboard);
        }

        return;
    }

    public String getBacklight() {
        return backlight;
    }

    public void setBacklight(String backlight) {
        this.backlight = backlight;
    }

    public static int getWeightKeyboard() {
        return weightKeyboard;
    }

    public static void setWeightKeyboard(int weightKeyboard) {
        Keyboard.weightKeyboard = weightKeyboard;
    }

}
