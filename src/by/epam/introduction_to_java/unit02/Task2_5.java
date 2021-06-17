package by.epam.introduction_to_java.unit02;
public class Task2_5 {
    public void calculating() {
        int n = 6;
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if(j < n - i){
                    A[i][j] = i + 1;
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
