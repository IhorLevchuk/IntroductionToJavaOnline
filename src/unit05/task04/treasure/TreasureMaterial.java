package unit05.task04.treasure;

import java.util.Random;

public enum TreasureMaterial {
    GOLD, SILVER, PLATINUM, COOPER, BRONZE;

    private static Random random = new Random();

    public static TreasureMaterial randomTreasureMaterial(){
        int x = random.nextInt(TreasureMaterial.values().length);
        return TreasureMaterial.values()[x];
    }
}
