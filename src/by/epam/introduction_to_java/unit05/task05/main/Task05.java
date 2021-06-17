package by.epam.introduction_to_java.unit05.task05.main;

import by.epam.introduction_to_java.unit05.task05.bean.FloralArrangement;
import by.epam.introduction_to_java.unit05.task05.bean.Flower;
import by.epam.introduction_to_java.unit05.task05.bean.Wrapper;
import by.epam.introduction_to_java.unit05.task05.enumeration.Color;
import by.epam.introduction_to_java.unit05.task05.enumeration.TypeFlower;
import by.epam.introduction_to_java.unit05.task05.enumeration.TypeWrapper;
import by.epam.introduction_to_java.unit05.task05.service.FloralArrangementAction;


public class Task05 {
    public static void main(String[] args) {
        /*
        Создать консольное приложение, удовлетворяющее следующим требованиям:
            • Корректно спроектируйте и реализуйте предметную область задачи.
            • Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.
            • Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
            • для проверки корректности переданных данных можно применить регулярные выражения.
            • Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
            • Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().

        Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
        (объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы и упаковка.
         */
        FloralArrangementAction floralArrangementAction = new FloralArrangementAction();

        FloralArrangement floralArrangement = new FloralArrangement();

        floralArrangementAction.addFlower(floralArrangement, new Flower(TypeFlower.ORCHID, Color.BLUE,5), 5);
        floralArrangementAction.addFlower(floralArrangement, new Flower(TypeFlower.ROSE, Color.BLACK,4), 7);
        floralArrangementAction.addWrapper(floralArrangement, new Wrapper(TypeWrapper.PAPER, Color.BLUE,5));

        System.out.println(floralArrangement);
    }

}
