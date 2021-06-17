package by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.main;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.City;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.District;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.Region;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.bean.State;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.service.DistrictAction;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.service.RegionAction;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.service.StateAction;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task03.view.StateView;

public class Task03 {
    public static void main(String[] args) {
        /*
        Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры
         */


        State belarus = new State("Беларусь","Минск");


        District district1 = new District("Брестский район", 200,"Брест");
        DistrictAction.addCity(district1, new City("Брест"));

        District district2 = new District("Кобринский район", 50,"Кобрин");
        DistrictAction.addCity(district2, new City("Кобрин"));

        Region region1 = new Region("Брестская область", "Брест");
        RegionAction.addDistrict(region1, district1);
        RegionAction.addDistrict(region1, district2);

        StateAction.addRegion(belarus, region1);

        District district3 = new District("Гомельский район", 300,"Гомель");
        DistrictAction.addCity(district1, new City("Гомель"));

        District district4 = new District("Мозырьский район", 130,"Мозырь");
        DistrictAction.addCity(district1, new City("Мозырь"));

        Region region2 = new Region("Гомельская область", "Гомель");
        RegionAction.addDistrict(region2, district3);
        RegionAction.addDistrict(region2, district4);

        StateAction.addRegion(belarus, region2);

        StateView.printCapital(belarus);
        StateView.printAria(belarus);
        StateView.printNumberOfRegions(belarus);
        StateView.printRegionCapitalName(belarus);
    }
}
