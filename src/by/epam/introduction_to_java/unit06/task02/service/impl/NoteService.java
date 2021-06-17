package by.epam.introduction_to_java.unit06.task02.service.impl;

import by.epam.introduction_to_java.unit06.task02.bean.Email;
import by.epam.introduction_to_java.unit06.task02.bean.Note;
import by.epam.introduction_to_java.unit06.task02.bean.Text;
import by.epam.introduction_to_java.unit06.task02.dao.impl.DAOProvider;
import by.epam.introduction_to_java.unit06.task02.exception.DAOException;
import by.epam.introduction_to_java.unit06.task02.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task02.service.NoteServiceI;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class NoteService implements NoteServiceI {
    private final DAOProvider provider = DAOProvider.getProvider();

    @Override
    public List<Note> sort(List<Note> notes, String typeSort) throws ServiceException {
        switch (typeSort){
            case "date"-> {
                return sortByDate(notes);
            }
            case "topic"-> {
                return sortByTopic(notes);
            }
        }
        return notes;
    }

    @Override
    public int addNote(String topic, String emailName, String text) throws ServiceException {
//        Note note = new Note();
//        Email email = new Email();
//        if (!note.setTopic(topic)) return 1;
//        if (!email.setEmail(emailName)) return 2;
//        note.setEmail(email);
//        note.setText(new Text(text));
//        try {
//            provider.getNoteDAO().addNote(note);
            return 3;
//        } catch (DAOException e) {
//            throw new ServiceException(e);
//        }
    }

    @Override
    public List<Note> getNotesContainingWord(String word) throws ServiceException {
        try {
            return provider.getNoteDAO().getNotesContainingWord(word);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> searchByTopic(String topic) throws ServiceException {
        try {
            return provider.getNoteDAO().searchByTopic(topic);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> searchByDate(int year, int month, int dayOfMonth) throws ServiceException {
        try {
            return provider.getNoteDAO().searchByDate(LocalDate.of(year, month, dayOfMonth));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> searchByEMail(String email) throws ServiceException {
        try {
            return provider.getNoteDAO().searchByEMail(new Email(email));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> searchByText(String text) throws ServiceException {
        try {
            return provider.getNoteDAO().searchByText(new Text(text));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> searchByTopicAndDate(String topic, int year, int month, int dayOfMonth) throws ServiceException {
        try {
            return provider.getNoteDAO().searchByTopicAndDate(topic,LocalDate.of(year, month, dayOfMonth));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> getAllNotes() throws ServiceException {
        try {
            return provider.getNoteDAO().getAllNotes();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Note> sortByDate(List<Note> notes) throws ServiceException {
        return notes.stream().sorted(Note.dateComparator).collect(Collectors.toList());
    }

    @Override
    public List<Note> sortByTopic(List<Note> notes) throws ServiceException {
        return notes.stream().sorted(Note.topicComparator).collect(Collectors.toList());
    }


//    @Override
//    public List<Book> searchByID(int id) throws ServiceException {
//        try {
//            return provider.getBookDAO().searchByID(id);
//        } catch (DAOException e) {
//            throw new ServiceException(e);
//        }
//    }


//    @Override
//    public boolean addEBook(int id, String author, int pages, String name) throws ServiceException {
//        Book book = new EBook(id, author, pages, name);
//        try {
//            return provider.getBookDAO().addBook(book);
//        } catch (DAOException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    @Override
//    public boolean removeBook(int id) throws ServiceException {
//        try {
//            return provider.getBookDAO().removeBook(id);
//        } catch (DAOException e) {
//            throw new ServiceException(e);
//        }
//    }


}
