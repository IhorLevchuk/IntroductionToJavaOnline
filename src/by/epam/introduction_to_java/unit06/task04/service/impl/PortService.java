package by.epam.introduction_to_java.unit06.task04.service.impl;

import by.epam.introduction_to_java.unit06.task04.bean.Dock;
import by.epam.introduction_to_java.unit06.task04.bean.Port;
import by.epam.introduction_to_java.unit06.task04.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task04.service.PortServiceI;

public class PortService implements PortServiceI {
    public Dock dock(Port port) throws ServiceException {
        try {
            port.getSemaphore().acquire();
            return port.getDocks().poll();
        } catch (InterruptedException e) {
            throw new ServiceException(e);
        }
    }

    public void depart(Port port, Dock dock){
        port.getDocks().add(dock);
        port.getSemaphore().release();
    }
}
