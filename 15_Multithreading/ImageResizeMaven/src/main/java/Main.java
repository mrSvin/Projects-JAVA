import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

//for new commit
public class Main {
    private static String dstFolder;

    public static void main(String[] args) {
        String srcFolder = "D:\\VasilievAV\\Desktop\\test\\big";
        dstFolder = "D:\\VasilievAV\\Desktop\\test\\small";

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер: " + cores + " (в моем случае 4, по заданию пишу код по количеству ядер моего ПК. Глупо выглядело, если бы у меня был одноядерный компьютер:) )");

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / cores;
        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);
        //System.out.println(middle);

        File[] files2 = new File[files.length - middle*3];
        System.arraycopy(files, middle, files2, 0, files2.length);
        //System.out.println(files.length - middle*3);

        File[] files3 = new File[files.length - middle*3];
        System.arraycopy(files, middle*2, files3, 0, files3.length);

        File[] files4 = new File[files.length - middle*3];
        System.arraycopy(files, middle*3, files4, 0, files4.length);


        Resize(files1, start, 2,2);
        Resize(files2, start, 2,2);
        Resize(files3, start, 2,2);
        Resize(files4, start, 2,2);

    }


    private static void Resize(File[] files, long start, int targetWidthDivive, int targetHeightDivive) {

        new Thread(() -> {
    try {
        for (File file : files) {
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                continue;
            }

            BufferedImageOp[] bufferedImageOpArray;
            bufferedImageOpArray = new BufferedImageOp[]{Scalr.OP_ANTIALIAS};
            BufferedImage newImage = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, image.getWidth()/targetWidthDivive, image.getHeight()/targetHeightDivive, bufferedImageOpArray);


            File newFile = new File(dstFolder + "/" + file.getName());
            ImageIO.write(newImage, "jpg", newFile);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
            System.out.println("Затраченное время: " + (System.currentTimeMillis() - start));
        }).start();

    }

}
