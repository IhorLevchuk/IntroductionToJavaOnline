package unit06.task01.profile;

import unit06.task01.model.EMail;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Profile implements Serializable {
    private String surname;
    private String name;
    private String patronymic;
    private String login;
    private EMail email;
    private byte[] password;

    public Profile() {
    }

    public Profile(String surname, String name, String patronymic, String login, String password) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = getHash(password);
    }

    public static byte[] getHash(String password) {
        byte[] passwordByte = password.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return messageDigest.digest(passwordByte);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = getHash(password);
    }

    @Override
    public String toString() {
        return  surname + " " + name + " " + patronymic;
    }

    public String getLogin() {
        return login;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setEmail(EMail email) {
        this.email = email;
    }

    public EMail getEmail() {
        return email;
    }
}
