package by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.main;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.bean.Car;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.service.CarAction;

public class Task02 {
    public static void main(String[] args) {
        /*
        Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля
         */
        Car car = new Car("BMW",4,18,400);

        System.out.println(CarAction.drive(car));
        System.out.println(CarAction.refuel(car));
        System.out.println(CarAction.wheelReplacement(car,1,19));
        System.out.println(CarAction.drive(car));
        System.out.println(CarAction.wheelReplacement(car,1,18));
        System.out.println(CarAction.drive(car));
    }
}
