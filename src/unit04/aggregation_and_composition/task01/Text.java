package unit04.aggregation_and_composition.task01;


import java.util.ArrayList;

public class Text {
    private Word textHeader;
    private ArrayList<Sentence> sentences;

    public Text(Word textHeader, ArrayList<Sentence> text) {
        this.textHeader = textHeader;
        this.sentences = text;
    }

    public Text(Word textHeader) {
        this.textHeader = textHeader;
    }

    public Text(ArrayList<Sentence> text) {
        this.sentences = text;
    }

    public void addSentence(Sentence sentence){
        sentences.add(sentence);
    }

    public void printTextHeader(){
        System.out.println(textHeader.getWord() + "\n");
    }

    public void print(){
        StringBuilder text = new StringBuilder();
        int stringLength = 25;
        int i = 0;
        for (Sentence sentence: sentences){
            i += sentence.toString().length();
            if(i > stringLength){
                text.append("\n");
                i = 0;
            }
            text.append(sentence);
        }
        System.out.println(text);
    }
}
