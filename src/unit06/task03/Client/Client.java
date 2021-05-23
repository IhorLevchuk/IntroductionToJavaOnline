package unit06.task03.Client;

import unit06.task03.Action;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client extends Thread{

    Socket socket;
    BufferedReader is;
    PrintStream os;
    Scanner scanner;

    public void run() {
        try {
            scanner = new Scanner(System.in);
            socket = new Socket(InetAddress.getLocalHost(), 8080);
            os = new PrintStream(socket.getOutputStream());
            is = new BufferedReader(new InputStreamReader( socket.getInputStream()));


            while (choiceOfAction());

        } catch (UnknownHostException e) {
            System.err.println("адрес недоступен" + e);
        } catch (IOException e) {
            System.err.println("ошибка I/О потока" + e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!= null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Action takeAction() throws IOException {
        return Action.valueOf(takeMessage());
    }

    private boolean choiceOfAction() throws IOException {
        switch (takeAction()){
            case LOGIN -> {
                printingAndSendingOfScanned(2);
                System.out.println(takeMessage());
            }
            case MAINMENU,USERMENU,ADMINMENU -> printingAndSendingOfScanned(1);
            case REQUESTCASE -> {
                printingAndSendingOfScanned(1);
                System.out.println(takeMessage()+"\n");
            }
            case CREATECASE -> {
                printingAndSendingOfScanned(5);
                System.out.println(takeMessage());
            }
            case CHANGECASE -> printingAndSendingOfScanned(2);
            case END -> {return false;}
        }
        return true;
    }

    private void printingAndSendingOfScanned(int number) throws IOException {
        for (int i = 0; i < number; i++){
            System.out.println(takeMessage());
            os.print(scanner.nextLine() + "\n");
        }
    }

    private String takeMessage() throws IOException {
        StringBuilder string = new StringBuilder();
        int number = Integer.parseInt(is.readLine());
        for(int i = 0; i < number; i++){
            string.append(is.readLine());
            if(i != number-1) string.append("\n");
        }
        return string.toString();
    }
}