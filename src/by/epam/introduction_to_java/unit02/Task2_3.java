package by.epam.introduction_to_java.unit02;
public class Task2_3 {
    public void calculating() {
        int[][] A = {{5, 8, 9, 58,68}, {85, 6, 21, 4, 98, 53}, {48, 62, 45, 76, 4}, {78, 6, 2, 45, 12, 3}, {5, 7, 9, 4, 1, 6}, {8, 7, 4, 1, 33, 21}};
        int k = 1, p = 3;
        for (int i = 0; i < A[k].length; i++) {
                System.out.print(A[k][i] + " ");
        }
        System.out.println();
        for (int j = 0; j < A.length; j++) {
            System.out.print(A[j][p] + " ");
        }
    }
}
