package by.epam.introduction_to_java.unit06.task02.dao;

import by.epam.introduction_to_java.unit06.task02.bean.Email;
import by.epam.introduction_to_java.unit06.task02.bean.Note;
import by.epam.introduction_to_java.unit06.task02.bean.Text;
import by.epam.introduction_to_java.unit06.task02.exception.DAOException;

import java.time.LocalDate;
import java.util.List;

public interface NoteDAO {
    List<Note> getAllNotes() throws DAOException;
    boolean addNote(Note note) throws DAOException;
    List<Note> getNotesContainingWord(String word) throws DAOException;
    List<Note> searchByTopic (String topic) throws DAOException;
    List<Note> searchByDate (LocalDate date) throws DAOException;
    List<Note> searchByEMail (Email email) throws DAOException;
    List<Note> searchByText (Text text) throws DAOException;
    List<Note> searchByTopicAndDate (String topic, LocalDate date) throws DAOException;
}
