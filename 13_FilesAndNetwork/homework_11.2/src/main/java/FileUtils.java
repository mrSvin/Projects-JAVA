import java.io.File;
import java.io.IOException;


public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        File source = new File(sourceDirectory);
        File dest = new File(destinationDirectory);
        try {
            org.apache.commons.io.FileUtils.copyDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
