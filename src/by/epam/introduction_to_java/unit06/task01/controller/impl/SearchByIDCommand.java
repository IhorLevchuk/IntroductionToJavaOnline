package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.controller.Command;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.presentation.BookActionViewI;
import by.epam.introduction_to_java.unit06.task01.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task01.service.BookServiceI;
import by.epam.introduction_to_java.unit06.task01.service.impl.ServiceProvider;

public class SearchByIDCommand implements Command {
    @Override
    public String execute(String[] params) {
        ViewProvider viewProvider = ViewProvider.getProvider();
        BookActionViewI bookActionView = viewProvider.getBookActionView();

        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        BookServiceI bookService = serviceProvider.getBookService();

        String id = params[1].split("=")[1];

        try {
            return bookActionView.booksView(bookService.searchByID(Integer.parseInt(id)));
        } catch (ServiceException e) {
            return bookActionView.errorView();
        }
    }
}
