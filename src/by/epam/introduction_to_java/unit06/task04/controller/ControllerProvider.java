package by.epam.introduction_to_java.unit06.task04.controller;

import by.epam.introduction_to_java.unit06.task04.controller.port.PortControllerI;
import by.epam.introduction_to_java.unit06.task04.controller.port.impl.PortController;
import by.epam.introduction_to_java.unit06.task04.controller.ship.ShipControllerI;
import by.epam.introduction_to_java.unit06.task04.controller.ship.impl.ShipController;

public class ControllerProvider {
    private static final ControllerProvider provider = new ControllerProvider();

    private final ShipControllerI shipController = new ShipController();
    private final PortControllerI portController = new PortController();

    private ControllerProvider() {
    }

    public static ControllerProvider getProvider(){
        return provider;
    }

    public ShipControllerI getShipController() {
        return shipController;
    }

    public PortControllerI getPortController() {
        return portController;
    }
}
