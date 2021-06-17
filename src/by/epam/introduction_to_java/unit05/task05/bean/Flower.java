package by.epam.introduction_to_java.unit05.task05.bean;

import by.epam.introduction_to_java.unit05.task05.enumeration.Color;
import by.epam.introduction_to_java.unit05.task05.enumeration.TypeFlower;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Flower implements Serializable {
    @Serial
    private static final long serialVersionUID = -7733689853128052139L;

    public TypeFlower name;
    public Color color;
    public double cost;

    public Flower(TypeFlower name, Color color, double cost) {
        this.name = name;
        this.color = color;
        this.cost = cost;
    }

    public Flower() {
    }

    public Color getColor(){
        return color;
    }

    TypeFlower getName(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.cost, cost) == 0 && Objects.equals(name, flower.name) && Objects.equals(color, flower.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, cost);
    }
}
