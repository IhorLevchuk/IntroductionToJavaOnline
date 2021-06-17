package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.service;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.District;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.Region;

public class RegionAction {
    public static void addDistrict(Region region, District district){
        region.setAria(region.getAria()+district.getAria());
        region.getDistricts().add(district);
    }
}
