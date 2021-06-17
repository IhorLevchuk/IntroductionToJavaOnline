package by.epam.introduction_to_java.unit05.task04.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaveDragon implements Serializable {
    @Serial
    private static final long serialVersionUID = 5399886819071480578L;

    private List<Treasure> treasures;

    public CaveDragon() {
        this.treasures = new ArrayList<>();
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaveDragon that = (CaveDragon) o;
        return Objects.equals(treasures, that.treasures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treasures);
    }

    @Override
    public String toString() {
        return "CaveDragon{" +
                "treasureArrayList=" + treasures +
                '}';
    }
}
