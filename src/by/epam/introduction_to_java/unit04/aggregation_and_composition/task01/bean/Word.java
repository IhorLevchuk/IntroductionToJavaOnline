package by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Word implements Serializable {
    @Serial
    private static final long serialVersionUID = 6050551962260219906L;

    private String word;

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(getClass().getSimpleName());
        string.append("[word=").append(word).append("]");
        return string.toString();
    }
}
