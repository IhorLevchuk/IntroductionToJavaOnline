package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.controller.Command;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.presentation.BookActionViewI;
import by.epam.introduction_to_java.unit06.task01.presentation.impl.ViewProvider;
import by.epam.introduction_to_java.unit06.task01.service.BookServiceI;
import by.epam.introduction_to_java.unit06.task01.service.impl.ServiceProvider;

public class AddPaperBookCommand implements Command {
    @Override
    public String execute(String[] params) {
        ViewProvider viewProvider = ViewProvider.getProvider();
        BookActionViewI bookActionView = viewProvider.getBookActionView();

        ServiceProvider serviceProvider = ServiceProvider.getProvider();
        BookServiceI bookService = serviceProvider.getBookService();

        String author, name, id, pages;
        id = params[1].split("=")[1];
        author = params[2].split("=")[1];
        pages = params[3].split("=")[1];
        name = params[4].split("=")[1];

        try {
            return bookActionView.addBookView(bookService.addPaperBook(Integer.parseInt(id),author,Integer.parseInt(pages),name));
        } catch (ServiceException e) {
            return bookActionView.errorView();
        }
    }
}
