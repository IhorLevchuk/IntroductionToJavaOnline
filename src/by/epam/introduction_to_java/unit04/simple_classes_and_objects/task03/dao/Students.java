package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.dao;



import by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.bean.Student;

import java.util.ArrayList;

public class Students {
    ArrayList<Student> students = new ArrayList<>();
    public Students(){
        students.add(new Student("Петров И.В.", 311,new int[] {5,8,9,3,7}));
        students.add(new Student("Иванов Г.В.", 422,new int[] {8,8,9,10,7}));
        students.add(new Student("Петрова И.В.", 311,new int[] {5,4,4,3,7}));
        students.add(new Student("Сидоров М.Г.", 31,new int[] {7,8,1,8,7}));
        students.add(new Student("Петухов С.И.", 311,new int[] {9,9,9,9,10}));
        students.add(new Student("Астраханцев И.В.", 351,new int[] {1,8,9,3,7}));
        students.add(new Student("Шабакаева Я.Д.", 251,new int[] {3,3,3,3,7}));
        students.add(new Student("Шабловский И.В.", 741,new int[] {8,8,8,8,8}));
        students.add(new Student("Стасенко Д.В.", 321,new int[] {5,5,5,3,7}));
        students.add(new Student("Целуев С.Г.", 611,new int[] {10,10,9,10,10}));
    }

    public ArrayList<Student> searchAStudents(){
        ArrayList<Student> aStudents = new ArrayList<>();
        for(int i = 0; i < students.size(); i ++){
            boolean aStudent = true;
            for(int j = 0; j < students.get(i).getPerformance().length; j++){
                if(students.get(i).getPerformance()[j] < 9){
                    aStudent = false;
                    break;
                }
            }
            if(aStudent){
                aStudents.add(students.get(i));
            }
        }
        return aStudents;
    }

}
