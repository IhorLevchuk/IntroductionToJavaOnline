package by.epam.introduction_to_java.unit05.task04.main;

import by.epam.introduction_to_java.unit05.task04.bean.CaveDragon;
import by.epam.introduction_to_java.unit05.task04.service.CaveDragonAction;
import by.epam.introduction_to_java.unit05.task04.view.CaveDragonView;


public class Task04 {
    public static void main(String[] args) {
        /*
        Создать консольное приложение, удовлетворяющее следующим требованиям:
            • Приложение должно быть объектно-, а не процедурно-ориентированным.
            • Каждый класс должен иметь отражающее смысл название и информативный состав.
            • Наследование должно применяться только тогда, когда это имеет смысл.
            • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
            • Классы должны быть грамотно разложены по пакетам.
            • Консольное меню должно быть минимальным.
            • Для хранения данных можно использовать файлы.

        Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
        Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ
        на заданную сумму.
         */
        CaveDragonAction caveDragonAction = new CaveDragonAction();
        CaveDragonView caveDragonView = new CaveDragonView();

        CaveDragon caveDragon = new CaveDragon();

        caveDragonAction.generatorTreasure(caveDragon);

        System.out.println("Все сокровища:");
        caveDragonView.printTreasures(caveDragon.getTreasures());

        System.out.println("\nСамое дорогое сокровище:");
        caveDragonView.printTreasures(caveDragonAction.getMostTreasured(caveDragon.getTreasures()));

        System.out.println("\nСокровища на сумму:");
        caveDragonView.printTreasures(caveDragonAction.chooseTreasuresAmount(caveDragon.getTreasures(), 20, 1));
    }
}
