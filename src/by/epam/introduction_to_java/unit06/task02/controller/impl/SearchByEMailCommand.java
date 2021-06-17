package by.epam.introduction_to_java.unit06.task02.controller.impl;

import by.epam.introduction_to_java.unit06.task02.controller.Command;
import by.epam.introduction_to_java.unit06.task02.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task02.presentation.NoteActionViewI;
import by.epam.introduction_to_java.unit06.task02.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task02.service.NoteServiceI;
import by.epam.introduction_to_java.unit06.task02.service.impl.ServiceProvider;

public class SearchByEMailCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        NoteServiceI noteService = serviceProvider.getNoteService();

        ViewProvider viewProvider = ViewProvider.getProvider();
        NoteActionViewI noteActionView = viewProvider.getNoteActionView();

        String email;
        email = params[1].split("=")[1];

        try {
            return noteActionView.notesView(noteService.searchByEMail(email));
        } catch (ServiceException e) {
            return noteActionView.errorView();
        }
    }
}