package by.epam.introduction_to_java.unit01;
import java.util.Scanner;

public class Task3_2 {
    private int a,b,h;

    public Task3_2(){
        System.out.println("Enter spacing value and step:\n a,b,h");
        input();
    }
    private void input(){
        String[] options;
        Scanner in = new Scanner(System.in);
        options = in.next().split(",");
        setA(Integer.parseInt(options[0]));
        setB(Integer.parseInt(options[1]));
        setH(Integer.parseInt(options[2]));
        in.close();
    }

    public int[] computation(){
        int[] values = new int[(int) ((getB() - getA()) / getH()) + 1];
        int j = 0;
        for (int i = (int) getA(); i <= getB(); i += getH()){
            if (i > 2){
                values[j] = i;
            } else {
                values[j] = -i;
            }
            j++;
        }
        return values;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
