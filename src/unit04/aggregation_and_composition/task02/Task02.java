package unit04.aggregation_and_composition.task02;

public class Task02 {
    public static void main(String[] args) {
        /*
        Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля
         */
        Car car = new Car("BMW",4,18,400);
        car.printCarName();
        car.drive();
        car.refuel();
        car.wheelReplacement(1,19);
        car.drive();
        car.wheelReplacement(1,18);
        car.drive();
    }
}
