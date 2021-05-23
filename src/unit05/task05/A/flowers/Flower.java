package unit05.task05.A.flowers;

public abstract class Flower {
    public String name;
    public String color;
    public double cost;

    Flower(String name, String color, double cost) {
        this.name = name;
        this.color = color;
        this.cost = cost;
    }

    public String getColor(){
        return color;
    }

    String getName(){
        return name;
    }

    double getCost(){
        return cost;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                '}';
    }
}
