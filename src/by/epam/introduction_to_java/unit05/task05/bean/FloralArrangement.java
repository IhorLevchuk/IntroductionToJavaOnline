package by.epam.introduction_to_java.unit05.task05.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FloralArrangement implements Serializable {
    @Serial
    private static final long serialVersionUID = -6622668209942593308L;

    private List<Flower> flowers;
    private Wrapper wrapper;

    public FloralArrangement() {
        this.flowers = new ArrayList<>();
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String toString() {
        return "FloralArrangement{" +
                "flowers=" + flowers +
                ", wrapper=" + wrapper +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloralArrangement that = (FloralArrangement) o;
        return Objects.equals(flowers, that.flowers) && Objects.equals(wrapper, that.wrapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowers, wrapper);
    }
}
