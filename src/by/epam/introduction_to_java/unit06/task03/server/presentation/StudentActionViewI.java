package by.epam.introduction_to_java.unit06.task03.server.presentation;


import by.epam.introduction_to_java.unit06.task03.server.bean.Student;

public interface StudentActionViewI {
    String requestCaseView(Student student);
    String errorView();
    String addCaseView(boolean result);
    String changeCaseView(boolean result);
}
