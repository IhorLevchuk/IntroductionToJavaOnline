package by.epam.introduction_to_java.unit06.task01.bean.profile;

import by.epam.introduction_to_java.unit06.task01.bean.EMail;

import java.io.Serial;

public class Admin extends Profile {
    @Serial
    private static final long serialVersionUID = 1079215972601536387L;

    public Admin(String surname, String name, String patronymic, EMail eMail, String login, byte[] password) {
        super(surname, name, patronymic, eMail, login, password);
    }

    public Admin() {
    }
}
