package by.epam.introduction_to_java.unit02;
public class Task2_4 {
    public void calculating() {
        int n = 5;
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if(i%2 == 0){
                    A[i][j] = j + 1;
                } else A[i][j] = n - j;
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
