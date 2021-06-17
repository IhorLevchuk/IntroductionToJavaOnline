package by.epam.introduction_to_java.unit06.task02.dao.impl;

import by.epam.introduction_to_java.unit06.task02.bean.Email;
import by.epam.introduction_to_java.unit06.task02.bean.Note;
import by.epam.introduction_to_java.unit06.task02.bean.Text;
import by.epam.introduction_to_java.unit06.task02.dao.NoteDAO;
import by.epam.introduction_to_java.unit06.task02.exception.DAOException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TxtNoteDAO implements NoteDAO {
    private static final String delimiter = "------------------------";
    private static final String pathFileNotes = "src/by/epam/introduction_to_java/unit06/task02/file/Notes.txt";

    private boolean saveToFile(List<Note> notes) throws DAOException {
        boolean flag = false;
        File file = new File(pathFileNotes);

        if (file.setWritable(true)) {
            try (PrintWriter out = new PrintWriter(file)) {
                for (Note note : notes) {
                    out.println(note.getTopic());
                    out.println(note.getDate().getYear()+" "+note.getDate().getMonthValue()+" "+note.getDate().getDayOfMonth());
                    out.println(note.getEmail().getEmail());
                    out.println(note.getText().getText());
                    out.println(delimiter);
                }
                flag = true;
            } catch (Exception e) {
                throw new DAOException(e);
            }
        } else {
            throw new DAOException("Error save file");
        }
        return flag;
    }

    private List<Note> readFile() throws DAOException {
        List<Note> notes = new ArrayList<>();
        File file = new File(pathFileNotes);
        if (file.exists() && file.canRead()) {
            try (Scanner in = new Scanner(new FileReader(file))) {
                while (in.hasNextLine()) {
                    String topic = in.nextLine();
                    int year = in.nextInt();
                    int month = in.nextInt();
                    int day = in.nextInt();
                    in.nextLine();
                    String email = in.nextLine();
                    StringBuilder text = new StringBuilder("");
                    String nextLine = in.nextLine();

                    while (!nextLine.equals(delimiter)) {
                        text.append(nextLine);
                        if(!(nextLine = in.nextLine()).equals(delimiter)){
                            text.append("\n");
                        }
                    }

                    notes.add(new Note(topic, new Email(email), new Text(text.toString()), LocalDate.of(year,month,day)));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
        return notes;
    }

    @Override
    public List<Note> getAllNotes() throws DAOException {
        return readFile();
    }

    @Override
    public boolean addNote(Note note) throws DAOException {
        List<Note> notes = readFile();
        notes.add(note);
        return saveToFile(notes);
    }

    @Override
    public List<Note> getNotesContainingWord(String word) throws DAOException {
        List<Note> notes = readFile();
        List<Note> foundNotes = new ArrayList<>();
        for(Note note: notes){
            if (Pattern.matches(".*" + word + ".*", note.getText().getText())){
                foundNotes.add(note);
            }
        }
        return foundNotes;
    }

    @Override
    public List<Note> searchByTopic(String topic) throws DAOException {
        return readFile().stream().filter(note -> note.getTopic().equals(topic)).collect(Collectors.toList());
    }

    @Override
    public List<Note> searchByDate(LocalDate date) throws DAOException {
        return readFile().stream().filter(note -> note.getDate().equals(date)).collect(Collectors.toList());
    }

    @Override
    public List<Note> searchByEMail(Email email) throws DAOException {
        return readFile().stream().filter(note -> note.getEmail().equals(email)).collect(Collectors.toList());
    }

    @Override
    public List<Note> searchByText(Text text) throws DAOException {
        return readFile().stream().filter(note -> note.getText().equals(text)).collect(Collectors.toList());
    }

    @Override
    public List<Note> searchByTopicAndDate(String topic, LocalDate date) throws DAOException {
        return readFile().stream().filter(note -> note.getDate().equals(date) && note.getTopic().equals(topic))
                .collect(Collectors.toList());
    }
}
