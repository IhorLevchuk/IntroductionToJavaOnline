package unit06.task02;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NoteBook{
    private final String delimiter = "------------------------";
    private final String fileNameNotes = "src/unit06/task02/files/Notes.txt";
    private ArrayList<Note> notes;

    public NoteBook() {
        notes = new ArrayList<>();
        readFile();
        new Menu().mainMenu();
    }

    public void addNote(Note note){
        notes.add(note);
    }

    private ArrayList<Note> search(String topic){
        return (ArrayList<Note>) notes.stream().filter(note -> note.getTopic().equals(topic)).collect(Collectors.toList());
    }

    private ArrayList<Note> search(Email email){
        return (ArrayList<Note>) notes.stream().filter(note -> note.getEmail().equals(email)).collect(Collectors.toList());
    }

    private ArrayList<Note> search(LocalDate date){
        return (ArrayList<Note>) notes.stream().filter(note -> note.getDate().equals(date)).collect(Collectors.toList());
    }

    private ArrayList<Note> search(Text text){
        return (ArrayList<Note>) notes.stream().filter(note -> note.getText().equals(text)).collect(Collectors.toList());
    }

    private ArrayList<Note> search(String topic, LocalDate date){
        return (ArrayList<Note>) notes.stream().filter(note -> note.getDate().equals(date) && note.getTopic().equals(topic))
                .collect(Collectors.toList());
    }

    private ArrayList<Note> sort(ArrayList<Note> notes, Comparator<Note> comparator){
        return (ArrayList<Note>) notes.stream().sorted(comparator).collect(Collectors.toList());
    }

    private ArrayList<Note> contain(String word){
        return (ArrayList<Note>) notes.stream().filter(note -> note.getText().contain(word)).collect(Collectors.toList());
    }

    private void printNotes(ArrayList<Note> notes){
        StringBuilder stringNotes = new StringBuilder();
        notes.forEach(note -> stringNotes.append(note).append("\n"));
        System.out.println(stringNotes);
    }

    private void readFile(){
        notes = new ArrayList<>();

        File file = new File(fileNameNotes);

        if (file.exists() && file.canRead()) {
            try (Scanner in = new Scanner(new FileReader(file))) {
                while (in.hasNextLine()) {
                    String topic = in.nextLine();
                    int year = in.nextInt();
                    int month = in.nextInt();
                    int day = in.nextInt();
                    in.nextLine();
                    String email = in.nextLine();
                    StringBuilder text = new StringBuilder("");
                    String nextLine = in.nextLine();

                    while (!nextLine.equals(delimiter)) {
                        text.append(nextLine);
                        if(!(nextLine = in.nextLine()).equals(delimiter)){
                            text.append("\n");
                        }
                    }

                    notes.add(new Note(topic, new Email(email), new Text(text.toString()), LocalDate.of(year,month,day)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveToFile(){

        File file = new File(fileNameNotes);

        if (file.setWritable(true)) {
            try (PrintWriter out = new PrintWriter(file)) {
                for (Note note : notes) {
                    out.println(note.getTopic());
                    out.println(note.getDate().getYear()+" "+note.getDate().getMonthValue()+" "+note.getDate().getDayOfMonth());
                    out.println(note.getEmail());
                    out.println(note.getText());
                    out.println(delimiter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error save file");
        }
    }

    class Menu{
        Scanner scanner;

        public Menu() {
            scanner = new Scanner(System.in);
        }

        private void mainMenu() {
            while (true){
                System.out.println("""
                Выберите действие:
                1. Показать все заметки
                2. Найти заметки, содержащие слово
                3. Добавить запись
                Поиск заметки по:
                4. Теме
                5. Дате создания
                6. Е-mail
                7. Тексту
                8. Теме и дате
                9. Выйти
                """);
                try {
                    switch (scanner.nextInt()){
                        default -> System.out.println("Некорректный ввод");
                        case 9 -> {
                            saveToFile();
                            System.exit(0);
                        }
                        case 8 -> {
                            System.out.println("Введите тему:");
                            scanner.nextLine();
                            String topic = scanner.nextLine();
                            System.out.println("Введите дату в формате:\nYYYY\nMM\nDD");
                            printNotes(sortMenu(search(topic, LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()))));
                        }
                        case 7 -> {
                            System.out.println("Введите текст:");
                            scanner.nextLine();
                            printNotes(sortMenu(search(new Text(scanner.nextLine()))));
                        }
                        case 6 -> {
                            System.out.println("Введите e-mail:");
                            printNotes(sortMenu(search(new Email(scanner.next()))));
                        }
                        case 5 -> {
                            System.out.println("Введите дату в формате:\nYYYY\nMM\nDD");
                            printNotes(sortMenu(search(LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()))));
                        }
                        case 4 -> {
                            System.out.println("Введите тему:");
                            scanner.nextLine();
                            printNotes(sortMenu(search(scanner.nextLine())));
                        }
                        case 3 -> {
                            recording();
                        }
                        case 2 -> {
                            System.out.println("Введите слово для поиска:");
                            printNotes(sortMenu(contain(scanner.next())));
                        }
                        case 1 -> printNotes(sortMenu(notes));
                    }
                } catch (InputMismatchException ime){
                    System.out.println("Неправильный формат ввода данных " + ime);
                    scanner.nextLine();
                }

                System.out.println("Для возврата в меню, нажмите Enter");
                scanner.nextLine();
                scanner.nextLine();
            }

        }

        private ArrayList<Note> sortMenu(ArrayList<Note> notes){
            while (true){
                System.out.println("""
                Отсортировать по:
                1. Дате
                2. Теме
                3. Не сортировать
                """);
                switch (scanner.nextInt()){
                    default -> System.out.println("Некорректный ввод");
                    case 3 -> {
                        return notes;
                    }
                    case 2 -> {
                        return sort(notes,Note.topicComparator);
                    }
                    case 1 ->{
                        return sort(notes,Note.dateComparator);
                    }
                }
            }
        }

        private void recording(){
            Note note = new Note();
            Email email = new Email();
            System.out.println("Заполнение заметки:");
            scanner.nextLine();

            while (true){
                System.out.println("Введите тему:");
                if(note.setTopic(scanner.nextLine())){
                    break;
                }
                System.out.println("Тема обязательна для заполнения");
            }

            while (true){
                System.out.println("Введите e-mail:");
                if(email.setEmail(scanner.next())){
                    note.setEmail(email);
                    break;
                }
                System.out.println("Некорректный формат e-mail.");
            }

            System.out.println("Добавте техт:");
            scanner.nextLine();
            note.setText(new Text(scanner.nextLine()));

            addNote(note);
        }
    }

}
