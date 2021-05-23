package unit02;
public class Task2_6 {
    public void calculating() {
        int n = 10;
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if(j >= i && j < n - i || j >= n - i - 1 && j <= i){
                    A[i][j] = 1;
                } else A[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
