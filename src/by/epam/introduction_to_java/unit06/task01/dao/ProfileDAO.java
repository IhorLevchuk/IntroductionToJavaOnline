package by.epam.introduction_to_java.unit06.task01.dao;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.bean.profile.Profile;
import by.epam.introduction_to_java.unit06.task01.exception.DAOException;

import java.util.List;

public interface ProfileDAO {

    Profile authorization(String login, byte[] passwordByte) throws DAOException;
    boolean registration(Profile profile) throws DAOException;
    void sendMessage(Profile to, String message) throws DAOException;
    void sendMessageToUsers(String message) throws DAOException;
    void sendMessageToAdmins(String message) throws DAOException;

}
