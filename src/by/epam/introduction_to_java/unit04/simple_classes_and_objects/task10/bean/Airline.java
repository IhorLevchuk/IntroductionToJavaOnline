package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.bean;



import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.enumeration.DayOfWeek;

import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Airline implements Serializable {
    @Serial
    private static final long serialVersionUID = -8382452053932216534L;

    private String destination;
    private String flightNumber;
    private String planeType;
    private LocalTime departureTime;
    private DayOfWeek[] dayOfWeek;
    static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public Airline(String destination, String flightNumber, String planeType, LocalTime departureTime, DayOfWeek[] dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    public Airline() {
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

    public LocalTime getDepartureTime() {
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

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setDayOfWeek(DayOfWeek[] dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(destination, airline.destination) && Objects.equals(flightNumber, airline.flightNumber) && Objects.equals(planeType, airline.planeType) && Objects.equals(departureTime, airline.departureTime) && Arrays.equals(dayOfWeek, airline.dayOfWeek);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(destination, flightNumber, planeType, departureTime);
        result = 31 * result + Arrays.hashCode(dayOfWeek);
        return result;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", planeType='" + planeType + '\'' +
                ", departureTime=" + departureTime +
                ", dayOfWeek=" + Arrays.toString(dayOfWeek) +
                '}';
    }
}
