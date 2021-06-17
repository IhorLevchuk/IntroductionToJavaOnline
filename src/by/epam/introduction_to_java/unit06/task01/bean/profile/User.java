package by.epam.introduction_to_java.unit06.task01.bean.profile;

import by.epam.introduction_to_java.unit06.task01.bean.EMail;

import java.io.Serial;

public class User extends Profile {
    @Serial
    private static final long serialVersionUID = -6332808973734143818L;

    public User(String surname, String name, String patronymic, EMail eMail, String login, byte[] password) {
        super(surname, name, patronymic,eMail, login, password);
    }

    public User() {
    }
}
