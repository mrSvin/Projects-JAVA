import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collection;

public class HTMLParser implements Node {

    String filterElement = "";

    public HTMLParser(String link) throws InterruptedException, IOException {
        Thread.sleep(150);
        Document doc = Jsoup.connect(String.valueOf(link)).get();
        Elements elements = doc.select("a");
        for (Element element : elements) {
            if (element.absUrl("href").length() > String.valueOf(link).length()) {
                filterElement = element.absUrl("href");
                //System.out.println(filterElement.substring(0, url.length()));
                if (filterElement.substring(0, String.valueOf(link).length()).equals(link) == true) {
                   // sitesTree.put(filterElement, node);
                    System.out.println(filterElement);

                }
            }
        }
    }


    @Override
    public Collection<? extends String> getChildren() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}
