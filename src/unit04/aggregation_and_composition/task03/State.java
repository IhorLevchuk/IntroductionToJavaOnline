package unit04.aggregation_and_composition.task03;

import java.util.ArrayList;

public class State {
    private String name;
    private String CapitalName;
    private ArrayList<Region> regions = new ArrayList();
    private double aria;

    public State(String name, String capitalName) {
        this.name = name;
        CapitalName = capitalName;
        this.aria = 0;
    }

    public void printAria() {
        System.out.println("Площадь: "+aria);
    }

    public void printCapital(){
        System.out.println("Столица: "+CapitalName);
    }

    public void printNumberOfRegions(){
        System.out.println("Количество областей: "+regions.size());
    }

    public void printRegionCapitalName(){
        StringBuilder str = new StringBuilder("Областные центры:\n");
        for (Region region: regions) {
           str.append(region.getRegionCapitalName()).append("\n");
        }
        System.out.println(str.toString());
    }

    public void addRegion(Region region){
        this.aria += region.getAria();
        regions.add(region);
    }
}
