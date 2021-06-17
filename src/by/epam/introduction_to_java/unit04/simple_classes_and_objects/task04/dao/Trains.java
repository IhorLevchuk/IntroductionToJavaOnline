package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task04.dao;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task04.bean.Train;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task04.comparator.DestinationNameComparator;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trains {
    ArrayList<Train> trains = new ArrayList<>();
    public Trains(){
        trains.add(new Train("Минск", 457, LocalTime.of(13,30)));
        trains.add(new Train("Минск", 257, LocalTime.of(15,30)));
        trains.add(new Train("Брест", 247, LocalTime.of(13,30)));
        trains.add(new Train("Витебск", 457, LocalTime.of(18,30)));
        trains.add(new Train("Кобрин", 985, LocalTime.of(19,30)));
    }

    public ArrayList<Train> sortingByNumber(){
        ArrayList<Train> sortTrains = new ArrayList<>(trains);
        sortTrains.sort(Train::compareTo);
        return sortTrains;
    }

    public List<Train> informationOfTrain(int number){
        return trains.stream().filter(t -> t.getNumber() == number).collect(Collectors.toList());
    }

    public ArrayList<Train> sortingByDestinationName(){
        ArrayList<Train> sortTrains = new ArrayList<>(trains);
        sortTrains.sort(new DestinationNameComparator());
        return sortTrains;
    }
}
