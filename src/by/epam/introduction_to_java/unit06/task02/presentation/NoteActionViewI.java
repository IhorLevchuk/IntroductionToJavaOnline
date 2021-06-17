package by.epam.introduction_to_java.unit06.task02.presentation;

import by.epam.introduction_to_java.unit06.task02.bean.Note;

import java.util.List;

public interface NoteActionViewI {

    String notesView(List<Note> notes);
    String errorView();
    String addNoteView(int code);

}
