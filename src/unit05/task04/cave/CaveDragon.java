package unit05.task04.cave;

import unit05.task04.treasure.Treasure;
import unit05.task04.treasure.TreasureMaterial;
import unit05.task04.treasure.TypeTreasure;

import java.util.ArrayList;
import java.util.Random;

public class CaveDragon {
    private ArrayList<Treasure> treasureArrayList;

    public CaveDragon() {
        this.treasureArrayList = new ArrayList<>();
        generatorTreasure();
    }

    private void generatorTreasure(){
        Random random = new Random();

        for(int i = 0; i < 100; i++){
            treasureArrayList.add(new Treasure
                    (TypeTreasure.randomTypeTreasure(), TreasureMaterial.randomTreasureMaterial(),random.nextInt(50),i+1));
        }
    }

    public void showTreasures(){
        treasureArrayList.forEach(System.out::println);
    }

    public Treasure mostTreasured(){
        Treasure mostTreasured = treasureArrayList.get(0);
        for (Treasure treas : treasureArrayList) {
            if (mostTreasured.getCost() < treas.getCost()) {
                mostTreasured = treas;
            }
        }
        return mostTreasured;
    }

    public void printTreasuresAmount(int sum){
        ArrayList<Treasure> treasuresOnSum = chooseTreasuresAmount(sum, 0);
        StringBuilder stringTreasuresOnSum = new StringBuilder("\n");
        if(treasuresOnSum.isEmpty()){
            stringTreasuresOnSum.append("На заданную сумму невозможно выбрать сокровища.");
        } else {
            stringTreasuresOnSum.append("Сокровища на сумму ").append(sum).append("\n");
            for (Treasure treasure: treasuresOnSum){
                if(treasure.getCost() != 0){
                    stringTreasuresOnSum.append(treasure).append("\n");
                }
            }
        }
        System.out.println(stringTreasuresOnSum);
    }

    private ArrayList<Treasure> chooseTreasuresAmount(int sum, int startElement){
        ArrayList<Treasure> buffer;
        int residualSum;
        int sumBuffer;
        for (int i = startElement; i < treasureArrayList.size(); i++){
            buffer = new ArrayList<>();
            sumBuffer = 0;
            residualSum = sum;

            if(treasureArrayList.get(i).getCost() <= sum){
                buffer.add(treasureArrayList.get(i));
                residualSum -= treasureArrayList.get(i).getCost();

                if(treasureArrayList.get(i).getCost() == sum){
                    return buffer;
                }

                buffer.addAll(chooseTreasuresAmount(residualSum,i+1));

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
