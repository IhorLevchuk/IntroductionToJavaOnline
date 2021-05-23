package unit02;
public class Task2_1 {
    public void calculating() {
        int[][] A = {{5,8,9,58,47,68,4},{85,6,21,4,98,53,5},{48,58,62,45,76,4,6},{45,78,6,2,45,12,3},{5,7,8,9,4,1,6},{90,8,7,4,1,33,21}};
        for (int i = 1; i < A.length; i += 2) {
            if( A[i][0] > A[i][A[i].length-1]){
                System.out.print("{");
                for (int j = 0; j < A[i].length; j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.print("}");
            }
        }
    }
}
