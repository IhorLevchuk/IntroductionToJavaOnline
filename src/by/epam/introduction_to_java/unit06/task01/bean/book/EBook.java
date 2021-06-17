package by.epam.introduction_to_java.unit06.task01.bean.book;


import java.io.Serial;

public class EBook extends Book{
    @Serial
    private static final long serialVersionUID = 6887566637305595721L;

    public EBook(int id, String author, int numberOfPages, String name) {
        super(id, author, numberOfPages, name);
    }

    public EBook() {
    }

}
