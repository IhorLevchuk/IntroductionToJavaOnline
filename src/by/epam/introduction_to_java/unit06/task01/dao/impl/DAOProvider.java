package by.epam.introduction_to_java.unit06.task01.dao.impl;

import by.epam.introduction_to_java.unit06.task01.dao.BookDAO;
import by.epam.introduction_to_java.unit06.task01.dao.ProfileDAO;

public final class DAOProvider {
    private static final DAOProvider provider = new DAOProvider();

    private final BookDAO bookDAO = new TxtBookDAO();
    private final ProfileDAO profileDAO = new TxtProfileDAO();

    private DAOProvider() {
    }

    public static DAOProvider getProvider(){
        return provider;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public ProfileDAO getProfileDAO() {
        return profileDAO;
    }
}
