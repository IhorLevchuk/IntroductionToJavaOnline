package by.epam.introduction_to_java.unit06.task04.controller.ship.impl;

import by.epam.introduction_to_java.unit06.task04.bean.Ship;
import by.epam.introduction_to_java.unit06.task04.controller.ship.ShipCommand;
import by.epam.introduction_to_java.unit06.task04.service.ShipServiceI;
import by.epam.introduction_to_java.unit06.task04.service.impl.ServiceProvider;

public class LoadingCommand implements ShipCommand {
    @Override
    public void execute(Ship ship) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        ShipServiceI shipService = serviceProvider.getShipService();

        shipService.loadShip(ship);
    }
}
