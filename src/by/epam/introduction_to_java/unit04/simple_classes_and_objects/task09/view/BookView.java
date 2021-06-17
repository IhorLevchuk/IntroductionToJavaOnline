package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task09.view;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task09.bean.Book;

import java.util.List;

public class BookView {

    public void printBooks(List<Book> list){
        StringBuilder string = new StringBuilder();
        for(Book book: list){
            string.append(book).append("\n");
        }
        System.out.println(string);
    }
}
