package by.epam.introduction_to_java.unit06.task02.dao.impl;

import by.epam.introduction_to_java.unit06.task02.dao.NoteDAO;

public final class DAOProvider {
    private static final DAOProvider provider = new DAOProvider();

    private final NoteDAO noteDAO = new TxtNoteDAO();

    private DAOProvider() {
    }

    public static DAOProvider getProvider(){
        return provider;
    }

    public NoteDAO getNoteDAO() {
        return noteDAO;
    }
}
