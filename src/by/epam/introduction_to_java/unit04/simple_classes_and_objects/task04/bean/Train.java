package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task04.bean;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Train implements Comparable<Train>, Serializable {
    @Serial
    private static final long serialVersionUID = 4615342751058136054L;

    private String destinationName;
    private int number;
    private LocalTime timeOfDeparture;

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public int getNumber() {
        return number;
    }

    public Train(String destinationName, int number,  LocalTime timeOfDeparture) {
        this.destinationName = destinationName;
        this.number = number;
        this.timeOfDeparture = timeOfDeparture;
    }

    public Train() {
    }

    @Override
    public int compareTo(Train o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return number == train.number && Objects.equals(destinationName, train.destinationName) && Objects.equals(timeOfDeparture, train.timeOfDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationName, number, timeOfDeparture);
    }

    @Override
    public String toString() {
        return "Train{" +
                "destinationName='" + destinationName + '\'' +
                ", number=" + number +
                ", timeOfDeparture=" + timeOfDeparture +
                '}';
    }
}
