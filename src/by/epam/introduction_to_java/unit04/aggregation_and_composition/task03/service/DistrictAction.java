package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.service;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.City;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.District;

public class DistrictAction {
    public static void addCity(District district, City city){
        district.getCities().add(city);
    }
}
