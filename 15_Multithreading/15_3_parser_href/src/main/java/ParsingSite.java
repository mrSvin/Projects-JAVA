import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.TreeMap;
import java.util.concurrent.RecursiveTask;

public class ParsingSite extends RecursiveTask<TreeMap<String, String>> {

    //private String url = "http://www.lenta.ru/";
    String filterElement = "";
    private String node;

    private TreeMap<String,String> sitesTree= new TreeMap<>();

    public ParsingSite(String node) {
        this.node =node;
    }

    @Override
    protected TreeMap<String, String> compute() {
        try {
            Thread.sleep(150);
            Document doc = Jsoup.connect(node).get();
            Elements elements = doc.select("a");
            for (Element element : elements) {
                if (element.absUrl("href").length() > node.length()) {
                    filterElement = element.absUrl("href");
                    //System.out.println(filterElement.substring(0, url.length()));
                    if (filterElement.substring(0, node.length()).equals(node) == true) {
                        //System.out.println(url.length() + "    " + filterElement.length());
                        sitesTree.put(filterElement, node);
                        //System.out.println(sitesTree);
                        //System.out.println(filterElement);
                        //getLinks(filterElement);
                    }
                }
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return sitesTree;
    }

    public TreeMap<String, String> getSitesTree() {
        return sitesTree;
    }

}
