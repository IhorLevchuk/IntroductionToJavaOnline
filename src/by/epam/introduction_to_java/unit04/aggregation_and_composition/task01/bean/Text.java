package by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Text implements Serializable {
    @Serial
    private static final long serialVersionUID = 7873458003176421638L;

    private Word textHeader;
    private List<Sentence> sentences;

    public Text() {
    }

    public Text(Word textHeader, List<Sentence> text) {
        this.textHeader = textHeader;
        this.sentences = text;
    }

    public Text(Word textHeader) {
        this.textHeader = textHeader;
    }

    public Text(List<Sentence> text) {
        this.sentences = text;
    }

    public void addSentence(Sentence sentence){
        sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Word getTextHeader() {
        return textHeader;
    }

    public void setTextHeader(Word textHeader) {
        this.textHeader = textHeader;
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(getClass().getSimpleName());
        string.append("[textHeader=").append(textHeader).append("]");
        string.append("[sentences=").append(sentences).append("]");
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(textHeader, text.textHeader) && Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textHeader, sentences);
    }
}
