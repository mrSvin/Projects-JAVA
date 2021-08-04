import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SAXparserOptimized extends DefaultHandler {

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    //private HashMap<Voter, Integer> voterCounts;
    ArrayList test = new ArrayList();

    public SAXparserOptimized() {
        //voterCounts = new HashMap<>();


    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
                //System.out.println(voter);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
        } else if (qName.equals("visit") && voter != null) {
//            int count = voterCounts.getOrDefault(voter, 0);
//            voterCounts.put(voter, count+1);
            test.add(voter);

        }
    }

    public void printDuplicatedVoters() {
//        for (Voter voter : voterCounts.keySet()) {
//            int count = voterCounts.get(voter);
//            if (count>1) {
//                System.out.println(voter.toString() + " - " + count);
//            }
//        }

        ArrayList repeat = new ArrayList();
        int count = 1;
        for (int i = 0; i < test.size(); i++) {
            boolean boolRepeat=false;
            for (int n=0; n<repeat.size(); n++) {
                if (test.get(i).equals(repeat.get(n)) == true) {
                    boolRepeat =true;
                }
            }

            for (int k = 0; k < test.size(); k++) {
                if (test.get(i).equals(test.get(k)) == true && i != k && boolRepeat == false) {
                    count++;
                    repeat.add(test.get(k));
                    //System.out.println(test.get(i) + " - " + test.get(k) + " - " + count);
                }
            }
            if (count > 1) {
                System.out.println(test.get(i) + " - " + count);
            }
            count = 1;
        }


    }

}
