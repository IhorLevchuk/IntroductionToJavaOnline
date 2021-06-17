package by.epam.introduction_to_java.unit01;
import java.util.Locale;
import java.util.Scanner;

public class Task1_4 {

    private double number;

    public Task1_4(){
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
