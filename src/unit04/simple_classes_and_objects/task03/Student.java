package unit04.simple_classes_and_objects.task03;

public class Student {
    private String fullName;
    private int groupNumber;
    private int[] performance;

    public Student(String fullName, int groupNumber, int[] performance) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.performance = performance;
    }

    public int[] getPerformance() {
        return performance;
    }

    @Override
    public String toString() {
        return "fullName=" + fullName +
                ", groupNumber=" + groupNumber;
    }
}
