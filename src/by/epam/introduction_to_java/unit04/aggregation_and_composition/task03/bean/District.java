package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class District implements Serializable {
    @Serial
    private static final long serialVersionUID = -5629876473610923306L;

    private String name;
    private String districtCapitalName;
    private List<City> cities = new ArrayList<>();
    private double aria;

    public District(String name,double aria, String districtCapitalName) {
        this.name = name;
        this.aria = aria;
        this.districtCapitalName = districtCapitalName;
    }

    public District() {
    }

    public double getAria() {
        return aria;
    }

//    public void addCity(City city){
//        cities.add(city);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrictCapitalName() {
        return districtCapitalName;
    }

    public void setDistrictCapitalName(String districtCapitalName) {
        this.districtCapitalName = districtCapitalName;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void setAria(double aria) {
        this.aria = aria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Double.compare(district.aria, aria) == 0 && Objects.equals(name, district.name) && Objects.equals(districtCapitalName, district.districtCapitalName) && Objects.equals(cities, district.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, districtCapitalName, cities, aria);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[name=" + name +
                "][districtCapitalName='" + districtCapitalName +
                "][cities=" + cities +
                "][aria=" + aria + "]";
    }
}
