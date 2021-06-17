package by.epam.introduction_to_java.unit06.task04.controller.port.impl;

import by.epam.introduction_to_java.unit06.task04.bean.Port;
import by.epam.introduction_to_java.unit06.task04.controller.port.PortCommand;
import by.epam.introduction_to_java.unit06.task04.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task04.service.PortServiceI;
import by.epam.introduction_to_java.unit06.task04.service.impl.ServiceProvider;

public class DockCommand implements PortCommand {
    @Override
    public Object execute(Object... params) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        PortServiceI portService = serviceProvider.getPortService();
        try {
            return portService.dock((Port)params[1]);
        } catch (ServiceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
