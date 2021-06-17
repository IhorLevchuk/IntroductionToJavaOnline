package by.epam.introduction_to_java.unit06.task04.service;

import by.epam.introduction_to_java.unit06.task04.bean.Dock;
import by.epam.introduction_to_java.unit06.task04.bean.Port;
import by.epam.introduction_to_java.unit06.task04.exception.ServiceException;

import javax.resource.ResourceException;

public interface PortServiceI {
    Dock dock(Port port) throws ServiceException;
    void depart(Port port, Dock dock);
}
