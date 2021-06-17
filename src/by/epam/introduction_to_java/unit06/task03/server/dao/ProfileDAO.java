package by.epam.introduction_to_java.unit06.task03.server.dao;


import by.epam.introduction_to_java.unit06.task03.server.bean.Profile;
import by.epam.introduction_to_java.unit06.task03.server.exception.DAOException;

public interface ProfileDAO {
    void addProfile(Profile profile) throws DAOException;
    Profile validateClient(String login, String password) throws DAOException;

}
