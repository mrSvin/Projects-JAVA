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

    public static String jsonOut;

    public static void main(String[] args) throws IOException {

        ConvertToJson ConvertToJson = new ConvertToJson();
        ConvertToJson.ConvertJson();

    }



}
