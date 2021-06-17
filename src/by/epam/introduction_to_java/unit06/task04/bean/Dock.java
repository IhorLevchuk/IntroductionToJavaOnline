package by.epam.introduction_to_java.unit06.task04.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Dock implements Serializable {
    @Serial
    private static final long serialVersionUID = 2841775285276810558L;

    private int number;

    public Dock(int number) {
        this.number = number;
    }

    public Dock() {
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dock dock = (Dock) o;
        return number == dock.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Dock{" +
                "number=" + number +
                '}';
    }
}
