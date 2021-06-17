package by.epam.introduction_to_java.unit06.task01.dao.impl;

import by.epam.introduction_to_java.unit06.task01.bean.book.Book;
import by.epam.introduction_to_java.unit06.task01.dao.BookDAO;
import by.epam.introduction_to_java.unit06.task01.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtBookDAO implements BookDAO {

    private boolean saveDate(List<Book> readTo) throws DAOException {
        boolean flag = false;
        File users = new File("src/by/epam/introduction_to_java/unit06/task01/file/Books.txt");
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(users,false);
            ostream = new ObjectOutputStream(fos);

            for(Book ob: readTo){
                ostream.writeObject(ob);
            }
            flag = true;
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл не может быть создан ", e);
        } catch (IOException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                throw new DAOException("ошибка закрытия потока ", e);
            }
        }
        return flag;
    }

    private List<Book> readDate() throws DAOException {
        List<Book> books = new ArrayList<>();
        File data = new File("src/by/epam/introduction_to_java/unit06/task01/file/Books.txt");
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(data);
            istream = new ObjectInputStream(fis);
            while (true){
                books.add((Book) istream.readObject());
            }
        } catch (ClassNotFoundException ce) {
            throw new DAOException("Класс не существует ",ce);
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл для десериализации не существует ", e);
        } catch (IOException ioe) {
            throw new DAOException("Общая I/O ошибка ", ioe);
        }
        finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                throw new DAOException("ошибка закрытия потока ", e);
            }
            return books;
        }
    }


    @Override
    public List<Book> searchByID(int id) throws DAOException {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book: readDate()){
            if(book.getId() == id){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> searchByName(String name) throws DAOException {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book: readDate()){
            if(book.getName().equals(name)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public int getNumberOfBooks() throws DAOException {
        return readDate().size();
    }

    @Override
    public List<Book> getBooks(int from, int to) throws DAOException {
        List<Book> books = readDate();
        List<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++){
            if (i >= from && i <= to){
                foundBooks.add(books.get(i));
            }
        }
        return foundBooks;
    }

    @Override
    public boolean addBook(Book book) throws DAOException {
        List<Book> books;
        books = readDate();
        books.add(book);
        return saveDate(books);
    }

    @Override
    public boolean removeBook(int id) throws DAOException {
        List<Book> books;
        books = readDate();
        books.removeIf(book -> book.getId() == id);
        return saveDate(books);
    }

}
