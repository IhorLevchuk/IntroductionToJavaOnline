package unit01;
import java.util.Scanner;

public class Task2_5 {
    private double x;
    public Task2_5(){
        System.out.println("Enter function parameter:");
        input();
    }
    private void input(){
        Scanner in = new Scanner(System.in);
        x= in.nextDouble();
        in.close();
    }

    public double computation(){
        if(x<=3){
            return Math.pow(x,2)-3*x+9;
        } else return 1/(Math.pow(x,3)+6);
    }
}
