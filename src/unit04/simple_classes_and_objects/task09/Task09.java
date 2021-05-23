package unit04.simple_classes_and_objects.task09;

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
        System.out.println(bookBase.baseToString(bookBase.getBookBase()));
        bookBase.addBook(52,"1984", "Джордж Оруэлл", "АСТ", 1984 , 320, 18,5);
        bookBase.addBook(48,"Детство. В людях. Мои университеты", "Максим Горький", "АСТ",
                2021 , 720, 25,5);
        bookBase.addBook(385,"Ход королевы", "Уолтер Тевис", "АСТ", 2020 ,
                352, 15,1);
        bookBase.addBook(412,"451 градус по Фаренгейту", "Рэй Бредбери", "АСТ", 2017 ,
                156, 19.45,3);
        System.out.println(bookBase.baseToString(bookBase.getBookBase()));
        System.out.println("Список книг заданного автора\n");
        System.out.println(bookBase.baseToString(bookBase.authorSearch("Джордж Оруэлл")));
        System.out.println("Список книг, выпущенных заданным издательством\n");
        System.out.println(bookBase.baseToString(bookBase.publisherSearch("АСТ")));
        System.out.println("Список книг, выпущенных после заданного года\n");
        System.out.println(bookBase.baseToString(bookBase.afterYearSearch(2017)));

    }
}

