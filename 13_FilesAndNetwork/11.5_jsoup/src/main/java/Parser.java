import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Parser {
    private List<String> stationLine1 = new ArrayList<>();
    private List<String> stationLine2 = new ArrayList<>();
    private List<String> stationLine3 = new ArrayList<>();
    private List<String> stationLine4 = new ArrayList<>();
    private List<String> stationLine5 = new ArrayList<>();
    private List<String> stationLine6 = new ArrayList<>();
    private List<String> stationLine7 = new ArrayList<>();
    private List<String> stationLine8 = new ArrayList<>();
    private List<String> stationLine9 = new ArrayList<>();
    private List<String> stationLine10 = new ArrayList<>();
    private List<String> stationLine11 = new ArrayList<>();
    private List<String> stationLine12 = new ArrayList<>();
    private List<String> stationLine13 = new ArrayList<>();
    private List<String> stationLine14 = new ArrayList<>();
    private List<String> stationLine15 = new ArrayList<>();
    private List<String> stationLine16 = new ArrayList<>();
    private List<String> stationLine17 = new ArrayList<>();

    //private List<List> connections = new ArrayList<>();
    private Map<Integer, List> connectionsMap = new HashMap();

    private List<List> stations = new ArrayList<>();
    private Map<Integer, List> stationsMap = new HashMap();
    private int size = 0;


    public Parser ParserHtml() {  //Parser
        try {
            newArray();

            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").timeout(40000).maxBodySize(0).get();
            //Собираем линнии и станции
            for (int k = 0; k < 17; k++) {
                Element line = doc.getElementsByClass("js-metro-stations t-metrostation-list-table").get(k);
                Elements span = line.getElementsByClass("name");

                for (int i = 0; i < span.size(); i++) {
                    stations.get(k).add(span.get(i).text());
                }
                stationsMap.put(k + 1, stations.get(k));
                System.out.println(stations.get(k));
            }
            //Ищем количество соединений
            for (int k = 0; k < 17; k++) {
                Element line = doc.getElementsByClass("js-metro-stations t-metrostation-list-table").get(k);
                Elements line1 = line.getElementsByClass("t-icon-metroln ln-1");
                Elements line2 = line.getElementsByClass("t-icon-metroln ln-2");
                Elements line3 = line.getElementsByClass("t-icon-metroln ln-3");
                Elements line4 = line.getElementsByClass("t-icon-metroln ln-4");
                Elements line5 = line.getElementsByClass("t-icon-metroln ln-5");
                Elements line6 = line.getElementsByClass("t-icon-metroln ln-6");
                Elements line7 = line.getElementsByClass("t-icon-metroln ln-7");
                Elements line8 = line.getElementsByClass("t-icon-metroln ln-8");
                Elements line9 = line.getElementsByClass("t-icon-metroln ln-9");
                Elements line10 = line.getElementsByClass("t-icon-metroln ln-10");
                Elements line11 = line.getElementsByClass("t-icon-metroln ln-11");
                Elements line12 = line.getElementsByClass("t-icon-metroln ln-12");
                Elements line13 = line.getElementsByClass("t-icon-metroln ln-13");
                Elements line14 = line.getElementsByClass("t-icon-metroln ln-14");
                Elements line15 = line.getElementsByClass("t-icon-metroln ln-15");
                Elements line16 = line.getElementsByClass("t-icon-metroln ln-D1");
                Elements line17 = line.getElementsByClass("t-icon-metroln ln-D2");
//                for (int i = 0; i < span.size(); i++) {
//                    connections.get(k).add(span.get(i).text());
//                }

                size = size + line1.size() + line2.size() + line3.size() + line4.size() + line5.size() + line6.size() + line7.size() + line8.size() +
                        line9.size() + line10.size() + line11.size() + line12.size() + line13.size() + line14.size() + line15.size() + line16.size() + line17.size();
                //System.out.println(line1.size());
                //System.out.println(size);
            }
            System.out.println("Количество переходов: " + size);

            // Собираем соединения станций
            newArray();

            String[] tags  = new String[] {"t-icon-metroln ln-1", "t-icon-metroln ln-2", "t-icon-metroln ln-3", "t-icon-metroln ln-4", "t-icon-metroln ln-5",
                    "t-icon-metroln ln-6", "t-icon-metroln ln-7", "t-icon-metroln ln-8", "t-icon-metroln ln-9", "t-icon-metroln ln-10",
                    "t-icon-metroln ln-11", "t-icon-metroln ln-12", "t-icon-metroln ln-13", "t-icon-metroln ln-14", "t-icon-metroln ln-15",
                    "t-icon-metroln ln-D1", "t-icon-metroln ln-D2"};

            for (int k = 0; k <17; k++) {
                Elements station = doc.getElementsByClass(tags[k]);
                for (int i = 0; i < station.size(); i++) {
                    String originalTitle = station.get(i).attr("title");
                    int beginName = originalTitle.indexOf("«") + 1;
                    int endName = originalTitle.indexOf("»");

                    String connectStation = originalTitle.substring(beginName, endName);
                    stations.get(k).add(connectStation);
                    //System.out.println(connectStation);
                    //     }
                    connectionsMap.put(k + 1, stations.get(k));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Parser parser = new Parser();
        return parser;
    }

    private void newArray() {

        stations = new ArrayList<>();
        stationLine1 = new ArrayList<>();
        stationLine2 = new ArrayList<>();
        stationLine3 = new ArrayList<>();
        stationLine4 = new ArrayList<>();
        stationLine5 = new ArrayList<>();
        stationLine6 = new ArrayList<>();
        stationLine7 = new ArrayList<>();
        stationLine8 = new ArrayList<>();
        stationLine9 = new ArrayList<>();
        stationLine10 = new ArrayList<>();
        stationLine11 = new ArrayList<>();
        stationLine12 = new ArrayList<>();
        stationLine13 = new ArrayList<>();
        stationLine14 = new ArrayList<>();
        stationLine15 = new ArrayList<>();
        stationLine16 = new ArrayList<>();
        stationLine17 = new ArrayList<>();
        stations.add(stationLine1);
        stations.add(stationLine2);
        stations.add(stationLine3);
        stations.add(stationLine4);
        stations.add(stationLine5);
        stations.add(stationLine6);
        stations.add(stationLine7);
        stations.add(stationLine8);
        stations.add(stationLine9);
        stations.add(stationLine10);
        stations.add(stationLine11);
        stations.add(stationLine12);
        stations.add(stationLine13);
        stations.add(stationLine14);
        stations.add(stationLine15);
        stations.add(stationLine16);
        stations.add(stationLine17);
    }

    public Map<Integer, List> getStationsMap() {
        return stationsMap;
    }

    public Map<Integer, List> getConnectionsMap() {
        return connectionsMap;
    }

}
