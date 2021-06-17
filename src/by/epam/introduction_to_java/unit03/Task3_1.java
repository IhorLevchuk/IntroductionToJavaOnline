package by.epam.introduction_to_java.unit03;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task3_1 {
    private final String text;
    private final String regexParagraphs = "\\u2029";
    private final String regexSentences = "[.!?]\\s";
    private final String regexWord = "\\s";

    public Task3_1(String text){
        this.text = text;
        System.out.println(text);
        choiceOfAction();
    }

    private void choiceOfAction(){
        String cap = "\nChoice of action:\n"+
                "1 Sort paragraphs.\n"+
                "2 Sort sentences.\n"+
                "3 Sort lexemes in the sentence by the number of occurrences of the character.\n"+
                "4 Exit";
        System.out.println(cap);
        Scanner in = new Scanner(System.in);
        switch (in.nextLine()){
            case "4" -> System.exit(0);
            case "3" ->{
                System.out.println("Enter char:");
                printParagraphs(sortLexemes(in.next().charAt(0)));
                choiceOfAction();
            }
            case "2" ->{
                printParagraphs(sortParagraphs());
                choiceOfAction();
            }
            case "1" ->{
                String[] paragraphs = split(text,regexParagraphs);
                printParagraphs(sort(paragraphs,regexSentences));
                choiceOfAction();
            }
            default -> System.out.println("Wrong choice of action");
        }
    }

    private int numberCharactersInWord(String word, char character){
        int quantity = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == character){
                quantity++;
            }
        }
        return quantity;
    }
    private String[] sortLexemes(char caracter){
        int length = 0;

        String[] paragraphs = split(text,regexParagraphs);
        String[] paragraphsSort = new String[paragraphs.length];

        for(int i = 0; i < paragraphs.length; i++){
            StringBuilder paragraph = new StringBuilder();
            String[] sentences = split(paragraphs[i],regexSentences);

            for(String sentence: sentences){
                String[] words = split(sentence,regexWord);
                String[] sortWords = sort(words,caracter);

                for(int j = 0; j < sortWords.length; j++){
                    paragraph.append(sortWords[j]);
                    length += sortWords[j].length();

                    if(j != sortWords.length-1){
                        paragraph.append(" ");
                    } else paragraph.append(". ");

                    if(length > 35){
                        paragraph.append("\n");
                        length = 0;
                    }
                }
            }
            paragraph.append("\n\n");
            length = 0;
            paragraphsSort[i] = paragraph.toString();
        }
        return paragraphsSort;
    }
    private String[] sortParagraphs(){
        int length = 0;

        String[] paragraphs = split(text,regexParagraphs);
        String[] paragraphsSort = new String[paragraphs.length];

        for(int i = 0; i < paragraphs.length; i++){
            StringBuilder paragraph = new StringBuilder();
            String[] sentences = split(paragraphs[i],regexSentences);

            for(String sentence: sentences){
                String[] words = split(sentence,regexWord);
                String[] sortWords = sort(words,"");

                for(int j = 0; j < sortWords.length; j++){
                    paragraph.append(sortWords[j]);
                    length += sortWords[j].length();

                    if(j != sortWords.length-1){
                        paragraph.append(" ");
                    } else paragraph.append(". ");

                    if(length > 35){
                        paragraph.append("\n");
                        length = 0;
                    }
                }
            }
            paragraph.append("\n\n");
            length = 0;
            paragraphsSort[i] = paragraph.toString();
        }
        return paragraphsSort;
    }

    private String[] sort(String[] array,char character){
        String[] arraySort = array.clone();
        String buffer;
        int i = 0;
        while (i < arraySort.length-1){
            if(numberCharactersInWord(arraySort[i],character) < numberCharactersInWord(arraySort[i+1],character)){
                //System.out.println(i);
                buffer = arraySort[i];
                arraySort[i] = arraySort[i+1];
                arraySort[i+1] = buffer;
                if(i != 0){
                    i--;
                }
            } else if(numberCharactersInWord(arraySort[i],character) == numberCharactersInWord(arraySort[i+1],character)){
                String [] forCompare = {arraySort[i], arraySort[i+1]};
                Arrays.sort(forCompare);
                arraySort[i] = forCompare[0];
                arraySort[i+1] = forCompare[1];
                i++;
            } else i++;
        }
        return arraySort;
    }

    private String[] sort(String[] array, String regex){
        String[] arraySort = array.clone();
        String buffer;
        int i = 0;
        while (i < arraySort.length-1){
            if(split(arraySort[i],regex).length < split(arraySort[i+1],regex).length){
                buffer = arraySort[i];
                arraySort[i] = arraySort[i+1];
                arraySort[i+1] = buffer;
                if(i != 0){
                    i--;
                }
            } else i++;
        }
        return arraySort;
    }

    private String[] split(String text, String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.split(text);
    }

    public void printParagraphs(String[] array){
        StringBuilder text = new StringBuilder();
        for (String arr: array){
            text.append(arr);
        }
        System.out.println(text);
    }

}
