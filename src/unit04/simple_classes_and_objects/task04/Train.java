package unit04.simple_classes_and_objects.task04;

import java.time.LocalTime;

public class Train implements Comparable<Train> {
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

    @Override
    public int compareTo(Train o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return "Train: \n" +
                "destination name:" + destinationName + '\n' +
                "number: " + number +
                "\ntime of departure: " + timeOfDeparture + '\n';
    }

}
