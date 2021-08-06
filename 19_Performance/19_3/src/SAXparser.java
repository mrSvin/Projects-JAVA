import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SAXparser extends DefaultHandler {

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private HashMap<Voter, Integer> voterCounts;

    public SAXparser() {
        voterCounts = new HashMap<>();
    }

    int limit = 1_000_000;
    int number = 0;
    int k = 0;
    int count =0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("voter") ) {   //&& number < limit
            String name = attributes.getValue("name");
            String birthDate = attributes.getValue("birthDay");
            try {
                DBConnection.countVoter(name, birthDate);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            //number++;
            count++;
            if (count > 100000) {
                k++;
                System.out.println(k);
                count = 0;
            }
        }

    }

//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if (qName.equals("voter")) {
//            voter = null;
//        } else if (qName.equals("visit") && voter != null) {
//        int count = voterCounts.getOrDefault(voter, 0);
//        voterCounts.put(voter, count+1);
//        }
//    }

    public void printDuplicatedVoters() {
        for (Voter voter : voterCounts.keySet()) {
            int count = voterCounts.get(voter);
            if (count > 1) {
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }

}
