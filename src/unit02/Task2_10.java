package unit02;
import java.util.ArrayList;

public class Task2_10 {
    public void calculating() {
        int[][] A = {{5, 8, 9, 58, 47, 68}, {85, -6, 21, 4, 98, 53}, {48, 58, 62, 45, 76, 4}, {78, 6, 2, 45, 12, 3}, {5, 7, 9, 4, 1, 6}, {8, 7, 4, 1, 33, 21}};
        ArrayList<Integer> positive = new ArrayList<>();
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == j && A[i][j] > 0){
                    positive.add(A[i][j]);
                }
            }

        }
        for (int i = 0; i < positive.size(); i ++) {
            System.out.print(positive.get(i) + " ");
        }
    }
}
