package unit04.aggregation_and_composition.task01;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Sentence {
    private ArrayList<Word> words;

    public ArrayList<Word> getWords() {
        return words;
    }

    public Sentence(ArrayList<Word> words) {
        this.words = new ArrayList<>();
        for (Word word: words) {
            if(!Pattern.matches("[.!&:;,]",word.getWord())){
                this.words.add(new Word(" "));
            }
            this.words.add(word);
        }
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word: words){
            sentence.append(word.getWord());
        }
        return sentence.toString();
    }
}
