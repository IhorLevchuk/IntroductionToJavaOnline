package by.epam.introduction_to_java.unit06.task03.server.service.impl;

import by.epam.introduction_to_java.unit06.task03.server.bean.Student;
import by.epam.introduction_to_java.unit06.task03.server.bean.EmptyStudent;
import by.epam.introduction_to_java.unit06.task03.server.dao.impl.DAOProvider;
import by.epam.introduction_to_java.unit06.task03.server.exception.DAOException;
import by.epam.introduction_to_java.unit06.task03.server.exception.ServiceException;
import by.epam.introduction_to_java.unit06.task03.server.service.StudentServiceI;

import java.util.regex.Pattern;

public class StudentService implements StudentServiceI {
    private final DAOProvider provider = DAOProvider.getProvider();

    @Override
    public Student requestCase(String ids) throws ServiceException {
        int id = 0;
        if (Pattern.matches("\\d+", ids)){
            id = Integer.parseInt(ids);
        } else return new EmptyStudent();
        try {
            return provider.getStudentDAO().requestCase(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addCase(String id, String name, String faculty, String age, String averageMark) throws ServiceException {
        Student student = new Student();
        if (Pattern.matches("\\d+", id)){
            student.setId(Integer.parseInt(id));
        } else return false;
        student.setName(name);
        student.setFaculty(faculty);
        if (Pattern.matches("\\d+", age)){
            student.setAge(Integer.parseInt(age));
        } else return false;
        if (Pattern.matches("\\d+", averageMark)){
            student.setAverageMark(Integer.parseInt(averageMark));
        } else return false;

        try {
            provider.getStudentDAO().addCase(student);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return true;
    }

    @Override
    public boolean changeCase(String id, String name, String faculty, String age, String averageMark) throws ServiceException {
        Student student;
        student = requestCase(id);
        if (student.getClass() == EmptyStudent.class){
            return false;
        }
        if (!name.equals("default")){
            student.setName(name);
        }
        if (!faculty.equals("default")){
            student.setFaculty(faculty);
        }
        if (!age.equals("default")){
            if (Pattern.matches("\\d+", age)){
                student.setAge(Integer.parseInt(age));
            } else return false;
        }
        if (!averageMark.equals("default")){
            if (Pattern.matches("\\d+", averageMark)){
                student.setAverageMark(Integer.parseInt(averageMark));
            } else return false;
        }
        try {
            provider.getStudentDAO().addCase(student);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return true;
    }
}
