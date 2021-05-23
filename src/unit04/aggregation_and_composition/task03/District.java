package unit04.aggregation_and_composition.task03;

import java.util.ArrayList;

public class District {
    private String name;
    private String districtCapitalName;
    private ArrayList<City> cities = new ArrayList<>();
    private double aria;

    public District(String name,double aria, String districtCapitalName) {
        this.name = name;
        this.aria = aria;
        this.districtCapitalName = districtCapitalName;
    }

    public double getAria() {
        return aria;
    }

    public void addCity(City city){
        cities.add(city);
    }
}
