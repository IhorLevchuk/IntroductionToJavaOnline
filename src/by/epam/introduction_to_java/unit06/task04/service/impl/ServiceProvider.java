package by.epam.introduction_to_java.unit06.task04.service.impl;

import by.epam.introduction_to_java.unit06.task04.service.PortServiceI;
import by.epam.introduction_to_java.unit06.task04.service.ShipServiceI;

public class ServiceProvider {
    private static final ServiceProvider provider = new ServiceProvider();

    private final ShipServiceI shipService = new ShipService();
    private final PortServiceI portService = new PortService();

    private ServiceProvider() {
    }

    public static ServiceProvider getProvider(){
        return provider;
    }

    public ShipServiceI getShipService() {
        return shipService;
    }

    public PortServiceI getPortService() {
        return portService;
    }
}
