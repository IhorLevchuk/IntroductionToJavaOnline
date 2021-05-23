package unit02;
import java.util.Scanner;

public class Task2_8 {
    public void calculating() {
        int[][] A = {{5, 8, 9, 58, 47, 68}, {85, 6, 21, 4, 98, 53}, {48, 58, 62, 45, 76, 4}, {78, 6, 2, 45, 12, 3}, {5, 7, 9, 4, 1, 6}, {8, 7, 4, 1, 33, 21}};
        int n, k;
        int buffer;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[n].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < A[n].length; i ++) {
            buffer = A[i][n];
            A[i][n] = A[i][k];
            A[i][k] = buffer;
        }
        System.out.println();

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[n].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
