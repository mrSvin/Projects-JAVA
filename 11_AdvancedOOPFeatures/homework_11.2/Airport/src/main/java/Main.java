import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static long twoHours = 3600*2*1000;
    public static long currentTime = new Date().getTime();

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        List<Flight> flights = findPlanesLeavingInTheNextTwoHours(airport);
        System.out.println(flights);

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.

        return airport.getTerminals()
                .stream()
                //Преобразовываем в getFlights
                .map(Terminal::getFlights)
                //Собираем все элементы в коллекцию
                .flatMap(Collection::stream)
                //фильтруем только вылетацющие сообщения
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                //фильтуем даты с текущего времени до +2ч
                .filter(flight -> flight.getDate().getTime() >= currentTime
                        && flight.getDate().getTime() < currentTime + twoHours)
                //собираем и возвращаем полученный List
                .collect(Collectors.toList());
    }

}