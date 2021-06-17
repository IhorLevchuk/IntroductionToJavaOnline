package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task09.bean;

public class Book {
    private int id;
    private String name;
    private String authors;
    private String publisher;
    private int yearOfPublication;
    private int numberOfPages;
    private double price;
    private int bindingType;

    public Book(int id, String name, String authors, String publisher, int yearOfPublication, int numberOfPages, double price, int bindingType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return "Book: " + '\n' +
                "id: " + id + '\n' +
                "Name: " + name + '\n' +
                "Authors: " + authors + '\n' +
                "Publisher: " + publisher + '\n' +
                "Year of publication: " + yearOfPublication + '\n' +
                "Number of pages: " + numberOfPages + '\n' +
                "Price: " + price + '\n' +
                "Binding type: " + bindingType + '\n';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public int getBindingType() {
        return bindingType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBindingType(int bindingType) {
        this.bindingType = bindingType;
    }
}
