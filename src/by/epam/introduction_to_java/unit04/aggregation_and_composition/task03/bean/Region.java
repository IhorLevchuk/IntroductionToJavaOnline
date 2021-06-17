package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Region implements Serializable {
    @Serial
    private static final long serialVersionUID = -1689323135440373111L;

    private String name;
    private String regionCapitalName;
    private ArrayList<District> districts = new ArrayList<>();
    private double aria;

    public Region(String name, String regionCapitalName) {
        this.name = name;
        this.regionCapitalName = regionCapitalName;
        this.aria = 0;
    }

    public Region() {
    }

    public double getAria() {
        return aria;
    }

    public String getRegionCapitalName() {
        return regionCapitalName;
    }
//    public void addDistrict(District district){
//        this.aria += district.getAria();
//        districts.add(district);
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegionCapitalName(String regionCapitalName) {
        this.regionCapitalName = regionCapitalName;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    public void setAria(double aria) {
        this.aria = aria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.aria, aria) == 0 && Objects.equals(name, region.name) && Objects.equals(regionCapitalName, region.regionCapitalName) && Objects.equals(districts, region.districts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, regionCapitalName, districts, aria);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "][name=" + name +
                "][regionCapitalName='" + regionCapitalName +
                "][districts=" + districts +
                "][aria=" + aria + "]";
    }
}
