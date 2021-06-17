package by.epam.introduction_to_java.unit06.task04.controller.ship;

import by.epam.introduction_to_java.unit06.task04.bean.Ship;
import by.epam.introduction_to_java.unit06.task04.enumeration.PurposeOfArrival;

public interface ShipControllerI {

    void doAction(PurposeOfArrival request, Ship ship);
}
