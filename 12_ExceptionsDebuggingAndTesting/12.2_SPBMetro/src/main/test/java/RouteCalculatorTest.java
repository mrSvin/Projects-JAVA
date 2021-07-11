import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    private RouteCalculator routeCalculator;
    private static StationIndex stationIndex;
    private static final String DATA_FILE = "src/main/resources/map.json";

    //Добавление данных
    @Override

    protected void setUp() throws Exception {
        route = new ArrayList<>();

        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");

        route.add(new Station("Петровская", line1));
        route.add(new Station("Арбузная", line1));
        route.add(new Station("Морковная", line2));
        route.add(new Station("Яблочная", line2));

    }


    public void testcaltulateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }


    public void testOneLine() {

        createStationIndex();
        Station from = stationIndex.getStation("Парнас");
        Station to = stationIndex.getStation("Озерки");
        //System.out.println("от " + from + " до " + to);
        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        //System.out.println(" sd " + actual);
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Парнас"));
        expected.add(stationIndex.getStation("Проспект Просвещения"));
        expected.add(stationIndex.getStation("Озерки"));
        //System.out.println("Проверка " + expected);
        assertEquals(expected, actual);
    }

    public void testTwoLine() {
        createStationIndex();
        Station from = stationIndex.getStation("Девяткино");
        Station to = stationIndex.getStation("Гостиный двор");

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        //System.out.println(" sd " + actual);
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Девяткино"));
        expected.add(stationIndex.getStation("Гражданский проспект"));
        expected.add(stationIndex.getStation("Академическая"));
        expected.add(stationIndex.getStation("Политехническая"));
        expected.add(stationIndex.getStation("Площадь Мужества"));
        expected.add(stationIndex.getStation("Лесная"));
        expected.add(stationIndex.getStation("Выборгская"));
        expected.add(stationIndex.getStation("Площадь Ленина"));
        expected.add(stationIndex.getStation("Чернышевская"));
        expected.add(stationIndex.getStation("Площадь Восстания"));
        expected.add(stationIndex.getStation("Маяковская"));
        expected.add(stationIndex.getStation("Гостиный двор"));
        //System.out.println("Проверка " + expected);
        assertEquals(expected, actual);
    }

    public void testThreeLine() {
        createStationIndex();
        Station from = stationIndex.getStation("Чернышевская");
        Station to = stationIndex.getStation("Горьковская");

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        //System.out.println(" sd " + actual);
        List<Station> expected = new ArrayList<>();

        expected.add(stationIndex.getStation("Чернышевская"));
        expected.add(stationIndex.getStation("Площадь Восстания"));
        expected.add(stationIndex.getStation("Маяковская"));
        expected.add(stationIndex.getStation("Гостиный двор"));
        expected.add(stationIndex.getStation("Невский проспект"));
        expected.add(stationIndex.getStation("Горьковская"));

    }

    private static void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            parseConnections(connectionsArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseStations(JSONObject stationsObject) {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            int lineNumber = Integer.parseInt((String) lineNumberObject);
            Line line = stationIndex.getLine(lineNumber);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                Station station = new Station((String) stationObject, line);
                stationIndex.addStation(station);
                line.addStation(station);
            });
        });
    }

    private static void parseConnections(JSONArray connectionsArray) {
        connectionsArray.forEach(connectionObject ->
        {
            JSONArray connection = (JSONArray) connectionObject;
            List<Station> connectionStations = new ArrayList<>();
            connection.forEach(item ->
            {
                JSONObject itemObject = (JSONObject) item;
                int lineNumber = ((Long) itemObject.get("line")).intValue();
                String stationName = (String) itemObject.get("station");

                Station station = stationIndex.getStation(stationName, lineNumber);
                if (station == null) {
                    throw new IllegalArgumentException("core.Station " +
                            stationName + " on line " + lineNumber + " not found");
                }
                connectionStations.add(station);
            });
            stationIndex.addConnection(connectionStations);
        });
    }


    private static void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    ((Long) lineJsonObject.get("number")).intValue(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }


    //Удаление данных
    @Override
    protected void tearDown() throws Exception {

    }


}
