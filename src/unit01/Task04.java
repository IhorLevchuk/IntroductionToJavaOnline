package unit01;
import java.util.Locale;
import java.util.Scanner;

public class Task04 {

    private double number;

    public Task04(){
        System.out.println("Enter format number: nnn.ddd");
        input();
    }

    public void input(){
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        number = in.nextDouble();
        in.close();
    }

    public double changeNumber(){
        return  (number * 1000) % 1000 + (int) number / 1000.0;
    }


}