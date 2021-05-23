package unit04.aggregation_and_composition.task03;

public class Task03 {
    public static void main(String[] args) {
        /*
        Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры
         */

        State belarus = new State("Беларусь","Минск");


        District district1 = new District("Брестский район", 200,"Брест");
        district1.addCity(new City("Брест"));

        District district2 = new District("Кобринский район", 50,"Кобрин");
        district2.addCity(new City("Кобрин"));

        Region region1 = new Region("Брестская область", "Брест");
        region1.addDistrict(district1);
        region1.addDistrict(district2);

        belarus.addRegion(region1);

        District district3 = new District("Гомельский район", 300,"Гомель");
        district1.addCity(new City("Гомель"));

        District district4 = new District("Мозырьский район", 130,"Мозырь");
        district2.addCity(new City("Мозырь"));

        Region region2 = new Region("Гомельская область", "Гомель");
        region2.addDistrict(district3);
        region2.addDistrict(district4);

        belarus.addRegion(region2);


        belarus.printCapital();
        belarus.printAria();
        belarus.printNumberOfRegions();
        belarus.printRegionCapitalName();
    }
}
