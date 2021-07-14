import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
//For new commit
    public static String jsonOut;

    public static void main(String[] args) throws IOException {
        jsonOut = "{ \n \"stations\": {";
        LineParser();
        jsonOut = jsonOut + "\n}";
        FileWriter file = new FileWriter("C:\\Users\\Home\\Desktop\\test\\outJSON.json");
        file.write(jsonOut);
        file.close();

        System.out.println(jsonOut); //span.text()

    }

    private static void LineParser() {
        try {

            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").timeout(40000).maxBodySize(0).get();

            for (int i = 0; i < 17; i++) {
                Element line = doc.getElementsByClass("js-metro-stations t-metrostation-list-table").get(i);
                Elements span = line.getElementsByClass("name");

                jsonOut = jsonOut + "\n\"" + (i+1) + "\": [";

                for (int k = 0; k < span.size(); k++) {
                    jsonOut = jsonOut + "\n\"" + span.get(k).text() + "\"";
                }
                if (i<16) {
                    jsonOut = jsonOut + "\n],";
                } else {
                    jsonOut = jsonOut + "\n]";
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
