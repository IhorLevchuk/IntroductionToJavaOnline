package by.epam.introduction_to_java.unit06.task01.bean.book;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public abstract class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 4690396639233868816L;

    private int id;
    private String author;
    private int numberOfPages;
    private String name;

    public Book(int id, String author, int numberOfPages, String name) {
        this.id = id;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.name = name;
    }

    public Book() {
    }

    public String getInf() {
        StringBuilder stringList = new StringBuilder();
        stringList.append(getClass().getSimpleName()).append(": id:").append(id).append(" Название:").append(name).append(" Автор")
                    .append(author).append(" ").append(numberOfPages).append(" c.").append("\n");
        return stringList.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
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

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && numberOfPages == book.numberOfPages && Objects.equals(author, book.author) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, name, numberOfPages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
