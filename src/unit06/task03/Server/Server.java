package unit06.task03.Server;

import unit06.task03.Action;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

public class Server extends Thread{
    Archive archive;

    public void run() {
        archive = new Archive();
        ServerSocket server;
        final int port = 8080;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                ServerThread thread = new ServerThread(socket,archive);
                thread.start();
            }
        } catch (IOException e){
            System.err.println(e);
        }

    }
}

class ServerThread extends Thread{
    private final PrintStream os;
    private final BufferedReader is;
    private final InetAddress addr;
    private final Archive archive;
    private Profile profile;

    public ServerThread(Socket socket, Archive archive) throws IOException {
        this.archive = archive;
        os = new PrintStream(socket.getOutputStream());
        is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        addr = socket.getInetAddress();
    }
    public  void run() {
        try {

            mainMenu();

        } catch (IOException e){
            System.err.println("Disconnect");
        } finally {
            disconnect();
        }
    }

    private void disconnect() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }

    private void sendAction(Action action){
        sendMessage(action.name());
    }

    private void logIn() throws IOException {
            sendAction(Action.LOGIN);

            sendMessage("Логин:");
            String login = is.readLine();
            sendMessage("Пароль:");
            String password = is.readLine();

            synchronized (archive) {
                if (archive.validateClient(login, password)){
                    profile = archive.getClient(login, password);
                    sendMessage(profile.toString());

                    if(profile.getAccess().equals(Access.ADMIN)){
                        adminMenu();
                    } else userMenu();

                } else sendMessage("Неверный логин или пароль");
            }
    }

    private void mainMenu() throws IOException {
        boolean loop = true;
        while (loop){
            sendAction(Action.MAINMENU);
            String message = """
                    Выберите действие:
                    1. Авторизация
                    2. Выход
                    """;
            sendMessage(message);
            switch (is.readLine()){
                case "2" ->{
                    loop = false;
                    sendAction(Action.END);
                }
                case "1" -> logIn();
            }
        }
    }

    private void adminMenu() throws IOException {
        boolean loop = true;
        while (loop){
            sendAction(Action.ADMINMENU);
            String message = """
                    1. Запрос дела по ID
                    2. Создать дело
                    3. Внести изменения
                    4. Выйти
                    """;
            sendMessage(message);
            switch (is.readLine()){
                case "4" -> loop = false;
                case "3" -> changeCase();
                case "2" -> createCase();
                case "1" -> requestCase();
            }
        }
    }

    private void userMenu() throws IOException {
        boolean loop = true;
        while (loop){
            sendAction(Action.USERMENU);
            String message = """
                    1. Запрос дела по ID
                    2. Выйти
                    """;
            sendMessage(message);
            switch (is.readLine()){
                case "2" -> loop = false;
                case "1" -> requestCase();
            }
        }
    }

    private void createCase() throws IOException {
        Student student = new Student();
        String string;
        boolean valid = true;

        sendAction(Action.CREATECASE);

        sendMessage("Добавление студента\nID:");
        string = is.readLine();
        if (Pattern.matches("\\d+", string)){
            student.setId(Integer.parseInt(string));
        } else valid = false;

        sendMessage("ФИО:\n");
        student.setName(is.readLine());

        sendMessage("Факультет:\n");
        student.setFaculty(is.readLine());

        sendMessage("Возраст:\n");

        string = is.readLine();
        if (Pattern.matches("\\d+", string)){
            student.setAge(Integer.parseInt(string));
        } else valid = false;

        sendMessage("Средняя оценка:\n");
        string = is.readLine();
        if (Pattern.matches("\\d+", string)){
            student.setAverageMark(Integer.parseInt(string));
        } else valid = false;

        if (valid){
            synchronized (archive) {
                archive.addCase(student);
            }
            sendMessage("Данные заполнены корректно.\n");
        } else sendMessage("Некорректные данные.\n");
    }

    private Student requestCase() throws IOException {
        sendAction(Action.REQUESTCASE);
        sendMessage("ID:");
        Student student;
        String string = is.readLine();
        synchronized (archive) {
            if (Pattern.matches("\\d+", string) && (archive.requestCase(Integer.parseInt(string))) != null){
                student = archive.requestCase(Integer.parseInt(string));
                sendMessage(student.toString());
                return student;
            } else sendMessage("Неверный формат ввода");
            return null;
        }
    }

    private void changeCase() throws IOException {
        Student student = requestCase();

        if (student == null){
            return;
        }

        String string;
        boolean loop = true;
        while (loop){
            sendAction(Action.CHANGECASE);
            String message = """
                    1. Изменить ID
                    2. Изменить ФИО
                    3. Изменить факультет
                    4. Изменить возраст
                    5. Изменить среднюю оценку
                    6. Закончить изменения
                    """;
            sendMessage(message);
            switch (is.readLine()){
                case "6" -> {
                    loop = false;
                    synchronized (archive) {
                        archive.saveArchive();
                    }
                    sendMessage("Данные сохранены\n");
                    is.readLine();
                }
                case "5" -> {
                    sendMessage("Новыя средняя оценка:\n");
                    string = is.readLine();
                    if (Pattern.matches("\\d+", string)){
                        student.setAverageMark(Integer.parseInt(string));
                    }
                }
                case "4" -> {
                    sendMessage("Новый возраст:\n");
                    string = is.readLine();
                    if (Pattern.matches("\\d+", string)){
                        student.setAge(Integer.parseInt(string));
                    }
                }
                case "3" -> {
                    sendMessage("Новый факультет:\n");
                    student.setFaculty(is.readLine());
                }
                case "2" -> {
                    sendMessage("Новое ФИО:\n");
                    student.setName(is.readLine());
                }
                case "1" -> {
                    sendMessage("Новый ID:\n");
                    string = is.readLine();
                    if (Pattern.matches("\\d+", string)){
                        student.setId(Integer.parseInt(string));
                    }
                }
            }
        }

    }

    private void sendMessage(String string){
        String[] masString = string.split("\n");
        os.print(masString.length+"\n");
        for (String str: masString){
            os.print(str+"\n");
        }
    }

}