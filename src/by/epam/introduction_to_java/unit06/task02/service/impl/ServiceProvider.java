package by.epam.introduction_to_java.unit06.task02.service.impl;

import by.epam.introduction_to_java.unit06.task02.service.NoteServiceI;

public class ServiceProvider {
    private static final ServiceProvider provider = new ServiceProvider();

    private final NoteServiceI noteService = new NoteService();

    private ServiceProvider() {
    }

    public static ServiceProvider getProvider(){
        return provider;
    }

    public NoteServiceI getNoteService() {
        return noteService;
    }
}
