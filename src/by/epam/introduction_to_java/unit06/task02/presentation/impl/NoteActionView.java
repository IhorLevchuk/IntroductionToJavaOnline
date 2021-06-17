package by.epam.introduction_to_java.unit06.task02.presentation.impl;

import by.epam.introduction_to_java.unit06.task02.bean.Note;
import by.epam.introduction_to_java.unit06.task02.presentation.NoteActionViewI;

import java.util.List;

public class NoteActionView implements NoteActionViewI {

    @Override
    public String notesView(List<Note> notes) {
        StringBuilder stringNotes = new StringBuilder();
        notes.forEach(note -> stringNotes.append(note.getTopic()).append("\n").append(note.getEmail().getEmail())
                .append("\n").append(note.getDate().toString()).append("\n").append(note.getText().getText()).append("\n\n"));
        return stringNotes.toString();
    }

    @Override
    public String errorView() {
        return "Error";
    }

    @Override
    public String addNoteView(int code) {
        if (code == 1) return "Тема обязательна для заполнения";
        if (code == 2) return "Некорректный e-mail";
        return "Заметка добавлена.";
    }
}
