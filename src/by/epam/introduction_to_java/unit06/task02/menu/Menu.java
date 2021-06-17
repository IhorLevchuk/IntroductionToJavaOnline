package by.epam.introduction_to_java.unit06.task02.menu;

import by.epam.introduction_to_java.unit06.task02.controller.Controller;
import by.epam.introduction_to_java.unit06.task02.controller.impl.NoteController;

import java.util.Scanner;

import static java.lang.System.*;

public class Menu {
    private final Scanner scanner;
    private final Controller NoteController;

    public Menu() {
        NoteController = new NoteController();
        scanner = new Scanner(in);
        mainMenu();
    }

    private void print(String string){
        out.println(string);
    }

    private void mainMenu() {
        while (true){
            print("""
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
            switch (scanner.nextInt()){
                default -> print("Некорректный ввод");
                case 9 -> exit(0);
                case 8 -> {
                    String request;
                    String topic;
                    print("Введите тему:");
                    topic = scanner.nextLine();
                    print("Введите дату в формате: YYYY MM DD");
                    request = "[searchByTopicAndDate][topic=" + topic + "][date=" +  scanner.nextInt() + " "
                              + scanner.nextInt() + " " + scanner.nextInt() + "]";
                    print(NoteController.doAction(request));
                }
                case 7 -> {
                    print("Введите текст:");
                    String request;
                    scanner.nextLine();
                    request = "[searchByText][text=" + scanner.nextLine() + "]";
                    print(NoteController.doAction(request));
                }
                case 6 -> {
                    print("Введите e-mail:");
                    String request;
                    request = "[searchByEMail][email=" + scanner.next() + "]";
                    print(NoteController.doAction(request));
                }
                case 5 -> {
                    print("Введите дату в формате: YYYY MM DD");
                    String request;
                    request = "[searchByDate][date=" +  scanner.nextInt() + " " + scanner.nextInt() + " " + scanner.nextInt() + "]";
                    print(NoteController.doAction(request));
                }
                case 4 -> {
                    print("Введите тему:");
                    scanner.nextLine();
                    String request;
                    request = "[searchByTopic][topic=" +  scanner.nextLine() + "]";
                    print(NoteController.doAction(request));
                }
                case 3 -> {
                    String request;
                    request = "[addNote]" + creatingNoteView();
                    print(NoteController.doAction(request));
                }
                case 2 -> {
                    print("Введите слово для поиска:");
                    String request;
                    request = "[getNotesContainingWord][word=" + scanner.next() + "]";
                    print(NoteController.doAction(request));
                }
                case 1 -> {
                    String request;
                    request = "[getAllNotes][sort=" + sortMenu() + "]";
                    print(NoteController.doAction(request));
                }
            }

            print("Для возврата в меню, нажмите Enter");
            scanner.nextLine();
        }

    }

    private String sortMenu(){
        while (true){
            print("""
                Отсортировать по:
                1. Дате
                2. Теме
                3. Не сортировать
                """);
            switch (scanner.nextInt()){
                default -> print("Некорректный ввод");
                case 3 -> {
                    return "not";
                }
                case 2 -> {
                    return "topic";
                }
                case 1 ->{
                    return "date";
                }
            }
        }
    }

    private String creatingNoteView(){
        StringBuilder request = new StringBuilder();
        print("Заполнение заметки:");

        print("Введите тему:");
        scanner.nextLine();
        request.append("[topic=").append(scanner.nextLine()).append("]");

        print("Введите e-mail:");
        request.append("[email=").append(scanner.next()).append("]");

        print("Добавте техт:");
        scanner.nextLine();
        request.append("[text=").append(scanner.nextLine()).append("]");

        return request.toString();
    }


}
