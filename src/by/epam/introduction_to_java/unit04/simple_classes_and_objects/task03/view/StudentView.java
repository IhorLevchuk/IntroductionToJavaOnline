package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.view;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.bean.Student;

import java.util.List;

public class StudentView {
    public void printStudents(List<Student> students){
        StringBuilder studentsToString = new StringBuilder();
        for(Student student: students){
            studentsToString.append(student.getFullName()).append(" ").append(student.getGroupNumber()).append("\n");
        }
        System.out.println(studentsToString);
    }
}
