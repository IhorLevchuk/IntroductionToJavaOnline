package unit06.task01.model;

import java.io.Serializable;
import java.util.ArrayList;

public class EMail implements Serializable {
    private String email;
    private ArrayList<String> messages;

    public EMail(String email) {
        messages = new ArrayList<>();
        this.email = email;
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

    public void send(EMail recipient, String message){
        StringBuilder mess = new StringBuilder();
        mess.append("от: ").append(email).append("\n").append(message);
        recipient.addMessage(mess.toString());
    }
}
