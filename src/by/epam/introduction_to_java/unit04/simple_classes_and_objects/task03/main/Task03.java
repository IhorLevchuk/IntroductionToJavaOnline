package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.main;

import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.dao.Students;
import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.view.StudentView;

public class Task03 {
    public static void main(String[] args) {
        /*
        Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 или 10
         */

        StudentView studentView = new StudentView();

        Students students = new Students();

        studentView.printStudents(students.searchAStudents());

    }
}
