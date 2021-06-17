package by.epam.introduction_to_java.unit06.task02.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public class Email implements Serializable {
    @Serial
    private static final long serialVersionUID = -111669666547973235L;

    private String email;
    private static final String reg = "\\w+@[A-Za-z]+.[a-z]{2,6}";

    public String getEmail() {
        return email;
    }

    public Email(String email) {
        setEmail(email);
    }

    public Email() {
    }

    public boolean setEmail(String email) {
        if (Pattern.matches(reg, email)){
            this.email = email;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
