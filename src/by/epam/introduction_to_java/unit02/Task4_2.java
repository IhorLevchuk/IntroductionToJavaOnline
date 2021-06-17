package by.epam.introduction_to_java.unit02;
import java.util.ArrayList;

public class Task4_2 {
    private int nOD;
    int A,B,C,D;

    public Task4_2(int A, int B, int C, int D){
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public void calculating(){
        setnOD(findNOD(A,B,C,D));
    }

    public String toString(){
        return "NOD "+A+","+B+","+C+","+D+" is "+getnOD();
    }

    private  ArrayList<Integer> findDivisible(int number){
        ArrayList<Integer> divisible = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            if(number%i == 0){
                divisible.add(i);
            }
        }
        return divisible;
    }

    private int findNOD(int A, int B, int C, int D){
        ArrayList<Integer> divisibleA = findDivisible(A);
        ArrayList<Integer> divisibleB = findDivisible(B);
        ArrayList<Integer> divisibleC = findDivisible(C);
        ArrayList<Integer> divisibleD = findDivisible(D);

        for(int i = divisibleA.size()-1; i >= 0; i--){
            if(divisibleB.contains(divisibleA.get(i)) && divisibleC.contains(divisibleA.get(i)) && divisibleD.contains(divisibleA.get(i))){
                return divisibleA.get(i);
            }
        }
        return -1;
    }

    public int getnOD() {
        return nOD;
    }

    public void setnOD(int nOD) {
        if(nOD == -1){
            System.out.println("NOD not found");
        }else {
            this.nOD = nOD;
        }
    }
}
