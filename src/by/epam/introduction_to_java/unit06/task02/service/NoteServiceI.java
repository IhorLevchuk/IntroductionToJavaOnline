package by.epam.introduction_to_java.unit06.task02.service;

import by.epam.introduction_to_java.unit06.task02.bean.Note;
import by.epam.introduction_to_java.unit06.task02.exception.ServiceException;

import java.util.List;

public interface NoteServiceI {

    List<Note> getAllNotes() throws ServiceException;
    List<Note> sortByDate(List<Note> notes) throws ServiceException;
    List<Note> sortByTopic(List<Note> notes) throws ServiceException;
    List<Note> sort(List<Note> notes, String typeSort) throws ServiceException;
    int addNote(String topic, String email, String text) throws ServiceException;
    List<Note> getNotesContainingWord (String word) throws ServiceException;
    List<Note> searchByTopic (String topic) throws ServiceException;
    List<Note> searchByDate (int year, int month, int dayOfMonth) throws ServiceException;
    List<Note> searchByEMail (String email) throws ServiceException;
    List<Note> searchByText (String text) throws ServiceException;
    List<Note> searchByTopicAndDate (String topic, int year, int month, int dayOfMonth) throws ServiceException;
}
