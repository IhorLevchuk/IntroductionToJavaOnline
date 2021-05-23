package unit04.aggregation_and_composition.task03;

import java.util.ArrayList;

public class Region {
    private String name;
    private String regionCapitalName;
    private ArrayList<District> districts = new ArrayList<>();
    private double aria;

    public Region(String name, String regionCapitalName) {
        this.name = name;
        this.regionCapitalName = regionCapitalName;
        this.aria = 0;
    }

    public double getAria() {
        return aria;
    }

    public String getRegionCapitalName() {
        return regionCapitalName;
    }
    public void addDistrict(District district){
        this.aria += district.getAria();
        districts.add(district);
    }
}
