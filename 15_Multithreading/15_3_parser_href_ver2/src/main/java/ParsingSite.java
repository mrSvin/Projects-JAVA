import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ParsingSite extends RecursiveTask<ArrayList<String>> {

    private Node node;


    public ParsingSite(Node node) {
        this.node = node;
    }

    @Override
    protected ArrayList<String> compute() {
        ArrayList<String> links = new ArrayList<>();
        links.addAll(node.getChildren());
        List<ParsingSite> taskList = new ArrayList<>();

        for (String link : node.getChildren()) {
            HTMLParser parser = null;
            try {
                parser = new HTMLParser(link);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ParsingSite parsingSite = new ParsingSite((Node) parser);
            parsingSite.fork();
        }
        for (ParsingSite parsingSite : taskList) {
            parsingSite.join();
        }


        return links;
    }


}
