package by.epam.introduction_to_java.unit06.task01.service;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.exception.ServiceException;

import java.util.List;

public interface BookServiceI {

    List<Book> searchByID(int id) throws ServiceException;
    List<Book> searchByName(String name) throws ServiceException;
    List<Book> cataloging(int page) throws ServiceException;
    boolean addEBook(int id, String author, int pages, String name) throws ServiceException;
    boolean removeBook(int id) throws ServiceException;
    boolean addPaperBook(int id, String author, int pages, String name) throws ServiceException;
}
