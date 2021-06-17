package by.epam.introduction_to_java.unit06.task01.bean.profile;

import by.epam.introduction_to_java.unit06.task01.bean.EMail;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Profile implements Serializable {
    @Serial
    private static final long serialVersionUID = 1896812041243929811L;
    private String surname;
    private String name;
    private String patronymic;
    private String login;
    private EMail email;
    private byte[] password;

    public Profile() {
    }

    public Profile(String surname, String name, String patronymic, EMail eMail, String login, byte[] password) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.email = eMail;
    }

    public String getAllName() {
        return surname + " " + name + " " + patronymic;
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

    public void setPassword(byte[] password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(surname, profile.surname) && Objects.equals(name, profile.name) && Objects.equals(patronymic, profile.patronymic) && Objects.equals(login, profile.login) && Objects.equals(email, profile.email) && Arrays.equals(password, profile.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(surname, name, patronymic, login, email);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", login='" + login + '\'' +
                ", email=" + email +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
