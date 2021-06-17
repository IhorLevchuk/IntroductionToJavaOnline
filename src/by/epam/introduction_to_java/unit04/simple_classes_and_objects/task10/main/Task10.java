package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.main;


import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.bean.Airline;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.dao.AirlineBase;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.enumeration.DayOfWeek;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task10.view.AirlineView;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Task10 {
    public static void main(String[] args) throws ParseException {
        /*
        Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
         */

        AirlineBase airlineBase = new AirlineBase();
        AirlineView airlineView = new AirlineView();

        airlineBase.addAirline("Paris", "973", "Passenge",
                LocalTime.of(19,20), new DayOfWeek[]{DayOfWeek.SATURDAY});
        airlineBase.addAirline("Moscow", "993", "Cargo",
                LocalTime.of(20,46), new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
                        DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY});
        airlineBase.addAirline("Brest", "1833", "Passenge",
                LocalTime.of(20,30), new DayOfWeek[]{DayOfWeek.FRIDAY,DayOfWeek.MONDAY});
        airlineBase.addAirline("SPB", "776", "Passenge",
                LocalTime.of(19,24), new DayOfWeek[]{DayOfWeek.WEDNESDAY});
        airlineBase.addAirline("Brussels", "817", "Passenge",
                LocalTime.of(13,40), new DayOfWeek[]{DayOfWeek.WEDNESDAY});
        airlineBase.addAirline("Minsk", "217", "Cargo",
                LocalTime.of(13,01), new DayOfWeek[]{DayOfWeek.MONDAY,DayOfWeek.SUNDAY});
        System.out.println("Список рейсов для заданного пункта назначения\n");
        airlineView.printAirlines(airlineBase.destinationSearch("Brest"));
        System.out.println("Список рейсов для заданного дня недели\n");
        airlineView.printAirlines(airlineBase.daySearch(DayOfWeek.MONDAY));
        System.out.println("Список рейсов для заданного дня недели, время вылета для которых больше заданного\n");
        airlineView.printAirlines(airlineBase.dayAndTimeSearch(DayOfWeek.WEDNESDAY, LocalTime.of(19,24)));
    }
}
