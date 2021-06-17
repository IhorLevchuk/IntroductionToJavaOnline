package by.epam.introduction_to_java.unit06.task02.controller.impl;

import by.epam.introduction_to_java.unit06.task02.controller.Command;
import by.epam.introduction_to_java.unit06.task02.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task02.presentation.NoteActionViewI;
import by.epam.introduction_to_java.unit06.task02.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task02.service.NoteServiceI;
import by.epam.introduction_to_java.unit06.task02.service.impl.ServiceProvider;

public class AddNoteCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        NoteServiceI noteService = serviceProvider.getNoteService();

        ViewProvider viewProvider = ViewProvider.getProvider();
        NoteActionViewI noteActionView = viewProvider.getNoteActionView();

        String topic, email, text;
        topic = params[1].split("=")[1];
        email = params[2].split("=")[1];
        text = params[3].split("=")[1];

        try {
            return noteActionView.addNoteView(noteService.addNote(topic,email,text));
        } catch (ServiceException e) {
            return noteActionView.errorView();
        }
    }
}
