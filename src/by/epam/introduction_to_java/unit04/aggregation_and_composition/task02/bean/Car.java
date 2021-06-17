package by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = -7685070715790113608L;

    private String carName;
    private Wheel[] wheels;
    private Engine engine;
    private boolean fuel;

    public Car(String carName,int numberOfWheels,  int diameterWheel, int powerEngine){
        this.carName = carName;
        this.wheels = new Wheel[numberOfWheels];
        for (int i = 0; i < this.wheels.length; i++){
            wheels[i] = new Wheel(diameterWheel);
        }
        this.engine = new Engine(powerEngine);
        this.fuel = false;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public boolean isFuel() {
        return fuel;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return fuel == car.fuel && Objects.equals(carName, car.carName) && Arrays.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(carName, engine, fuel);
        result = 31 * result + Arrays.hashCode(wheels);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[carName=" + carName +
                "][wheels=" + Arrays.toString(wheels) +
                "][engine=" + engine +
                "][fuel=" + fuel + "]";
    }
}
