package by.epam.introduction_to_java.unit06.task04.controller.port.impl;

import by.epam.introduction_to_java.unit06.task04.bean.Dock;
import by.epam.introduction_to_java.unit06.task04.bean.Port;
import by.epam.introduction_to_java.unit06.task04.controller.port.PortCommand;
import by.epam.introduction_to_java.unit06.task04.service.PortServiceI;
import by.epam.introduction_to_java.unit06.task04.service.impl.ServiceProvider;

public class DepartCommand implements PortCommand {
    @Override
    public Object execute(Object... params) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        PortServiceI portService = serviceProvider.getPortService();
        portService.depart((Port) params[1], (Dock) params[2]);
        return null;
    }
}
