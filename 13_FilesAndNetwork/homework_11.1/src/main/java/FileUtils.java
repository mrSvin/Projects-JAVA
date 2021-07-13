import java.io.File;
import java.text.DecimalFormat;

//For new commit
public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;
        try {

        size = org.apache.commons.io.FileUtils.sizeOfDirectory(new File(path));
        DecimalFormat f = new DecimalFormat("##.00");

        if (size <= 1024) {
            System.out.println("Размер папки: " + size + " байт");
        }
        if (size > 1024 && size < 1024 * 1024) {
            System.out.println("Размер папки: " + f.format(size / 1024.0) + " килобайт");
        }
        if (size > 1024 * 1024 && size < 1024 * 1024 * 1024) {
            System.out.println("Размер папки: " + f.format(size / (1024.0 * 1024)) + " мегабайт");
        }
        if (size > 1024 * 1024 * 1024) {
            System.out.println("Размер папки: " + f.format(size / (1024.0 * 1024 * 1024)) + " гигабайт");
        }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
