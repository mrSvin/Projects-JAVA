import java.util.Scanner;

public class Main {

//For new commit
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите путь до папки:");
            String scanner = new Scanner(System.in).next();
            FileUtils.calculateFolderSize(scanner);
        }

    }
}
