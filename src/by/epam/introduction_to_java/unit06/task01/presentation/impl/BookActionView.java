package by.epam.introduction_to_java.unit06.task01.presentation.impl;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.presentation.BookActionViewI;

import java.util.List;

public class BookActionView implements BookActionViewI {
    @Override
    public String booksView(List<Book> list) {
        StringBuilder stringList = new StringBuilder();
        for (Book book: list){
            stringList.append(book.getInf());
        }
        return stringList.toString();
    }

    @Override
    public String errorView() {
        return "Error";
    }

    @Override
    public String addBookView(boolean result) {
        if (result){
            return "Книга добавлена";
        }else return "Книга не добавлена.";
    }

    @Override
    public String removeBookView(boolean result) {
        if (result){
            return "Книга удалена.";
        }else return "Книга не не удалена.";
    }
}
