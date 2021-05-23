package unit01;
import java.util.Scanner;

public class Task03 {
    private int x,y;

    public Task03(){
        System.out.println("Enter equation parameters");
        input();
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        setX(in.nextInt());
        setY(in.nextInt());
        in.close();
    }

    public double calculatingTheValue(){
        return (Math.sin(getX())+Math.cos(getY()))/(Math.sin(getX())-Math.cos(getY()))*
                Math.tan(getX()*getY());
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
