package by.epam.introduction_to_java.unit01;
import java.util.Scanner;

public class Task2_4 {
    private int A,B,x,y,z;

    public Task2_4(){
        System.out.println("Enter the dimensions of the rectangular hole A,B and brick dimensions x,y,z");
        input();
    }

    private void input(){
        String[] hole,brick;
        Scanner in = new Scanner(System.in);
        hole = in.next().split(",");
        A=Integer.parseInt(hole[0]);
        B=Integer.parseInt(hole[1]);
        brick= in.next().split(",");
        x=Integer.parseInt(brick[0]);
        y=Integer.parseInt(brick[1]);
        z=Integer.parseInt(brick[2]);
        in.close();
    }

    public boolean checkingPassage(){
        return x<=A && y<=B || x<=B && y<=A || x<=A && z<=B || x<=B && z<=A || z<=A && y<=B || z<=B && y<=A;
    }
}
