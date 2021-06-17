package by.epam.introduction_to_java.unit04.simple_classes_and_objects.task03.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = -3992176523138044460L;

    private String fullName;
    private int groupNumber;
    private int[] performance;

    public Student(String fullName, int groupNumber, int[] performance) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.performance = performance;
    }

    public Student() {
    }

    public int[] getPerformance() {
        return performance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setPerformance(int[] performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", groupNumber=" + groupNumber +
                ", performance=" + Arrays.toString(performance) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return groupNumber == student.groupNumber && Objects.equals(fullName, student.fullName) && Arrays.equals(performance, student.performance);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fullName, groupNumber);
        result = 31 * result + Arrays.hashCode(performance);
        return result;
    }
}
