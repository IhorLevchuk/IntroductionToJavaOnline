package by.epam.introduction_to_java.unit06.task01.presentation;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;

import java.util.List;

public interface BookActionViewI {

    String booksView(List<Book> list);
    String errorView();
    String addBookView(boolean result);
    String removeBookView(boolean removeBook);
}
