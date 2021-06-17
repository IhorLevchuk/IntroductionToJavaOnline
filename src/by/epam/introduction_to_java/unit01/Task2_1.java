package by.epam.introduction_to_java.unit01;
import java.util.Scanner;

public class Task2_1 {
    private double angle_a,angle_b;
    private boolean triangle,rightTriangle;

    public Task2_1(){
        System.out.println("Enter two corners");
        input();
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        angle_a=in.nextDouble();
        angle_b=in.nextDouble();
        in.close();
    }
    public void calculatingOfAngles(){

        if (angle_a+angle_b < 180){
            triangle = true;
            if(180-angle_a-angle_b == 90){
                rightTriangle = true;
            }
        } else {
            triangle = false;
            rightTriangle = false;
        }
    }

    public boolean isTriangle() {
        return triangle;
    }

    public boolean isRightTriangle() {
        return rightTriangle;
    }
}
