package unit04.simple_classes_and_objects.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class AirlineBase {
    ArrayList<Airline> airlineArrayList;

    public AirlineBase(ArrayList<Airline> airlineArrayList) {
        this.airlineArrayList = airlineArrayList;
    }

    public AirlineBase() {
        this.airlineArrayList = new ArrayList<>();
    }

    public void addAirline(String destination, String flightNumber, String planeType, Date departureTime, DayOfWeek[] dayOfWeek){
        airlineArrayList.add(new Airline(destination, flightNumber, planeType, departureTime, dayOfWeek));
    }

    public ArrayList<Airline> getAirlineArrayList() {
        return airlineArrayList;
    }

    public String arrayListToString(ArrayList<Airline> list){
        StringBuilder string = new StringBuilder();
        for(Airline airline: list){
            string.append(airline).append("\n");
        }
        return string.toString();
    }

    public ArrayList<Airline> destinationSearch(String destination){
        ArrayList<Airline> airlines;
        airlines = (ArrayList<Airline>) airlineArrayList.stream().filter(airline -> airline.getDestination().equals(destination)).collect(Collectors.toList());
        return airlines;
    }

    public ArrayList<Airline> daySearch(DayOfWeek days){
        ArrayList<Airline> airlines;
        airlines = (ArrayList<Airline>) airlineArrayList.stream()
                .filter(airline -> Arrays.stream(airline.getDayOfWeek()).filter(dayOfWeek -> dayOfWeek.equals(days)).count() != 0)
                .collect(Collectors.toList());
        return airlines;
    }
    public ArrayList<Airline> dayAndTimeSearch(DayOfWeek days, Date time){
        ArrayList<Airline> airlines;
        airlines = (ArrayList<Airline>) airlineArrayList.stream()
                .filter(airline -> Arrays.stream(airline.getDayOfWeek()).filter(dayOfWeek -> dayOfWeek.equals(days)).count() != 0)
                .filter(airline -> airline.getDepartureTime().after(time))
                .collect(Collectors.toList());
        return airlines;
    }
}
