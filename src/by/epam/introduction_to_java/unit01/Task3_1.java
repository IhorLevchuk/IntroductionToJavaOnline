package by.epam.introduction_to_java.unit01;
import java.util.Scanner;

public class Task3_1 {
    private int integer, sum;
    public Task3_1(){
        System.out.println("Please enter a positive integer");
        input();
    }

    private void input(){
        Scanner in = new Scanner(System.in);
        setInteger(in.nextInt());
        in.close();
    }

    public void summation(){
        setSum(0);
        for (int i = 1; i <= getInteger(); i++){
            setSum(getSum()+i);
        }
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
