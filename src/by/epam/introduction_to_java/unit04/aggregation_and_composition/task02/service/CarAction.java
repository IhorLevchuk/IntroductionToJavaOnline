package by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.service;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.bean.Car;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.bean.Wheel;

public class CarAction {

    public static String drive(Car car){
        String massage;
        for (int i = 1; i < car.getWheels().length; i++){
            if ( car.getWheels()[i].getDiameter() !=  car.getWheels()[i-1].getDiameter()){
                massage = "Установлены колёса не одинакового диаметра";
                return massage;
            }
            if (!car.getWheels()[i].isWorkability()){
                massage = "Колесо " + i + " нерабочее";
                return massage;
            }
        }
        if (!car.isFuel()){
            massage = "Нет топлива";
            return massage;
        }
        massage = "Машина едет";
        return massage;
    }

    public static String wheelReplacement(Car car, int wheelNumber, int diameterWheel){
        for(int i = 0; i < car.getWheels().length; i++){
            if(i+1 == wheelNumber){
                car.getWheels()[i] = new Wheel(diameterWheel);
            }
        }
        return "Колесо заменено";
    }

    public static String refuel(Car car){
        car.setFuel(true);
        return "Машина заправлена";
    }
}
