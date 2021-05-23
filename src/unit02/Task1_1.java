package unit02;
public class Task1_1 {
    public int summation(){
        final int[] A = {5,2,6,4,8,9,5,6,4,2};
        final int K = 3;
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]%K == 0){
                sum += A[i];
            }
        }
        return sum;
    }
}
