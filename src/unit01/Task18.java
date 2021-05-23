package unit01;
import java.util.Scanner;

public class Task18 {
    private int m,n;
    public Task18(){
        System.out.println("Enter m and n:");
        input();
    }
    private void input(){
        Scanner in = new Scanner(System.in);
        setM(in.nextInt());
        setN(in.nextInt());
        in.close();
    }
    public void findingDivisors(){
        for(int i = getM(); i <= getN();i++){
            System.out.print(i+":");
            for(int j = i-1; j > 1; j--){
                if(i%j == 0){
                    System.out.print(" "+j);
                }
            }
            System.out.println();
        }
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
