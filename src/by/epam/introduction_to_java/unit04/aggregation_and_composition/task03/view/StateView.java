package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.view;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.Region;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.State;

public class StateView {
    public static void printAria(State state) {
        System.out.println("Площадь: "+state.getAria());
    }

    public static void printCapital(State state){
        System.out.println("Столица: "+state.getCapitalName());
    }

    public static void printNumberOfRegions(State state){
        System.out.println("Количество областей: "+ state.getRegions().size());
    }

    public static void printRegionCapitalName(State state){
        StringBuilder str = new StringBuilder("Областные центры:\n");
        for (Region region: state.getRegions()) {
            str.append(region.getRegionCapitalName()).append("\n");
        }
        System.out.println(str);
    }
}
