package unit04.simple_classes_and_objects.task10;

import java.text.ParseException;

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
        airlineBase.addAirline("Paris", "973", "Passenge",
                Airline.format.parse("19:05"), new DayOfWeek[]{DayOfWeek.SATURDAY});
        airlineBase.addAirline("Moscow", "993", "Cargo",
                Airline.format.parse("20:46"), new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
                        DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY});
        airlineBase.addAirline("Brest", "1833", "Passenge",
                Airline.format.parse("20:30"), new DayOfWeek[]{DayOfWeek.FRIDAY,DayOfWeek.MONDAY});
        airlineBase.addAirline("SPB", "776", "Passenge",
                Airline.format.parse("17:55"), new DayOfWeek[]{DayOfWeek.WEDNESDAY});
        airlineBase.addAirline("Brussels", "817", "Passenge",
                Airline.format.parse("13:40"), new DayOfWeek[]{DayOfWeek.WEDNESDAY});
        airlineBase.addAirline("Minsk", "217", "Cargo",
                Airline.format.parse("13:01"), new DayOfWeek[]{DayOfWeek.MONDAY,DayOfWeek.SUNDAY});
        System.out.println("Список рейсов для заданного пункта назначения\n");
        System.out.println(airlineBase.arrayListToString(airlineBase.destinationSearch("Brest")));
        System.out.println("Список рейсов для заданного дня недели\n");
        System.out.println(airlineBase.arrayListToString(airlineBase.daySearch(DayOfWeek.MONDAY)));
        System.out.println("Список рейсов для заданного дня недели, время вылета для которых больше заданного\n");
        System.out.println(airlineBase.arrayListToString(airlineBase.dayAndTimeSearch(DayOfWeek.FRIDAY, Airline.format.parse("19:00"))));
    }
}
