package by.epam.introduction_to_java.unit05.task05.service;

import by.epam.introduction_to_java.unit05.task05.bean.FloralArrangement;
import by.epam.introduction_to_java.unit05.task05.bean.Flower;
import by.epam.introduction_to_java.unit05.task05.bean.Wrapper;

public class FloralArrangementAction {
    public void addFlower(FloralArrangement floralArrangement, Flower flower, int number){
        for (int i = 0; i < number; i ++){
            floralArrangement.getFlowers().add(flower);
        }
    }

    public void addWrapper(FloralArrangement floralArrangement, Wrapper wrapper){
        floralArrangement.setWrapper(wrapper);
    }
}
