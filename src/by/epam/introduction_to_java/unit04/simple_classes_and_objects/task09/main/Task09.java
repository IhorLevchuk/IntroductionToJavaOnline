package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task09.main;


import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task09.dao.BookBase;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task09.view.BookView;

public class Task09 {
    public static void main(String[] args) {
        /*
        Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString().
        Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
        Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
         */
        BookBase bookBase = new BookBase();
        BookView bookView = new BookView();

        bookView.printBooks(bookBase.getBookBase());
        bookBase.addBook(52,"1984", "Джордж Оруэлл", "АСТ", 1984 , 320, 18,5);
        bookBase.addBook(48,"Детство. В людях. Мои университеты", "Максим Горький", "АСТ",
                2021 , 720, 25,5);
        bookBase.addBook(385,"Ход королевы", "Уолтер Тевис", "АСТ", 2020 ,
                352, 15,1);
        bookBase.addBook(412,"451 градус по Фаренгейту", "Рэй Бредбери", "АСТ", 2017 ,
                156, 19.45,3);
        bookView.printBooks(bookBase.getBookBase());
        System.out.println("Список книг заданного автора\n");
        bookView.printBooks(bookBase.authorSearch("Джордж Оруэлл"));
        System.out.println("Список книг, выпущенных заданным издательством\n");
        bookView.printBooks(bookBase.publisherSearch("АСТ"));
        System.out.println("Список книг, выпущенных после заданного года\n");
        bookView.printBooks(bookBase.afterYearSearch(2017));
    }
}

