package by.epam.introduction_to_java.unit05.task05.bean;

import by.epam.introduction_to_java.unit05.task05.enumeration.Color;
import by.epam.introduction_to_java.unit05.task05.enumeration.TypeWrapper;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Wrapper implements Serializable {
    @Serial
    private static final long serialVersionUID = -4724376562320197320L;

    public TypeWrapper name;
    public Color color;
    public double cost;

    public Wrapper(TypeWrapper name, Color color, double cost) {
        this.name = name;
        this.color = color;
        this.cost = cost;
    }

    public Wrapper() {
    }

    public Color getColor(){
        return color;
    }

    TypeWrapper getName(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapper wrapper = (Wrapper) o;
        return Double.compare(wrapper.cost, cost) == 0 && Objects.equals(name, wrapper.name) && Objects.equals(color, wrapper.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, cost);
    }
}
