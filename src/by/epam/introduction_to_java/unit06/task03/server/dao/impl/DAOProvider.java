package by.epam.introduction_to_java.unit06.task03.server.dao.impl;

import by.epam.introduction_to_java.unit06.task03.server.dao.ProfileDAO;
import by.epam.introduction_to_java.unit06.task03.server.dao.StudentDAO;

public final class DAOProvider {
    private static final DAOProvider provider = new DAOProvider();

    private final ProfileDAO profileDAO = new XMLProfileDAO();
    private final StudentDAO studentDAO = new XMLStudentDAO();

    private DAOProvider() {
    }

    public static DAOProvider getProvider(){
        return provider;
    }

    public ProfileDAO getProfileDAO() {
        return profileDAO;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }
}
