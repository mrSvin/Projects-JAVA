import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.RecursiveTask;

public class ParsingSite extends RecursiveTask<List<String>> {

    private final String node;

    //private String url = "http://www.lenta.ru/";
    String filterElement = "";

    private List<String> sitesTree = new LinkedList<>();
    private String lastNode = "";
    private String tab = "     ";

    public ParsingSite(String node) {
        this.node = node;
    }

    private int test = 0;


    @Override
    protected List<String> compute() {

        try {
            //System.out.println("Количество потоков: " + java.lang.Thread.activeCount());
            Thread.sleep(150);
            Document doc = Jsoup.connect(node).timeout(60000).get();
            Elements elements = doc.select("a");
            for (Element element : elements) {
                if (element.absUrl("href").length() > node.length()) {
                    filterElement = element.absUrl("href");
                    int findSymbol = filterElement.indexOf("#");
                    int findPdf = filterElement.indexOf(".pdf");
                    if (filterElement.substring(0, node.length()).equals(node) == true && findSymbol == (-1) && findPdf == (-1)) {
                        sitesTree.add(filterElement);
                    }
                }
            }

            List<ParsingSite> subTasks = new LinkedList<>();

            for (String child : sitesTree) {
                //System.out.println(node);
                //System.out.println(test + "    " + child);
                ParsingSite task = new ParsingSite(child);
                task.fork(); // запустим асинхронно
                subTasks.add(task);
                test++;
                if (node.equals(lastNode) == true) {
                    Main.fr.write(tab + child + "\n");
                    System.out.println(tab + child + "\n");
                } else {
                    Main.fr.write(node + "\n" + tab + child + "\n");
                    System.out.println(node + "\n" + tab + child + "\n");
                    lastNode = node;
                }

            }

            for (ParsingSite task : subTasks) {
                task.join(); // дождёмся выполнения задачи и прибавим результат
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(sitesTree);
        return sitesTree;
    }

    public List<String> getSitesTree() {
        return sitesTree;
    }

}
