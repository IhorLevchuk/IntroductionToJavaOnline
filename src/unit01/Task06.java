package unit01;
import java.util.Scanner;

public class Task06 {
    private double x,y;

    public Task06(){
        System.out.println("Enter the coordinates of the points:");
        input();
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        x=in.nextDouble();
        y=in.nextDouble();
        in.close();
    }

    public boolean definitionOfOccurrence(){
        return x <= 2 && x >= -2 && y <= 4 && y >= 0 || x <= 4 && x >= -4 && y <= 0 && y >= -3;
    }
}
