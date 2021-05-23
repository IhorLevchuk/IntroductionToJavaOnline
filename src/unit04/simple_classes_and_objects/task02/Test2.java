package unit04.simple_classes_and_objects.task02;

public class Test2 {
    private int x, y;
    public Test2(){
        x = 0;
        y = 0;
    }
    public Test2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
