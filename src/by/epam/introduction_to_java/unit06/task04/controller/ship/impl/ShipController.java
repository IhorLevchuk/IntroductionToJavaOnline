package by.epam.introduction_to_java.unit06.task04.controller.ship.impl;

import by.epam.introduction_to_java.unit06.task04.bean.Ship;
import by.epam.introduction_to_java.unit06.task04.controller.ship.ShipCommand;
import by.epam.introduction_to_java.unit06.task04.controller.ship.ShipControllerI;
import by.epam.introduction_to_java.unit06.task04.enumeration.PurposeOfArrival;

public class ShipController implements ShipControllerI {
    private CommandShipProvider provider = new CommandShipProvider();
    @Override
    public void doAction(PurposeOfArrival request, Ship ship) {
        ShipCommand currentCommand = provider.getCommand(request);
        currentCommand.execute(ship);
    }
}
