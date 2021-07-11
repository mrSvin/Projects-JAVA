import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите путь папки, которую хотите скопировать:");
            String scannerFolder = new Scanner(System.in).next();
            System.out.println("Введите дерикторию, в котоую нужно скопировать:");
            String scannerFolderCopy = new Scanner(System.in).next();
            System.out.println("Файл успешно скопирован!");
            FileUtils.copyFolder(scannerFolder, scannerFolderCopy);
        }
    }
}
