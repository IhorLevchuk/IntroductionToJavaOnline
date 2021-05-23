package unit06.task01.Book;

import unit06.task01.model.Author;

import java.io.Serializable;

public abstract class Book implements Serializable {
    private int id;
    private Author author;
    private String name;
    private int numberOfPages;


    @Override
    public String toString() {
        return name + " " + author + ", " + numberOfPages + " c.";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
