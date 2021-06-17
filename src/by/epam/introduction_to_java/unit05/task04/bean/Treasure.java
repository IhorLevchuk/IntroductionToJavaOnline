package by.epam.introduction_to_java.unit05.task04.bean;

import by.epam.introduction_to_java.unit05.task04.enumeration.TreasureMaterial;
import by.epam.introduction_to_java.unit05.task04.enumeration.TypeTreasure;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Treasure implements Serializable {
    @Serial
    private static final long serialVersionUID = 6657980499449438520L;

    private TypeTreasure typeTreasure;
    private TreasureMaterial treasureMaterial;
    private int cost;
    private int id;

    public Treasure(TypeTreasure typeTreasure, TreasureMaterial treasureMaterial, int cost, int id) {
        this.typeTreasure = typeTreasure;
        this.treasureMaterial = treasureMaterial;
        this.cost = cost;
        this.id = id;
    }

    public Treasure() {
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return cost == treasure.cost && id == treasure.id && typeTreasure == treasure.typeTreasure && treasureMaterial == treasure.treasureMaterial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeTreasure, treasureMaterial, cost, id);
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "typeTreasure=" + typeTreasure +
                ", treasureMaterial=" + treasureMaterial +
                ", cost=" + cost +
                ", id=" + id +
                '}';
    }
}

