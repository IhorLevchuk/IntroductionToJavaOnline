package by.epam.introduction_to_java.unit06.task01.dao;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.exception.DAOException;

import java.util.List;

public interface BookDAO {

    List<Book> searchByID(int id) throws DAOException;
    List<Book> searchByName(String name) throws DAOException;
    int getNumberOfBooks() throws DAOException;
    List<Book> getBooks (int from, int to) throws DAOException;
    boolean addBook(Book book) throws DAOException;
    boolean removeBook(int id) throws DAOException;
}
