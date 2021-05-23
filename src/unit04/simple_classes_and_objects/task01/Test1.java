package unit04.simple_classes_and_objects.task01;

public class Test1 {
    private int x = 5;
    private int y = 6;

    public int sum(){
        return x+y;
    }

    public int max(){
        return Math.max(x, y);
    }

    public void print(){
        System.out.printf("x= %d, y = %d \n", x, y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
