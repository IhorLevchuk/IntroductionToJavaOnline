package by.epam.introduction_to_java.unit06.task03.client.service.impl;



import by.epam.introduction_to_java.unit06.task03.client.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task03.client.service.ClientServiceI;
import by.epam.introduction_to_java.unit06.task03.client.view.OutPut;
import by.epam.introduction_to_java.unit06.task03.client.view.impl.OutPutProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientService implements ClientServiceI {
    private final OutPutProvider outPutProvider = OutPutProvider.getProvider();
    private final OutPut outPut = outPutProvider.getOutPutOnConsole();
    private Scanner scanner;

    public Socket socket;
    public BufferedReader is;
    public PrintStream os;

    {
        try {
            connection();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private String sendRequestAndReceiveResponse(String request) throws ServiceException {
        os.print(request);
        try {
            return is.readLine();
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    private void connection() throws ServiceException {
        scanner = new Scanner(System.in);
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8080);
            os = new PrintStream(socket.getOutputStream());
            is = new BufferedReader(new InputStreamReader( socket.getInputStream()));
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    private void closeConnection() throws ServiceException {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                throw new ServiceException(e);
            }
        }
        if (socket!= null) {
            try {
                socket.close();
            } catch (IOException e) {
                throw new ServiceException(e);
            }
        }
    }

    public void mainMenu() throws ServiceException {
        boolean loop = true;
        while (loop){
            String message = """
                    Выберите действие:
                    1. Авторизация
                    2. Выход
                    """;
            outPut.doOutPyt(message);
            switch (scanner.next()){
                case "2" ->{
                    loop = false;
                    closeConnection();
                }
                case "1" -> authorization();
            }
        }
    }

    private void adminMenu() throws ServiceException {
        boolean loop = true;
        while (loop){
            String message = """
                    1. Запрос дела по ID
                    2. Создать дело
                    3. Внести изменения
                    4. Выйти
                    """;
            outPut.doOutPyt(message);
            switch (scanner.next()){
                case "4" -> loop = false;
                case "3" -> changeCase();
                case "2" -> createCase();
                case "1" -> requestCase();
            }
        }
    }

    private void userMenu() throws ServiceException {
        boolean loop = true;
        while (loop){
            String message = """
                    1. Запрос дела по ID
                    2. Выйти
                    """;
            outPut.doOutPyt(message);
            switch (scanner.next()){
                case "2" -> loop = false;
                case "1" -> requestCase();
            }
        }
    }

    private void authorization() throws ServiceException {
        StringBuilder request = new StringBuilder("[authorization]");

        outPut.doOutPyt("Логин:");
        request.append("[login=").append(scanner.next()).append("]");
        outPut.doOutPyt("Пароль:");
        request.append("[password=").append(scanner.next()).append("]\n");

        String response;
        String[] responseSplit;

        response = sendRequestAndReceiveResponse(request.toString());
        responseSplit = response.substring(1,response.length()-1).split("\\]\\[");

        outPut.doOutPyt(response);

        if (!response.equals("Error")){
            if(responseSplit[0].split("=")[1].equals("ADMIN")){
                adminMenu();
            } if (responseSplit[0].split("=")[1].equals("USER")){
                userMenu();
            }
        }
    }


    private void requestCase() throws ServiceException {
        StringBuilder request = new StringBuilder("[requestCase]");
        outPut.doOutPyt("ID:");
        request.append("[id=").append(scanner.next()).append("]\n");

        outPut.doOutPyt(sendRequestAndReceiveResponse(request.toString()));
    }

    private void createCase() throws ServiceException {
        StringBuilder request = new StringBuilder("[createCase]");

        outPut.doOutPyt("Добавление студента\nID:");
        request.append("[id=").append(scanner.next()).append("]");

        outPut.doOutPyt("ФИО:");
        scanner.nextLine();
        request.append("[name=").append(scanner.nextLine()).append("]");

        outPut.doOutPyt("Факультет:");
        request.append("[faculty=").append(scanner.next()).append("]");

        outPut.doOutPyt("Возраст:");
        request.append("[age=").append(scanner.next()).append("]");

        outPut.doOutPyt("Средняя оценка:");
        request.append("[averageMark=").append(scanner.next()).append("]\n");

        sendRequestAndReceiveResponse(request.toString());
    }

    private void changeCase() throws ServiceException {
        StringBuilder request = new StringBuilder("[changeCase]");

        outPut.doOutPyt("Изменение дела\nID:");
        request.append("[id=").append(scanner.nextInt()).append("]");

        String name, faculty, age, averageMark;
        name = "default";
        faculty = "default";
        age = "default";
        averageMark = "default";

        boolean loop = true;
        while (loop){
            String message = """
                    1. Изменить ФИО
                    2. Изменить факультет
                    3. Изменить возраст
                    4. Изменить среднюю оценку
                    5. Закончить изменения
                    """;
            outPut.doOutPyt(message);
            switch (scanner.next()){
                case "5" -> loop = false;
                case "4" -> {
                    outPut.doOutPyt("Новыя средняя оценка:");
                    averageMark = scanner.next();
                }
                case "3" -> {
                    outPut.doOutPyt("Новый возраст:");
                    age = scanner.next();
                }
                case "2" -> {
                    outPut.doOutPyt("Новый факультет:");
                    faculty = scanner.next();
                }
                case "1" -> {
                    outPut.doOutPyt("Новое ФИО:");
                    name = scanner.next();
                }
            }
        }

        request.append("[name=").append(name).append("]");
        request.append("[faculty=").append(faculty).append("]");
        request.append("[age=").append(age).append("]");
        request.append("[averageMark=").append(averageMark).append("]\n");

        sendRequestAndReceiveResponse(request.toString());
    }

}
