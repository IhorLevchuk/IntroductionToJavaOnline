package unit01;
import java.util.Scanner;

public class Task2_3 {
    private int x1,y1,x2,y2,x3,y3;

    public Task2_3(){
        System.out.println("Enter the coordinates of three points: x1,y1 \n x2,y2 \n x3,y3");
        input();
    }

    private void input(){
        String[] point_A,point_B,point_C;
        Scanner in = new Scanner(System.in);
        point_A = in.next().split(",");
        x1=Integer.parseInt(point_A[0]);
        y1=Integer.parseInt(point_A[1]);
        point_B = in.next().split(",");
        x2=Integer.parseInt(point_B[0]);
        y2=Integer.parseInt(point_B[1]);
        point_C = in.next().split(",");
        x3=Integer.parseInt(point_C[0]);
        y3=Integer.parseInt(point_C[1]);
        in.close();
    }


    public boolean establishingPosition(){
        return (x1 - x2)/(x3 - x2) - (y1 - y2)/(y3 - y2) <= 0;
    }
}
