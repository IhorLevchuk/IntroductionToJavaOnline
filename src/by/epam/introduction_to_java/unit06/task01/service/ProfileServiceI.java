package by.epam.introduction_to_java.unit06.task01.service;

import by.epam.introduction_to_java.unit06.task01.bean.profile.Profile;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;

import java.util.List;

public interface ProfileServiceI {
    Profile authorization(String login, String password) throws ServiceException;
    boolean registration(String surname, String name, String patronymic, String email, String login, String password) throws ServiceException;
    void logOut () throws ServiceException;
    List<String> getMessages() throws ServiceException;
    void sendMessageWithProposalEBook (int id, String author, int pages, String name) throws ServiceException;
    void sendMessageWithProposalPaperBook (int id, String author, int pages, String name) throws ServiceException;
}
