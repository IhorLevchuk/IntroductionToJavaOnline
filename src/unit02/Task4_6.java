package unit02;
import java.util.ArrayList;

public class Task4_6 {
    private int nOD;
    private final int A,B,C;
    private boolean mutuallySimple;
    public Task4_6(int A, int B, int C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    private ArrayList<Integer> findDivisible(int number){
        ArrayList<Integer> divisible = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            if(number%i == 0){
                divisible.add(i);
            }
        }
        return divisible;
    }
    private void findNOD(){
        ArrayList<Integer> divisibleA = findDivisible(A);
        ArrayList<Integer> divisibleB = findDivisible(B);
        ArrayList<Integer> divisibleC = findDivisible(C);

        for(int i = divisibleA.size()-1; i >= 0; i--){
            if(divisibleB.contains(divisibleA.get(i)) && divisibleC.contains(divisibleA.get(i))){
                setnOD(divisibleA.get(i));
                break;
            }
        }
    }
    public void complianceCheck(){
        mutuallySimple = false;
        findNOD();
        if(nOD == 1 || nOD == -1){
            mutuallySimple = true;
        }
    }
    public void setnOD(int nOD) {
        if(nOD == 0){
            System.out.println("NOD not found");
        }else {
            this.nOD = nOD;
        }
    }
    public String toString(){
        return "Numbers: " + A + ", " + B + ", " + C + "\nMutually simple: " + mutuallySimple;
    }
}
