package by.epam.introduction_to_java.unit06.task03.client.service.impl;


import by.epam.introduction_to_java.unit06.task03.client.service.ClientServiceI;

public final class ServiceProvider {
    private static final ServiceProvider provider = new ServiceProvider();

    private final ClientServiceI clientService = new ClientService();

    private ServiceProvider() {
    }

    public static ServiceProvider getProvider() {
        return provider;
    }

    public ClientServiceI getClientService() {
        return clientService;
    }
}
