package unit05.task04.treasure;

import java.util.Random;

public enum TypeTreasure {
    RING, COIN, BRACELET, CUP, BAR, CROWN;

    private static Random random = new Random();

    public static TypeTreasure randomTypeTreasure(){
        int x = random.nextInt(TypeTreasure.values().length);
        return TypeTreasure.values()[x];
    }
}
