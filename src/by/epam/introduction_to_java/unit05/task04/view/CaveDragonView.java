package by.epam.introduction_to_java.unit05.task04.view;

import by.epam.introduction_to_java.unit05.task04.bean.CaveDragon;
import by.epam.introduction_to_java.unit05.task04.bean.Treasure;

import java.util.List;

public class CaveDragonView {
    public void printTreasures(List<Treasure> treasures){
        treasures.forEach(System.out::println);
    }
}
