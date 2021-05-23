package unit03;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
        System.out.println("Select task:");
        Scanner in = new Scanner(System.in);
        switch (in.nextLine()){
            case "3.2" -> {
                String xml = """
                        <notes>
                          <note id = "1">
                            <to>Вася</to>
                            <from>Света</from>
                            <heading>Напоминание</heading>
                            <body>Позвони мне завтра!</body>
                          </note>
                          <note id = "2">
                            <to>Петя</to>
                            <from>Маша</from>
                            <heading>Важное напоминание</heading>
                            <body/>
                          </note>
                        </notes>                    
                        """;
                Task3_2 task3_2 = new Task3_2(xml);
                System.out.println(task3_2.xmlAnalyzer());
            }
            case "3.1" -> {
                String text = """
                        It was a bright cold day in April, and the
                        clocks were striking thirteen.

                        \u2029Winston Smith, his chin nuzzled into his breast in
                        an effort to escape the vile wind, slipped
                        quickly through the glass doors of Victory
                        Mansions, though not quickly enough to
                        prevent a swirl of gritty dust from entering
                        along with him.

                        \u2029The hallway smelt of boiled cabbage and
                        old rag mats. At one end of it a coloured
                        poster, too large for indoor display, had
                        been tacked to the wall.

                        \u2029It depicted simply an enormous face, more
                        than a metre wide: the face of a man of about\s
                        forty-five, with a heavy black moustache and ruggedly
                        handsome features.""";
                Task3_1 task3_1 = new Task3_1(text);
            }
            case "2.10" -> {
                String string = "Number. of large and! small letters.";
                Task2_10 task2_10 = new Task2_10();
                System.out.println(task2_10.countSentences(string));
            }
            case "2.9" -> {
                String string = "Number of large and small letters";
                Task2_9 task2_9 = new Task2_9();
                System.out.println(task2_9.countLowerCase(string));
                System.out.println(task2_9.countUpperCase(string));
            }
            case "2.8" -> {
                String string = "Проверка нахождения самого длинного слова";
                Task2_8 task2_8 = new Task2_8();
                System.out.println(task2_8.findingTheLongestWord(string));
            }
            case "2.7" -> {
                String string = "aaqwr fmaotgmafv";
                Task2_7 task2_7 = new Task2_7();
                System.out.println(task2_7.stringFormatting(string));
            }
            case "2.6" -> {
                String string = "aaqwrfmaotgmafv";
                Task2_6 task2_6 = new Task2_6();
                System.out.println(task2_6.doubleLetter(string));
            }
            case "2.5" -> {
                String string = "aaqwrfmaotgmafv";
                String letter  = "a";
                Task2_5 task2_5 = new Task2_5();
                System.out.println(task2_5.letterCountSearch(string,letter));
            }
            case "2.4" -> {
                String sourceWord = "информатика";
                String requiredWord  = "тортe";
                Task2_4 task2_4 = new Task2_4();
                System.out.println(task2_4.wordCreation(sourceWord,requiredWord));
            }
            case "2.3" -> {
                String string = "asa";
                Task2_3 task2_3 = new Task2_3();
                System.out.println(task2_3.palindromInspection(string));
            }
            case "2.2" -> {
                String string = "am  OMOmvm 0651f a8fv6a";
                Task2_2 task2_2 = new Task2_2();
                System.out.println(task2_2.insertingAAfterB(string));
            }
            case "2.1" -> {
                String string = "m  OMOmvm   0651f a8fv6";
                Task2_1 task2_1 = new Task2_1();
                System.out.println(task2_1.findingTheMostGaps(string));
            }
            case "1.5" -> {
                String string = " mOMOmvm     0 f 651 fa8fv 6";
                Task1_5 task1_5 = new Task1_5();
                System.out.println(task1_5.searchNumber(string));
            }
            case "1.4" -> {
                String string = "m7OMO48mvm 0 f 651 fa8fv 6";
                Task1_4 task1_4 = new Task1_4();
                System.out.println(task1_4.searchNumber(string));
            }
            case "1.3" -> {
                String string = "7mOMOmvm 0 f 6518 fa8fv 6";
                Task1_3 task1_3 = new Task1_3();
                System.out.println(task1_3.searchDigit(string));
            }
            case "1.2" -> {
                String sourceString = "text consists of words and words of letters";
                Task1_2 task1_2 = new Task1_2();
                System.out.println(sourceString);
                System.out.println(task1_2.replacementWorldOnLetter(sourceString,"word","letter"));
            }
            case "1.1" -> {
                String[] camelCase = {"camelCase", "toLowerCase", "getChars", "isLowerCase"};
                String[] snake_case;
                Task1_1 task1_1 = new Task1_1();
                snake_case = task1_1.toSnakeCase(camelCase);
                System.out.println(String.join(" ", camelCase));
                System.out.println(String.join(" ", snake_case));
            }
            default -> System.out.println("Task not found");

        }
    }
}
