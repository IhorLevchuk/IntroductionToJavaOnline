package by.epam.introduction_to_java.unit06.task01.bean.book;

import java.io.Serial;

public class PaperBook extends Book{
    @Serial
    private static final long serialVersionUID = 531519163292383155L;

    public PaperBook(int id, String author, int numberOfPages, String name) {
        super(id, author, numberOfPages, name);
    }

    public PaperBook() {
    }

}
