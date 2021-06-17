package by.epam.introduction_to_java.unit06.task02.bean;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Note implements Serializable {
    @Serial
    private static final long serialVersionUID = 3825286244606260964L;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(topic, note.topic) && Objects.equals(date, note.date) && Objects.equals(email, note.email) && Objects.equals(text, note.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, date, email, text);
    }
}
