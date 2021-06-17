package by.epam.introduction_to_java.unit06.task03.server.service;

import by.epam.introduction_to_java.unit06.task03.server.bean.Student;
import by.epam.introduction_to_java.unit06.task03.server.exception.ServiceException;

public interface StudentServiceI {
    Student requestCase(String id) throws ServiceException;
    boolean addCase(String id, String name, String faculty, String age, String averageMark)  throws ServiceException;
    boolean changeCase(String id, String name, String faculty, String age, String averageMark)  throws ServiceException;
}
