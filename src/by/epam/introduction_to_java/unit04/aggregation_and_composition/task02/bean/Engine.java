package by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Engine implements Serializable {
    @Serial
    private static final long serialVersionUID = -1804014513516443349L;

    private int power;

    public Engine() {
    }

    public Engine(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return power == engine.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[power=" + power + "]";
    }
}
