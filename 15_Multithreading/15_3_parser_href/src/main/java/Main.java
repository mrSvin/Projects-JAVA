import org.jsoup.nodes.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static FileWriter fr= null;

    public static void main(String[] args) throws IOException {
        //ParsingSite parsingSite = new ParsingSite();
        //parsingSite.getLinks("https://lenta.ru/");
        File file = new File("C:\\Users\\Home\\Desktop\\test\\SiteMap.txt");
        fr = new FileWriter(file);


        String root = "https://secure-headland-59304.herokuapp.com/";  //skillbox.ru lenta.ru
        //Main.fr.write(root + "\n");
        List<String> herf = new ForkJoinPool().invoke(new ParsingSite(root));
        //System.out.println(herf);

//        fr.write(root + "\n");
//
//        for (String key : herf.keySet()) {
//            int lengthKey = herf.get(key).length();
//            System.out.println(key);
//            if (lengthKey > 0) {
//                fr.write("  " + key + "\n");
//            }
//        }
        fr.close();


    }



}
