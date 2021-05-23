package unit04.simple_classes_and_objects.task10;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Airline {
    private String destination;
    private String flightNumber;
    private String planeType;
    private Date departureTime;
    private DayOfWeek [] dayOfWeek;
    static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public Airline(String destination, String flightNumber, String planeType, Date departureTime, DayOfWeek[] dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Airline: " + '\n' +
                "Destination: " + destination + '\n' +
                "Flight number:" + flightNumber + '\n' +
                "Plane type:" + planeType + '\n' +
                "Departure time: " + format.format(departureTime) + '\n' +
                "Day of week: " + Arrays.toString(dayOfWeek) + '\n';
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPlaneType() {
        return planeType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public DayOfWeek[] getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setDayOfWeek(DayOfWeek[] dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
