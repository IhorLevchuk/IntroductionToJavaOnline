package unit05.task05.A.packaging;

public class CreatorWrapper {
    public static Wrapper createWrapper(String type){
        TypeWrapper typeWrapper = TypeWrapper.valueOf(type.toUpperCase());
        switch (typeWrapper){
            case PAPER -> {
                return new PaperWrapping();
            }
            case WHOLE -> {
                return new WholeWrapper();
            }
            default -> {
                throw new RuntimeException(typeWrapper + "Packaging is unknown");
            }

        }
    }
}
