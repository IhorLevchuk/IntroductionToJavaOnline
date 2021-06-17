package by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.view;

import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean.Sentence;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean.Text;

public class TextView {

    public static String textToString(Text text){
        StringBuilder textToString = new StringBuilder();
        textToString.append(text.getTextHeader().getWord() + "\n");
        int stringLength = 25;
        int i = 0;
        for (Sentence sentence: text.getSentences()){
            i += sentence.toString().length();
            if(i > stringLength){
                textToString.append("\n");
                i = 0;
            }
            textToString.append(SentenceView.sentenceToString(sentence));
        }
        return textToString.toString();
    }

}
