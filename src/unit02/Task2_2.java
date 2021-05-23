package unit02;
public class Task2_2 {
    public void calculating() {
        int[][] A = {{5, 8, 9, 58, 47, 68}, {85, 6, 21, 4, 98, 53}, {48, 58, 62, 45, 76, 4}, {78, 6, 2, 45, 12, 3}, {5, 7, 9, 4, 1, 6}, {8, 7, 4, 1, 33, 21}};
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[i].length; j++) {
                if(i == j){
                    System.out.print(A[i][j] + " ");
                }
            }
        }
    }
}
