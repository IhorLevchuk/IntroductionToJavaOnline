package by.epam.introduction_to_java.unit06.task01.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class EMail implements Serializable {
    @Serial
    private static final long serialVersionUID = -7891592867801684545L;
    private String email;
    private ArrayList<String> messages;

    public EMail(String email) {
        messages = new ArrayList<>();
        this.email = email;
    }

    public EMail() {
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

//    public void send(EMail recipient, String message){
//        StringBuilder mess = new StringBuilder();
//        mess.append("от: ").append(email).append("\n").append(message);
//        recipient.addMessage(mess.toString());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EMail eMail = (EMail) o;
        return Objects.equals(email, eMail.email) && Objects.equals(messages, eMail.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, messages);
    }

    @Override
    public String toString() {
        return "EMail{" +
                "email='" + email + '\'' +
                ", messages=" + messages +
                '}';
    }
}
