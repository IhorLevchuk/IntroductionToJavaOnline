package by.epam.introduction_to_java.unit06.task04.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Container implements Serializable {
    @Serial
    private static final long serialVersionUID = -128425659796357961L;

    private String id;

    public Container(String id) {
        this.id = id;
    }

    public Container() {
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                '}';
    }
}
