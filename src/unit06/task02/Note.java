package unit06.task02;

import java.time.LocalDate;
import java.util.Comparator;

public class Note {
    private String topic;
    private LocalDate date;
    private Email email;
    private Text text;

    public Note(String topic, Email email, Text text) {
        this.topic = topic;
        this.email = email;
        this.text = text;
        date = LocalDate.now();
    }

    public Note(String topic, Email email, Text text, LocalDate date) {
        this.topic = topic;
        this.email = email;
        this.text = text;
        this.date = date;
    }

    public Note() {
        date = LocalDate.now();
    }

    public String getTopic() {
        return topic;
    }

    public boolean setTopic(String topic) {
        if(!topic.isEmpty()){
            this.topic = topic;
            return true;
        }
        return false;
    }

    public LocalDate getDate() {
        return date;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public static Comparator<Note> dateComparator = new Comparator<Note>() {

        public int compare(Note note1, Note note2) {
            return note1.getDate().compareTo(note2.getDate());
        }
    };

    public static Comparator<Note> topicComparator = new Comparator<Note>() {

        public int compare(Note note1, Note note2) {
            return note1.getTopic().compareTo(note2.getTopic());
        }
    };

    @Override
    public String toString() {
        return "Note:\n" +
                "Topic: "+ topic +
                "\nCreation date: " + date +
                "\nE-mail: " + email +
                "\nText:\n" + text +"\n";
    }
}
