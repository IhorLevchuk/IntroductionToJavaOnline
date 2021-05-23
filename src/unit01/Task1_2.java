package unit01;
import java.util.Scanner;

public class Task1_2 {
    private int a,b,c;

    public Task1_2(){
        System.out.println("Enter equation parameters");
        input();
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        setA(in.nextInt());
        setB(in.nextInt());
        setC(in.nextInt());
        in.close();
    }

    public double calculatingTheValue(){
        return (getB()+Math.pow(Math.pow(getB(),2)+4*getA()*getC(),0.5))/2*getA()-Math.pow(getA(),3)*getC()+Math.pow(getB(),-2);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
