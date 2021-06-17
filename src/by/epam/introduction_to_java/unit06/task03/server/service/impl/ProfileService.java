package by.epam.introduction_to_java.unit06.task03.server.service.impl;

import by.epam.introduction_to_java.unit06.task03.server.bean.Profile;
import by.epam.introduction_to_java.unit06.task03.server.dao.impl.DAOProvider;
import by.epam.introduction_to_java.unit06.task03.server.enumeration.Access;
import by.epam.introduction_to_java.unit06.task03.server.exception.DAOException;
import by.epam.introduction_to_java.unit06.task03.server.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task03.server.service.ProfileServiceI;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ProfileService implements ProfileServiceI {
    private final DAOProvider provider = DAOProvider.getProvider();

    @Override
    public void addProfile(String access, String name, String login, String password) throws ServiceException {
        Profile profile = new Profile(Access.valueOf(access.toUpperCase()),name,login, Base64.getEncoder().encodeToString(getHash(password)));
        try {
            provider.getProfileDAO().addProfile(profile);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Profile validateClient(String login, String password) throws ServiceException {
        try {
            return provider.getProfileDAO().validateClient(login,Base64.getEncoder().encodeToString(getHash(password)));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static byte[] getHash(String password) {
        byte[] passwordByte = password.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert messageDigest != null;
        return messageDigest.digest(passwordByte);
    }
}
