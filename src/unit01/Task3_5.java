package unit01;
import java.util.Scanner;

public class Task3_5 {
    private double e,sum;
    public Task3_5(){
        System.out.println("Enter e:");
        input();
        summation();
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        setE(in.nextDouble());
    }

    public void summation(){
        setSum(0);
        for (int i = 1; ;i++){
            if(1/Math.pow(2,i)+1/Math.pow(3,i) >= getE()){
                setSum(getSum()+1/Math.pow(2,i)+1/Math.pow(3,i));
            } else break;
        }
    }


    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
