package unit01;
import java.util.Scanner;

public class Task05 {

    private int number;

    public Task05(){
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
