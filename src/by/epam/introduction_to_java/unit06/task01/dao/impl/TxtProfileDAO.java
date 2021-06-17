package by.epam.introduction_to_java.unit06.task01.dao.impl;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.bean.profile.Admin;
import by.epam.introduction_to_java.unit06.task01.bean.profile.Profile;
import by.epam.introduction_to_java.unit06.task01.bean.profile.User;
import by.epam.introduction_to_java.unit06.task01.dao.ProfileDAO;
import by.epam.introduction_to_java.unit06.task01.exception.DAOException;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxtProfileDAO implements ProfileDAO {

    private boolean saveDate(List<Profile> readTo) throws DAOException {
        boolean flag = false;
        File users = new File("src/by/epam/introduction_to_java/unit06/task01/file/Profiles.txt");
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(users,false);
            ostream = new ObjectOutputStream(fos);

            for(Profile ob: readTo){
                ostream.writeObject(ob);
            }
            flag = true;
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл не может быть создан ", e);
        } catch (IOException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                throw new DAOException("ошибка закрытия потока ", e);
            }
        }
        return flag;
    }

    private List<Profile> readDate() throws DAOException {
        List<Profile> profiles = new ArrayList<>();
        File data = new File("src/by/epam/introduction_to_java/unit06/task01/file/Profiles.txt");
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(data);
            istream = new ObjectInputStream(fis);
            while (true){
                profiles.add((Profile) istream.readObject());
            }
        } catch (ClassNotFoundException ce) {
            throw new DAOException("Класс не существует ", ce);
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл для десериализации не существует ", e);
        } catch (IOException ioe) {
            throw new DAOException("Общая I/O ошибка ", ioe);
        }
        finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                throw new DAOException("ошибка закрытия потока ", e);
            }
            return profiles;
        }
    }

    @Override
    public Profile authorization(String login, byte[] passwordByte) throws DAOException {
        for (Profile profile: readDate()){
            if(profile.getLogin().equals(login) && Arrays.equals(profile.getPassword(), passwordByte)){
                return profile;
            }
        }
        return new Profile();
    }

    @Override
    public boolean registration(Profile profile) throws DAOException {
        List<Profile> profiles;
        profiles = readDate();
        profiles.add(profile);
        return saveDate(profiles);
    }

    @Override
    public void sendMessage(Profile to, String message) throws DAOException {
        List<Profile> profiles = readDate();
        for(Profile profile: profiles){
            if(profile.equals(to)){
                profile.getEmail().addMessage(message);
            }
        }
        saveDate(profiles);
    }

    @Override
    public void sendMessageToUsers(String message) throws DAOException {
        List<Profile> profiles = readDate();
        for(Profile profile: profiles){
            if(profile.getClass() == User.class){
                profile.getEmail().addMessage(message);
            }
        }
        saveDate(profiles);
    }

    @Override
    public void sendMessageToAdmins(String message) throws DAOException {
        List<Profile> profiles = readDate();
        for(Profile profile: profiles){
            if(profile.getClass() == Admin.class){
                profile.getEmail().addMessage(message);
            }
        }
        saveDate(profiles);
    }
}
