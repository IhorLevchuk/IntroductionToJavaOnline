package by.epam.introduction_to_java.unit06.task01.service.impl;

import by.epam.introduction_to_java.unit06.task01.bean.EMail;
import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.bean.book.EBook;
import by.epam.introduction_to_java.unit06.task01.bean.book.PaperBook;
import by.epam.introduction_to_java.unit06.task01.bean.profile.Admin;
import by.epam.introduction_to_java.unit06.task01.bean.profile.Profile;
import by.epam.introduction_to_java.unit06.task01.bean.profile.User;
import by.epam.introduction_to_java.unit06.task01.dao.impl.DAOProvider;
import by.epam.introduction_to_java.unit06.task01.exception.DAOException;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.service.ProfileServiceI;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ProfileService implements ProfileServiceI {

    private final DAOProvider provider = DAOProvider.getProvider();
    private Profile activeProfile = new Profile();

    @Override
    public Profile authorization(String login, String password) throws ServiceException {
        byte[] passwordByte = getHash(password);
        try {
            activeProfile = provider.getProfileDAO().authorization(login, passwordByte);
            return activeProfile;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean registration(String surname, String name, String patronymic, String email, String login, String password) throws ServiceException {
        Profile profile;
        List<Profile> profiles;
        if (activeProfile.getClass() == Admin.class){
            profile = new Admin(surname, name, patronymic, new EMail(email), login, getHash(password));
        } else {
            profile = new User(surname, name, patronymic, new EMail(email), login, getHash(password));
        }
        try {
            return provider.getProfileDAO().registration(profile);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void logOut() throws ServiceException {
        activeProfile = new Profile();
    }

    @Override
    public List<String> getMessages() throws ServiceException {
        return activeProfile.getEmail().getMessages();
    }

    @Override
    public void sendMessageWithProposalEBook(int id, String author, int pages, String name) throws ServiceException {
        Book book = new EBook(id, author, pages, name);
        StringBuilder message = new StringBuilder();
        message.append("от: ").append(activeProfile.getEmail()).append("\n").append("Предложение: \n").append(book.getInf());
        try {
            provider.getProfileDAO().sendMessageToAdmins(message.toString());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void sendMessageWithProposalPaperBook(int id, String author, int pages, String name) throws ServiceException {
        Book book = new PaperBook(id, author, pages, name);
        StringBuilder message = new StringBuilder();
        message.append("от: ").append(activeProfile.getEmail()).append("\n").append("Предложение: \n").append(book.getInf());
        try {
            provider.getProfileDAO().sendMessageToAdmins(message.toString());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    private byte[] getHash(String password) {
        byte[] passwordByte = password.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return messageDigest.digest(passwordByte);
    }

}
