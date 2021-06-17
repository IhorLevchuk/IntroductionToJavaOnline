package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.view;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.bean.Airline;

import java.util.List;

public class AirlineView {
    public void printAirlines(List<Airline> list){
        StringBuilder string = new StringBuilder();
        for(Airline airline: list){
            string.append(airline).append("\n");
        }
        System.out.println(string);
    }
}
