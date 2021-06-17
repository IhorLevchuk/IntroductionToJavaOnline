package by.epam.introduction_to_java.unit06.task03.server.presentation.impl;


import by.epam.introduction_to_java.unit06.task03.server.bean.Student;
import by.epam.introduction_to_java.unit06.task03.server.bean.EmptyStudent;
import by.epam.introduction_to_java.unit06.task03.server.presentation.StudentActionViewI;

public class StudentActionView implements StudentActionViewI {
    @Override
    public String requestCaseView(Student student) {
        StringBuilder string = new StringBuilder();
        if (student.getClass() != EmptyStudent.class){
            string.append("[id=").append(student.getId()).append("][name=").append(student.getName()).append("][faculty=")
                    .append(student.getFaculty()).append("][age=").append(student.getAge()).append("][averagemark=")
                    .append(student.getAverageMark()).append("]");
        } else string.append("Error");
        return string.toString() + "\n";
    }

    @Override
    public String errorView() {
        return "Error\n";
    }

    @Override
    public String addCaseView(boolean result) {
        if (result){
            return "Дело добавлено\n";
        }
        return "Дело не добавлено\n";
    }

    @Override
    public String changeCaseView(boolean result) {
        if (result){
            return "Дело изменео\n";
        }
        return "Дело не изменено\n";
    }
}
