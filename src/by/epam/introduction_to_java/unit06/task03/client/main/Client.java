package by.epam.introduction_to_java.unit06.task03.client.main;


import by.epam.introduction_to_java.unit06.task03.client.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task03.client.logger.Logger;
import by.epam.introduction_to_java.unit06.task03.client.service.ClientServiceI;
import by.epam.introduction_to_java.unit06.task03.client.service.impl.ServiceProvider;

public class Client extends Thread{

    public void run() {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        ClientServiceI clientService = serviceProvider.getClientService();
        try {
            clientService.mainMenu();
        } catch (ServiceException e) {
            Logger.log(e.getMessage());
        }
    }
}