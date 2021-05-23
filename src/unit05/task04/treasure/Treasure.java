package unit05.task04.treasure;

public class Treasure {
    private final TypeTreasure typeTreasure;
    private final TreasureMaterial treasureMaterial;
    private int cost;
    private final int id;

    public Treasure(TypeTreasure typeTreasure, TreasureMaterial treasureMaterial, int cost, int id) {
        this.typeTreasure = typeTreasure;
        this.treasureMaterial = treasureMaterial;
        this.cost = cost;
        this.id = id;
    }

    @Override
    public String toString() {
        return  id + ". Type: " + typeTreasure + "; Material: " + treasureMaterial + "; Coast: " + cost;
    }


    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }
}
