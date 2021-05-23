package unit06.task03.Server;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Profile {
    private Access access;
    private String name;
    private String login;
    private String password;

    public Profile(Access access, String name, String login, String password) {
        this.access = access;
        this.name = name;
        this.login = login;
        setPassword(password);
    }

    public Profile() {
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
        this.password = Base64.getEncoder().encodeToString(getHash(password));
    }

    public void setRidingPassword(String password) {
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
