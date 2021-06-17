package by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Sentence implements Serializable {
    @Serial
    private static final long serialVersionUID = 4251089926582984595L;

    private List<Word> words;

    public Sentence() {
    }

    public Sentence(List<Word> words) {
        this.words = new ArrayList<>();
        for (Word word: words) {
            if(!Pattern.matches("[.!&:;,]",word.getWord())){
                this.words.add(new Word(" "));
            }
            this.words.add(word);
        }
    }
    public List<Word> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(words, sentence.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[words=" + words + "]";
    }
}
