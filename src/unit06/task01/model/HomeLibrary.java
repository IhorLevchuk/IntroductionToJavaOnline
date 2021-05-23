package unit06.task01.model;

import unit06.task01.Book.Book;
import unit06.task01.Book.EBook;
import unit06.task01.Book.PaperBook;
import unit06.task01.profile.Admin;
import unit06.task01.profile.Profile;
import unit06.task01.profile.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeLibrary {
    private final Menu menu;
    private Profile activeProfile;
    private final ArrayList<Profile> profiles;
    private final ArrayList<Book> books;
    private final String fileNameProfiles = "src/unit06/task01/files/Profiles.txt";
    private final String fileNameBook = "src/unit06/task01/files/Books.txt";


    public HomeLibrary() {
        profiles = new ArrayList<>();
        books = new ArrayList<>();
        getDate(profiles, fileNameProfiles);
        getDate(books, fileNameBook);
        menu = new Menu();
        menu.mainMenu();
    }

    private <T> void getDate(ArrayList<T> writeTo,String fileName){
        File data = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(data);
            istream = new ObjectInputStream(fis);
            while (true){
                writeTo.add((T) istream.readObject());
            }
        } catch (ClassNotFoundException ce) {
            System.err.println("Класс не существует: " + ce);
        } catch (FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: "+ e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
           // System.err.println("Общая I/O ошибка: " + ioe);
        }
        finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока ");
            }
        }
    }

    private <T> boolean addDate(ArrayList<T> readTo, String fileName){
        boolean flag = false;
        File users = new File(fileName);

        ObjectOutputStream ostream = null;

        try {
            FileOutputStream fos = new FileOutputStream(users,false);
            ostream = new ObjectOutputStream(fos);

            for(T ob: readTo){
                ostream.writeObject(ob);
            }
            flag = true;
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: "+ e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока");
            }
        }
        return flag;
    }

    private ArrayList<Book> searchBook(int id){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books){
            if(book.getId() == id){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    private ArrayList<Book> searchBook(String name){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: books){
            if(book.getName().equals(name)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    private <T> void printArray(ArrayList<T> arrayList){
        StringBuilder stringArrayList = new StringBuilder();
        for (T book: arrayList){
            stringArrayList.append(book).append("\n");
        }
        System.out.println(stringArrayList);
    }

    private boolean authorization(String login, byte[] password){
        for (Profile profile: profiles){
            if(profile.getLogin().equals(login) && Arrays.equals(profile.getPassword(), password)){
                activeProfile = profile;
                return true;
            }
        }
        activeProfile = new Profile();
        return false;
    }

    private void sendingMessagesAboutAdding(Book book){
        String message = "Добавлена книга: " + book.toString();
        for(Profile profile: profiles){
            if(profile.getClass() == User.class){
                activeProfile.getEmail().send(profile.getEmail(), message);
            }
        }
    }
    private void messageWithProposal(Book book){
        String message = "Предлогаю: " + book.toString();
        for(Profile profile: profiles){
            if(profile.getClass() == Admin.class){
                activeProfile.getEmail().send(profile.getEmail(), message);
            }
        }
    }

    private void cataloging() throws InputMismatchException{
        int numberEntriesOnPage = 2;
        int page = 1;
        int numberOfPages;
        if(books.size()%numberEntriesOnPage == 0){
            numberOfPages = books.size()/numberEntriesOnPage;
        } else numberOfPages = books.size()/numberEntriesOnPage + 1;

        while (page > 0){
            for(int i = numberEntriesOnPage*(page-1); i < page*numberEntriesOnPage; i++){
                if(i < books.size()){
                    System.out.println(books.get(i));
                } else System.out.println();
            }

            switch (menu.viewMenu()){
                case 3 -> page = -1;
                case 2 ->{
                    if (page-1 >= 1){
                        page -= 1;
                    }
                }
                case 1 ->{
                    if (page+1 <= numberOfPages){
                        page += 1;
                    }
                }
            }

        }

    }

    private boolean removeBook(int id){
        books.removeIf(book -> book.getId() == id);
        return addDate(books, fileNameBook);
    }

    private boolean addBook(Book book) throws InputMismatchException{
        books.add(menu.fillingOutBook(book));
        if(addDate(books, fileNameBook)){
            sendingMessagesAboutAdding(book);
            addDate(profiles, fileNameProfiles);
            return true;
        }
        getDate(books, fileNameBook);
        return false;
    }

    private boolean registration(Profile profile){
        profiles.add(profile);
        return addDate(profiles, fileNameProfiles);
    }


    class Menu{
        Scanner scanner;

        public Menu() {
            scanner = new Scanner(System.in);
        }

        public void mainMenu(){
            System.out.println("""
                Пожалуйса, выберите действие:
                1. Авторизация
                2. Зарегестрироваться
                3. Выход
                """);
            try {
                switch (scanner.nextInt()){
                    default -> System.out.println("Неверный ввод");
                    case 3 -> System.exit(0);
                    case 2 -> {
                        if(profiling(new User())){
                            System.out.println("Регистация прошла успешно.\n\n");
                        } else System.out.println("Ошибка регистрации.\n\n");
                    }
                    case 1 ->{
                        consoleAuthorization();

                        if(activeProfile.getClass() == User.class){
                            userMenu();
                        } else if (activeProfile.getClass() == Admin.class){
                            adminMenu();
                        }
                    }
                }
            } catch (InputMismatchException ime){
                System.out.println("Неправильный формат ввода данных\n");
                scanner.nextLine();
            }
            addDate(profiles, fileNameProfiles);
            mainMenu();
        }

        public void userMenu(){
            System.out.println("""
                Пожалуйса, выберите действие:
                1. Поиск по ID
                2. Поиск по названию
                3. Просмотр каталога
                4. Просмотр сообщений
                5. Предложить электронную книгу
                6. Предложить бумажную книгу
                7. Выход
                """);

            try {
            switch (scanner.nextInt()){
                default -> System.out.println("Неверный ввод");
                case 7 ->{
                    return;
                }
                case 6 -> {
                    messageWithProposal(fillingOutBook(new PaperBook()));
                    addDate(profiles, fileNameProfiles);
                }
                case 5 -> {
                    messageWithProposal(fillingOutBook(new EBook()));
                    addDate(profiles, fileNameProfiles);
                }
                case 4 -> printArray(activeProfile.getEmail().getMessages());
                case 3 -> cataloging();
                case 2 ->{
                    System.out.println("Введите Название\n");
                    scanner.nextLine();
                    printArray(searchBook(scanner.nextLine()));
                }
                case 1 ->{
                    System.out.println("Введите ID\n");
                    printArray(searchBook(scanner.nextInt()));
                }
            }
            } catch (InputMismatchException ime){
                System.out.println("Неправильный формат ввода данных\n");
                scanner.nextLine();
            }
            userMenu();
        }

        public void adminMenu() throws InputMismatchException{
            System.out.println("""
                Пожалуйса, выберите действие:
                1. Поиск по ID
                2. Поиск по названию
                3. Просмотр каталога
                4. Добавить электронную книгу
                5. Добавить бумажную книгу
                6. Удалить книгу
                7. Добавить администратора
                8. Просмотр сообщений
                9. Выход
                """);

            try {
            switch (scanner.nextInt()){
                default -> System.out.println("Неверный ввод");
                case 9 -> {
                    return;
                }
                case 8 -> printArray(activeProfile.getEmail().getMessages());
                case 7 -> {
                    if(profiling(new Admin())){
                        System.out.println("Регистация прошла успешно.\n\n");
                    } else System.out.println("Ошибка регистрации.\n\n");
                }
                case 6 ->{
                    System.out.println("Введите ID\n");
                    if(removeBook(scanner.nextInt())){
                        System.out.println("Удаление книги завершено успешно.\n\n");
                    }
                }
                case 5 -> {
                    if (addBook(new PaperBook())){
                        System.out.println("Добавление книги завершено успешно.\n\n");
                    }
                }
                case 4 -> {
                    if (addBook(new EBook())){
                        System.out.println("Добавление книги завершено успешно.\n\n");
                    }
                }
                case 3 -> cataloging();
                case 2 ->{
                    System.out.println("Введите Название\n");
                    printArray(searchBook(scanner.nextLine()));
                }
                case 1 ->{
                    System.out.println("Введите ID\n");
                    printArray(searchBook(scanner.nextInt()));
                }
            }
            } catch (InputMismatchException ime){
                System.out.println("Неправильный формат ввода данных\n");
                scanner.nextLine();
            }
            adminMenu();
        }

        private int viewMenu(){
            System.out.println("""
                        
                        1. Следующая
                        2. Предыдущая
                        3. Закончить просмотр
                        """);
            return scanner.nextInt();
        }

        private void consoleAuthorization(){
            String login;
            byte[] password;
            System.out.println("Введите логин:");
            login = scanner.next();
            System.out.println("Введите пароль:");
            password = Profile.getHash(scanner.next());

            StringBuilder string = new StringBuilder();
            if(authorization(login,password)){
                string.append("Вход выполнен успешно").append("\n").append("Вы вошли как \n")
                        .append(activeProfile);
                System.out.println(string);
            } else {
                System.out.println("Ошибка автоизации");
            }
        }

        private Book fillingOutBook(Book book) throws InputMismatchException{
            System.out.println("Книга\n Введите ID:");
            book.setId(scanner.nextInt());

            System.out.println("Добавте атора:");
            book.setAuthor(createAuthor());

            System.out.println("Введите количество страниц:");
            book.setNumberOfPages(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Введите название:");
            book.setName(scanner.nextLine());
            return book;

        }

        private Author createAuthor() throws InputMismatchException{
            Author author = new Author();
            System.out.println("Введите имя:");
            author.setName(scanner.next());
            System.out.println("Введите фамилию:");
            author.setSurname(scanner.next());
            System.out.println("Введите отчество:");
            author.setPatronymic(scanner.next());
            return author;
        }

        private boolean profiling(Profile profile) throws InputMismatchException {
            System.out.println("Регистация\n Введите имя:");
            profile.setName(scanner.next());
            System.out.println("Введите фамилию:");
            profile.setSurname(scanner.next());
            System.out.println("Введите отчество:");
            profile.setPatronymic(scanner.next());
            System.out.println("Введите e-mail:");
            profile.setEmail(new EMail(scanner.next()));
            System.out.println("Введите логин:");
            profile.setLogin(scanner.next());
            System.out.println("Введите пароль:");
            profile.setPassword(scanner.next());

            return registration(profile);
        }
    }
}
