package by.epam.introduction_to_java.unit01;
import java.util.Scanner;

public class Task1_5 {

    private int number;

    public Task1_5(){
        System.out.println("Enter a natural number:");
        input();
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        in.close();
    }

    public void printFormate(){
        System.out.printf("%.1fч %.1fмин %dc", (float)number/(60*60), (float)number/60, number);
    }


}
