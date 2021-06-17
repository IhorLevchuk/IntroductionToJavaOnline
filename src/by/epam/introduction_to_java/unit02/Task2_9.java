package by.epam.introduction_to_java.unit02;
public class Task2_9 {
    public void calculating() {
        int[][] A = {{5, 8, 9, 58, 47, 68}, {85, 6, 21, 4, 98, 53}, {48, 58, 62, 45, 76, 4}, {78, 6, 2, 45, 12, 3}, {5, 7, 9, 4, 1, 6}, {8, 7, 4, 1, 33, 21}};
        int[] sum = new int[A[0].length];

        for (int i = 0; i < A[0].length; i ++) {
            for (int j = 0; j < A.length; j++) {
                sum[i] += A[j][i];
            }

        }

        for (int i = 0; i < sum.length; i ++) {
            System.out.print(sum[i] + " ");
        }
    }
}
