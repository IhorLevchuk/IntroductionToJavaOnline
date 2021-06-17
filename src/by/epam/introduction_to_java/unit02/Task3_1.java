package by.epam.introduction_to_java.unit02;
public class Task3_1 {
    public void calculating() {
        int n = 4;
        int m = 5;
        int k = 2;
        int[] A = new int[n];
        int[] B = new int[m];
        int[] C = new int[n+m];

        for (int i = 0; i < A.length; i ++) {
            A[i] = (int) (Math.random()*9);
        }
        for (int i = 0; i < B.length; i ++) {
            B[i] = (int) (Math.random()*9);
        }

        for (int i = 0; i <= k; i ++) {
            C[i] = A[i];
        }
        for (int i = k + 1; i < B.length + k + 1; i ++) {
            C[i] = B[i-k-1];
        }
        for (int i = B.length + k + 1; i < C.length; i ++) {
            C[i] = A[i-B.length];
        }



        for (int i = 0; i < A.length; i ++) {
            System.out.print(A[i] + "\t");
        }
        System.out.println();

        for (int i = 0; i < B.length; i ++) {
            System.out.print(B[i] + "\t");
        }
        System.out.println();

        for (int i = 0; i < C.length; i ++) {
            System.out.print(C[i] + "\t");
        }
        System.out.println();
    }
}
