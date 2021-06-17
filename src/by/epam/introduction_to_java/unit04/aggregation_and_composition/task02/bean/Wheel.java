package by.epam.introduction_to_java.unit04.aggregation_and_composition.task02.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Wheel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1916752751844799750L;

    private int diameter;
    private boolean workability;

    public int getDiameter() {
        return diameter;
    }

    public Wheel() {
    }

    public Wheel(int diameter) {
        this.diameter = diameter;
        this.workability = true;
    }

    public boolean isWorkability() {
        return workability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return diameter == wheel.diameter && workability == wheel.workability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter, workability);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[diameter=" + diameter +
                "][workability=" + workability + "]";
    }
}
