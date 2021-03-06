package by.epam.introduction_to_java.unit06.task03.server.bean;


import by.epam.introduction_to_java.unit06.task03.server.enumeration.Access;

public class Profile {
    private Access access;
    private String name;
    private String login;
    private String password;

    public Profile(Access access, String name, String login, String password) {
        this.access = access;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Profile() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Access: " + access + "   Name: " + name + "   Login:" + login;
    }
}
