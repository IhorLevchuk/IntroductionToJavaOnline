package unit06.task03.Server;

class Student {
    private int id;
    private String name;
    private String faculty;
    private int age;
    private int averageMark;

    public Student(int id, String name, String faculty, int age, int averageMark) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.age = age;
        this.averageMark = averageMark;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student:" +
                "\nId:" + id +
                "\nName: " + name +
                "\nFaculty: " + faculty +
                "\nAge: " + age +
                "\nAverage-mark: " + averageMark;
    }
}
