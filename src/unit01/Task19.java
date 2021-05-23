package unit01;
import java.util.Scanner;

public class Task19 {
    private String a,b;
    public Task19(){
        System.out.println("Enter x and y:");
        input();
    }
    private void input(){
        Scanner in = new Scanner(System.in);
        setA(in.next());
        setB(in.next());
        in.close();
    }

    public void establishmentEntry(){
        char[] x,y;
        x = getA().toCharArray();
        y = getB().toCharArray();
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < y.length; j++){
                if(x[i]==y[j]){
                    System.out.println(x[i]+" ");
                }
            }
        }
    }


    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
