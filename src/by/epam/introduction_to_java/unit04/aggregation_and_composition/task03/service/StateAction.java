package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.service;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.Region;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.State;

public class StateAction {
    public static void addRegion(State state, Region region){
        state.setAria(state.getAria()+region.getAria());
        state.getRegions().add(region);
    }
}
