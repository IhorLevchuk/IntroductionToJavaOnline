package by.epam.introduction_to_java.unit02;
public class Task1_7 {
    public void calculating() {
        int[] A = {4, 8, 9, 2, 2, 1, 4, 7, 5, 68, 47, 32, 1, 98, 54, 5, 1, 6, 35, 21, 7};
        int max = A[0] + A[1];
        for (int i = 1; i < A.length-1; i++) {
            if (A[i] + A[i+1] > max) {
                max = A[i] + A[i+1];
            }
        }
        System.out.println(max);
    }
}
