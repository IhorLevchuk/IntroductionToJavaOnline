package unit04.aggregation_and_composition.task02;

public class Wheel {
    public int getDiameter() {
        return diameter;
    }

    private int diameter;
    private boolean workability;

    public Wheel(int diameter) {
        this.diameter = diameter;
        this.workability = true;
    }

    public boolean isWorkability() {
        return workability;
    }
}
