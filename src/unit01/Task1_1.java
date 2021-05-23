package unit01;
import java.util.Scanner;

public class Task1_1 {
   private int a,b,c;

   public Task1_1(){
    System.out.println("Enter equation parameters:\na\nb\nc");
    input();
   }

   public void input(){
      Scanner in = new Scanner(System.in);
      setA(in.nextInt());
      setB(in.nextInt());
      setC(in.nextInt());
      in.close();
   }

   public double calculatingTheValue(){
      return ((getA()-3)*getB()/2)+getC();
   }

   public int getC() {
      return c;
   }

   public void setC(int c) {
      this.c = c;
   }

   public int getB() {
      return b;
   }

   public void setB(int b) {
      this.b = b;
   }

   public int getA() {
      return a;
   }

   public void setA(int a) {
      this.a = a;
   }
}
