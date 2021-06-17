package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {
    @Serial
    private static final long serialVersionUID = -4250699272502181682L;

    private String name;

    public City(String name) {
        this.name = name;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[name='" + name + "]";
    }
}
