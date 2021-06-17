package by.epam.introduction_to_java.unit06.task03.server.dao;


import by.epam.introduction_to_java.unit06.task03.server.bean.Student;
import by.epam.introduction_to_java.unit06.task03.server.exception.DAOException;

public interface StudentDAO {
    Student requestCase(int id) throws DAOException;
    void addCase(Student student) throws DAOException;
}
