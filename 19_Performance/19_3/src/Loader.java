import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Loader {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {

        String fileName = "res/data-1572M.xml";   //1572M

        long start = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXparser handler = new SAXparser();
        parser.parse(new File(fileName), handler);




        //parseFile(fileName);
        //DBConnection.printVoterCounts();

        System.out.println("Time " + (System.currentTimeMillis() - start) + " ms");

    }

//    private static void parseFile(String fileName) throws Exception {
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(new File(fileName));
//
//        findEqualVoters(doc);
//        fixWorkTimes(doc);
//    }

//    private static void findEqualVoters(Document doc) throws Exception {
//        NodeList voters = doc.getElementsByTagName("voter");
//        int votersCount = voters.getLength();
////        int diviveRequest = 75;
////        int requestBegin = 0;
////        int requestEnd = 0;
////        for (int k = 0; k < diviveRequest; k++) {
////            requestEnd = requestEnd + votersCount / diviveRequest;
////            System.out.println(requestEnd);
//            for (int i = 0; i < votersCount; i++) { //int i = requestBegin; i < requestEnd; i++)
////                requestBegin = requestEnd;
//                //System.out.println(i);
//                Node node = voters.item(i);
//                NamedNodeMap attributes = node.getAttributes();
//
//                String name = attributes.getNamedItem("name").getNodeValue();
//                String birthday = attributes.getNamedItem("birthDay").getNodeValue();
//
//                DBConnection.countVoter(name, birthday);
//
//            }
//            DBConnection.executeMultiInsert();
////        }
//    }

//    private static void fixWorkTimes(Document doc) throws Exception {
//        NodeList visits = doc.getElementsByTagName("visit");
//        int visitCount = visits.getLength();
//        for (int i = 0; i < visitCount; i++) {
//            Node node = visits.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
//            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
//            WorkTime workTime = voteStationWorkTimes.get(station);
//            if (workTime == null) {
//                workTime = new WorkTime();
//                voteStationWorkTimes.put(station, workTime);
//            }
//            workTime.addVisitTime(time.getTime());
//        }
//    }
}