package unit05.task05.A.flowers;

public class CreatorFlower {
    public static Flower createFlower(String type) {
        TypeFlower typeFlower = TypeFlower.valueOf(type.toUpperCase());
        switch (typeFlower){
            case ROSE -> {
                return new Rose();
            }
            case TULIP -> {
                return new Tulip();
            }
            case ORCHID ->{
                return new Orchid();
            }
            default -> {
                throw new RuntimeException(typeFlower + "Flower is unknown");
            }

        }
    }
}
