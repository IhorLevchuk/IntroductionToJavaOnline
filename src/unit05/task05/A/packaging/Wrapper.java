package unit05.task05.A.packaging;

public abstract class Wrapper {
    public String name;
    public String color;
    public double cost;

    Wrapper(String name, String color, double cost) {
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
        return "Wrapper{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                '}';
    }
}
