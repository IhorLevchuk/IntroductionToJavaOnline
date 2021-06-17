package by.epam.introduction_to_java.unit06.task01.menu;

import by.epam.introduction_to_java.unit06.task01.controller.Controller;
import by.epam.introduction_to_java.unit06.task01.controller.impl.BookController;
import by.epam.introduction_to_java.unit06.task01.controller.impl.ProfileController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{
    private final Scanner scanner;
    private final Controller bookController;
    private final Controller profileController;

    public Menu() {
        scanner = new Scanner(System.in);
        bookController = new BookController();
        profileController = new ProfileController();
        mainMenu();
    }

    private void print(String string){
        System.out.println(string);
    }

    public void mainMenu(){
        print("""
                Выберите действие:
                1. Авторизация
                2. Зарегестрироваться
                3. Выход
                """);

        switch (scanner.nextInt()){
            default -> print("Неверный ввод");
            case 3 -> System.exit(0);
            case 2 -> {
                String request;
                request = registration();
                print(profileController.doAction(request));
            }
            case 1 ->{
                String request;
                String[] responseSplit;
                request = authorization();
                String response = profileController.doAction(request);
                responseSplit = response.split("\\s+");

                print(response);
                if (!response.equals("Неверный логин или пароль.") && !response.equals("Error")){
                    if(responseSplit[6].equals("User")){
                        userMenu();
                    } else if (responseSplit[6].equals("Admin")){
                        adminMenu();
                    }
                }
            }
        }
        mainMenu();
    }

    public void userMenu(){
        print("""
                Выберите действие:
                1. Поиск по ID
                2. Поиск по названию
                3. Просмотр каталога
                4. Просмотр сообщений
                5. Предложить электронную книгу
                6. Предложить бумажную книгу
                7. Выход
                """);

        switch (scanner.nextInt()){
            default -> print("Неверный ввод");
            case 7 -> {
                profileController.doAction("logOut");
                return;
            }
            case 6 -> {
                String request;
                request = "proposalAddPaperBook" + fillingOutBook();
                print(profileController.doAction(request));
            }
            case 5 -> {
                String request;
                request = "proposalAddEBook" + fillingOutBook();
                print(profileController.doAction(request));
            }
            case 4 -> {
                String request;
                request = "getMessages";
                print(profileController.doAction(request));
            }
            case 3 -> {
                boolean loop = true;
                String request;
                int page = 1;
                do {
                    request = "cataloging page=" + page;
                    print(bookController.doAction(request));
                    switch (viewMenu()){
                        case 3 -> loop = false;
                        case 2 -> page -= 1;
                        case 1 -> page += 1;
                    }
                } while (loop);
            }
            case 2 ->{
                String request;
                print("Введите название\n");
                request = "searchByName name=" + scanner.next();
                print(bookController.doAction(request));
            }
            case 1 ->{
                String request;
                print("Введите ID\n");
                request = "searchByID ID=" + scanner.nextInt();
                print(bookController.doAction(request));
            }
        }
        userMenu();
    }

    public void adminMenu() throws InputMismatchException{
        System.out.println("""
                Выберите действие:
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

        switch (scanner.nextInt()){
            default -> print("Неверный ввод");
            case 9 -> {
                profileController.doAction("logOut");
                return;
            }
            case 8 -> {
                String request;
                request = "getMessages";
                print(profileController.doAction(request));
            }
            case 7 -> {
                String request;
                request = registration();
                print(profileController.doAction(request));
            }
            case 6 ->{
                String request;
                print("Введите ID\n");
                request = "removeBook id=" + scanner.nextInt();
                print(bookController.doAction(request));
            }
            case 5 -> {
                String request;
                request = "addPaperBook" + fillingOutBook();
                print(bookController.doAction(request));
            }
            case 4 -> {
                String request;
                request = "addEBook" + fillingOutBook();
                print(bookController.doAction(request));
            }
            case 3 -> {
                boolean loop = true;
                String request;
                int page = 1;
                do {
                    request = "cataloging page=" + page;
                    print(bookController.doAction(request));
                    switch (viewMenu()){
                        case 3 -> loop = false;
                        case 2 -> page -= 1;
                        case 1 -> page += 1;
                    }
                } while (loop);
            }

            case 2 ->{
                String request;
                print("Введите название\n");
                request = "searchByName name=" + scanner.next();
                print(bookController.doAction(request));
            }
            case 1 ->{
                String request;
                print("Введите ID\n");
                request = "searchByID id=" + scanner.nextInt();
                print(bookController.doAction(request));
            }
        }
        adminMenu();
    }

    private int viewMenu(){
        print("""
                        1. Следующая
                        2. Предыдущая
                        3. Закончить просмотр
                        """);
        return scanner.nextInt();
    }

    private String authorization(){
        String login;
        String password;
        print("Введите логин:");
        login = scanner.next();
        print("Введите пароль:");
        password = scanner.next();

        return "authorization " + "login=" + login +  " password=" + password;
    }

    private String fillingOutBook(){
        StringBuilder bookString = new StringBuilder();
        print("Заполнение книги\n Введите ID:");
        bookString.append(" id=").append(scanner.nextInt());

        print("Добавте атора:");
        bookString.append(" author=").append(scanner.next());

        print("Введите количество страниц:");
        bookString.append(" pages=").append(scanner.nextInt());
        scanner.nextLine();

        print("Введите название:");
        bookString.append(" name=").append(scanner.next());

        return bookString.toString();
    }

    private String registration() {
        StringBuilder profileString = new StringBuilder("registration ");
        print("Регистация\n Введите фамилию:");
        profileString.append("Surname=").append(scanner.next());
        print("Введите имя:");
        profileString.append(" Name=").append(scanner.next());
        print("Введите отчество:");
        profileString.append(" Patronymic=").append(scanner.next());
        print("Введите e-mail:");
        profileString.append(" Email=").append(scanner.next());
        print("Введите логин:");
        profileString.append(" Login=").append(scanner.next());
        print("Введите пароль:");
        profileString.append(" Password=").append(scanner.next());

        return profileString.toString();
    }
}
