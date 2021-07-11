import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        ImageParser();
    }

    private static void ImageParser() {

        try {

            Document doc = Jsoup.connect("https://lenta.ru").get();
            Elements imageElement = doc.select("img");
            for (Element el : imageElement) {
                String src = el.absUrl("src");
                //System.out.println("src attribute is : "+src);

                int beginName = src.lastIndexOf("/") + 1;
                String name = src.substring(beginName, src.length());
                name = name.replace("?", "");
                name = name.replace(".jpg", "");
                System.out.println(name);

                Connection.Response resultImageResponse = Jsoup.connect(src)
                        .ignoreContentType(true).execute();

                FileOutputStream out = (new FileOutputStream(new java.io.File("D:\\VasilievAV\\Desktop\\test\\" + name + ".jpg")));
                out.write(resultImageResponse.bodyAsBytes());
                out.close();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
