package by.epam.introduction_to_java.unit06.task03.server.main;


import by.epam.introduction_to_java.unit06.task03.server.controller.Controller;
import by.epam.introduction_to_java.unit06.task03.server.controller.impl.ControllerProvider;
import by.epam.introduction_to_java.unit06.task03.server.logger.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    public void run() {
        ServerSocket server;
        final int port = 8080;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e){
            Logger.log(e.getMessage());
        }

    }
}

class ServerThread extends Thread{
    private final PrintStream os;
    private final BufferedReader is;
    private final InetAddress addr;

    public ServerThread(Socket socket) throws IOException {
        os = new PrintStream(socket.getOutputStream());
        is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        addr = socket.getInetAddress();
    }

    public  void run() {

        ControllerProvider controllerProvider = ControllerProvider.getProvider();
        Controller archiveController = controllerProvider.getArchiveController();

        while (true){
            try {
                String request;
                while ((request = is.readLine()) != null){
                    os.print(archiveController.doAction(request));
                }
            } catch (IOException e) {
                Logger.log(e.getMessage());
                break;
            } finally {
                this.interrupt();
            }
        }
    }
}