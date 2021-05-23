package unit02;
import java.util.ArrayList;

public class Task4_1 {
    private int nOD;
    private int nOK;
    int A,B;
    public Task4_1(int A, int B){
        this.A = A;
        this.B = B;
    }
    public void calculating(){
        setnOD(findNOD(A,B));
        setnOK(findNOK(A,B));
    }

    public String toString(){
        return "NOD "+A+" and "+B+" is "+getnOD() + "\nNOK "+A+" and "+B+" is "+getnOK();
    }

    private int findNOK(int A, int B){
        return A*B/findNOD(A,B);
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

    private int findNOD(int A, int B){
        ArrayList<Integer> divisibleA = findDivisible(A);
        ArrayList<Integer> divisibleB = findDivisible(B);

        for(int i = divisibleA.size()-1; i >= 0; i--){
            if(divisibleB.contains(divisibleA.get(i))){
                return divisibleA.get(i);
            }
        }
        return 0;
    }

    public int getnOD() {
        return nOD;
    }

    public void setnOD(int nOD) {
        if(nOD == 0){
            System.out.println("NOD not found");
        }else {
            this.nOD = nOD;
        }
    }

    public int getnOK() {
        return nOK;
    }

    public void setnOK(int nOK) {
        this.nOK = nOK;
    }
}
