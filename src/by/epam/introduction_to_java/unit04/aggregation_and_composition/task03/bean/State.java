package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class State implements Serializable {
    @Serial
    private static final long serialVersionUID = 3110712669329585263L;

    private String name;
    private String CapitalName;
    private ArrayList<Region> regions = new ArrayList();
    private double aria;

    public State(String name, String capitalName) {
        this.name = name;
        CapitalName = capitalName;
        this.aria = 0;
    }

    public State() {
    }

//    public void printAria() {
//        System.out.println("Площадь: "+aria);
//    }
//
//    public void printCapital(){
//        System.out.println("Столица: "+CapitalName);
//    }
//
//    public void printNumberOfRegions(){
//        System.out.println("Количество областей: "+regions.size());
//    }
//
//    public void printRegionCapitalName(){
//        StringBuilder str = new StringBuilder("Областные центры:\n");
//        for (Region region: regions) {
//           str.append(region.getRegionCapitalName()).append("\n");
//        }
//        System.out.println(str.toString());
//    }

//    public void addRegion(Region region){
//        this.aria += region.getAria();
//        regions.add(region);
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalName() {
        return CapitalName;
    }

    public void setCapitalName(String capitalName) {
        CapitalName = capitalName;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    public double getAria() {
        return aria;
    }

    public void setAria(double aria) {
        this.aria = aria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Double.compare(state.aria, aria) == 0 && Objects.equals(name, state.name) && Objects.equals(CapitalName, state.CapitalName) && Objects.equals(regions, state.regions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, CapitalName, regions, aria);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[name='" + name +
                "][CapitalName=" + CapitalName +
                "][regions=" + regions +
                "][aria=" + aria + "]";
    }
}
