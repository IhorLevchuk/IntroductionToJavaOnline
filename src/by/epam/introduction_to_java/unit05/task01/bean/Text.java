package by.epam.introduction_to_java.unit05.task01.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Text implements Serializable {
    @Serial
    private static final long serialVersionUID = -2252952688113829758L;

    private StringBuilder text;

    public Text() {
        text = new StringBuilder();
    }

    public void addText(String text){
        this.text.append(text).append("\n");
    }

    public StringBuilder getText() {
        return text;
    }

    @Override
    public String toString() {
        return text.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
