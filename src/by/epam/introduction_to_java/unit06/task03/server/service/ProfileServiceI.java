package by.epam.introduction_to_java.unit06.task03.server.service;

import by.epam.introduction_to_java.unit06.task03.server.bean.Profile;
import by.epam.introduction_to_java.unit06.task03.server.exception.ServiceException;

public interface ProfileServiceI {
    void addProfile(String access, String name, String login, String password) throws ServiceException;
    Profile validateClient(String login, String password) throws ServiceException;
}
