package unit04.aggregation_and_composition.task02;

public class Car {
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

    public void drive(){
        for (int i = 1; i < wheels.length; i++){
            if (wheels[i].getDiameter() != wheels[i-1].getDiameter()){
                System.out.println("Установлены колёса не одинакового диаметра");
                return;
            }
            if (wheels[i].isWorkability() == false){
                System.out.println("Колесо " + i + " нерабочее");
                return;
            }
        }
        if (fuel == false){
            System.out.println("Нет топлива");
            return;
        }
        System.out.println("Машина едет");
    }

    public void printCarName(){
        System.out.println(carName);
    }

    public void wheelReplacement(int wheelNumber, int diameterWheel){
        for(int i = 0; i < wheels.length; i++){
            if(i+1 == wheelNumber){
                wheels[i] = new Wheel(diameterWheel);
            }
        }
        System.out.println("Колесо заменено");
    }

    public void refuel(){
        this.fuel = true;
        System.out.println("Машина заправлена");
    }

}
