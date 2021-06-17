package by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.main;



import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean.Sentence;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean.Text;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.bean.Word;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.view.SentenceView;
import by.epam.introduction_to_java.unit04.aggregation_and_composition.task01.view.TextView;

import java.util.ArrayList;

public class Task01 {
    public static void main(String[] args) {
        /*
        Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
консоль текст, заголовок текста.
         */


        ArrayList<Word> words1 = new ArrayList<>();
        words1.add(new Word("Этот"));
        words1.add(new Word("текст"));
        words1.add(new Word("состоит"));
        words1.add(new Word("из"));
        words1.add(new Word("предложений"));
        words1.add(new Word("."));

        ArrayList<Word> words2 = new ArrayList<>();
        words2.add(new Word("Преждожения"));
        words2.add(new Word("состоят"));
        words2.add(new Word("из"));
        words2.add(new Word("слов"));
        words2.add(new Word("."));

        ArrayList<Sentence> sentences = new ArrayList<>();
        sentences.add(new Sentence(words1));
        sentences.add(new Sentence(words2));

        System.out.println(TextView.textToString(new Text(new Word("Структура"),sentences)));

    }
}
