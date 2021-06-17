package by.epam.introduction_to_java.unit06.task01.service.impl;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.bean.book.EBook;
import by.epam.introduction_to_java.unit06.task01.bean.book.PaperBook;
import by.epam.introduction_to_java.unit06.task01.dao.impl.DAOProvider;
import by.epam.introduction_to_java.unit06.task01.exception.DAOException;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task01.service.BookServiceI;

import java.util.List;

public class BookService implements BookServiceI {
    private final DAOProvider provider = DAOProvider.getProvider();

    @Override
    public List<Book> searchByID(int id) throws ServiceException {
        try {
            return provider.getBookDAO().searchByID(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Book> searchByName(String name) throws ServiceException {
        try {
            return provider.getBookDAO().searchByName(name);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Book> cataloging(int page) throws ServiceException {
        List<Book> books;
        int numberEntriesOnPage = 2;
        int numberOfBooks = 0;
        try {
            numberOfBooks = provider.getBookDAO().getNumberOfBooks();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        int numberOfPages;
        int from, to;
        if(numberOfBooks%numberEntriesOnPage == 0){
            numberOfPages = numberOfBooks/numberEntriesOnPage;
        } else numberOfPages = numberOfBooks/numberEntriesOnPage + 1;

        if (page <= 0){
            page = 1;
        } else {
            if (page >= numberOfPages) {
                page = numberOfPages;
            }
        }
        from = numberEntriesOnPage*(page-1);
        to = page*numberEntriesOnPage-1;

        try {
            books = provider.getBookDAO().getBooks(from, to);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return books;
    }

    @Override
    public boolean addEBook(int id, String author, int pages, String name) throws ServiceException {
        Book book = new EBook(id, author, pages, name);
        sendMessagesAboutAddingBook(book);
        try {
            return provider.getBookDAO().addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean removeBook(int id) throws ServiceException {
        try {
            return provider.getBookDAO().removeBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addPaperBook(int id, String author, int pages, String name) throws ServiceException {
        Book book = new PaperBook(id, author, pages, name);
        sendMessagesAboutAddingBook(book);
        try {
            return provider.getBookDAO().addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void sendMessagesAboutAddingBook(Book book) throws ServiceException {
        StringBuilder message = new StringBuilder();
        message.append("Добавлена книга: \n").append(book.getInf());
        try {
            provider.getProfileDAO().sendMessageToUsers(message.toString());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
