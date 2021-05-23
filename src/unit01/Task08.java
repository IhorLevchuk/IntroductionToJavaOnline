package unit01;
import java.util.Scanner;

public class Task08 {
    private double a,b,c,d;
    public Task08(){
        System.out.println("Enter four numbers:");
        input();
    }

    private void input(){
        Scanner in = new Scanner(System.in);
        a=in.nextDouble();
        b=in.nextDouble();
        c=in.nextDouble();
        d=in.nextDouble();
        in.close();
    }

    public double findingTheMax(){
        return Math.max(Math.min(a,b),Math.min(c,d));
    }
}
