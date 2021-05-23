package unit04.simple_classes_and_objects.task09;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookBase {
    ArrayList<Book> bookBase;

    public BookBase(ArrayList<Book> bookBase) {
        this.bookBase = bookBase;
    }

    public BookBase() {
        this.bookBase = new ArrayList<>();
    }

    public void addBook(int id, String name, String authors, String publisher, int yearOfPublication, int numberOfPages, double price, int bindingType){
        bookBase.add(new Book(id, name, authors, publisher, yearOfPublication, numberOfPages, price, bindingType));
    }

    public ArrayList<Book> getBookBase() {
        return bookBase;
    }

    public String baseToString(ArrayList<Book> list){
        StringBuilder string = new StringBuilder();
        for(Book book: list){
            string.append(book).append("\n");
        }
        return string.toString();
    }

    public ArrayList<Book> authorSearch(String author){
        ArrayList<Book> list;
        list = (ArrayList<Book>) bookBase.stream().filter(book -> book.getAuthors().equals(author)).collect(Collectors.toList());
        return list;
    }

    public ArrayList<Book> publisherSearch(String publisher){
        ArrayList<Book> list;
        list = (ArrayList<Book>) bookBase.stream().filter(book -> book.getPublisher().equals(publisher)).collect(Collectors.toList());
        return list;
    }

    public ArrayList<Book> afterYearSearch(int year){
        ArrayList<Book> list;
        list = (ArrayList<Book>) bookBase.stream().filter(book -> book.getYearOfPublication() > year).collect(Collectors.toList());
        return list;
    }
}
