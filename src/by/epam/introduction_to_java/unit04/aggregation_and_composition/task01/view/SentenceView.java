package by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.view;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean.Sentence;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean.Word;

public class SentenceView {
    public static String sentenceToString(Sentence sentence) {
        StringBuilder sentenceToString = new StringBuilder();
        for (Word word: sentence.getWords()){
            sentenceToString.append(word.getWord());
        }
        return sentenceToString.toString();
    }
}
