package unit02;
public class Task3_8 {
    public void calculating() {
        int n = 5;
        Fraction[] A = new Fraction[n];
        int index = 0;
        Fraction buffer;
        int commonDenominator = 1;

        for (int i = 0; i < A.length; i ++) {
            A[i] = new Fraction((int)(Math.random()*9),(int)(Math.random()*9));
        }

        for (Fraction k : A) {
            System.out.print(k.toString());
        }
        System.out.println();

        for (Fraction fraction : A) {
            commonDenominator *= fraction.denominator;
        }
        for (Fraction fraction : A) {
            fraction.numerator = fraction.numerator*commonDenominator/fraction.denominator;
            fraction.denominator = commonDenominator;
        }

        while (index < A.length-1){
            if(A[index].decimalConversion() <= A[index+1].decimalConversion()){
                index++;
            } else {
                buffer = A[index];
                A[index] = A[index+1];
                A[index+1] = buffer;
                if (index != 0){
                    index--;
                }
            }
        }
        for (Fraction k : A) {
            System.out.print(k.toString());
        }
        System.out.println();
    }

}

class Fraction{
    int numerator, denominator;
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public String toString(){
        return this.numerator+"/"+this.denominator+" ";
    }

    public double decimalConversion(){
        return (double) numerator/denominator;
    }

}
