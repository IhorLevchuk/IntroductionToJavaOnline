package by.epam.introduction_to_java.unit05.task04.service;

import by.epam.introduction_to_java.unit05.task04.bean.CaveDragon;
import by.epam.introduction_to_java.unit05.task04.bean.Treasure;
import by.epam.introduction_to_java.unit05.task04.enumeration.TreasureMaterial;
import by.epam.introduction_to_java.unit05.task04.enumeration.TypeTreasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaveDragonAction {
    public void generatorTreasure(CaveDragon caveDragon){
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            caveDragon.getTreasures().add(new Treasure
                    (TypeTreasure.randomTypeTreasure(), TreasureMaterial.randomTreasureMaterial(),random.nextInt(50),i+1));
        }
    }

    public List<Treasure> getMostTreasured(List<Treasure> treasures){
        ArrayList<Treasure> treasure = new ArrayList<>();
        Treasure mostTreasured = treasures.get(0);
        for (Treasure treas : treasures) {
            if (mostTreasured.getCost() < treas.getCost()) {
                mostTreasured = treas;
            }
        }
        treasure.add(mostTreasured);
        return treasure;
    }

    public ArrayList<Treasure> chooseTreasuresAmount(List<Treasure> treasures, int sum, int startElement){
        ArrayList<Treasure> buffer;
        int residualSum;
        int sumBuffer;
        for (int i = startElement; i < treasures.size(); i++){
            buffer = new ArrayList<>();
            sumBuffer = 0;
            residualSum = sum;

            if(treasures.get(i).getCost() <= sum){
                buffer.add(treasures.get(i));
                residualSum -= treasures.get(i).getCost();

                if(treasures.get(i).getCost() == sum){
                    return buffer;
                }

                buffer.addAll(chooseTreasuresAmount(treasures, residualSum,i+1));

                for(Treasure treasure: buffer){
                    sumBuffer += treasure.getCost();
                }

                if(sumBuffer == sum){
                    return buffer;
                }
            }
        }
        return new ArrayList<>();
    }
}
