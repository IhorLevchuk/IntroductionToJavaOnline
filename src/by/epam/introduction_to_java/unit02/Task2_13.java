package by.epam.introduction_to_java.unit02;
public class Task2_13 {
    public void calculating() {

        int[][] A = new int[5][5];
        boolean needIteration = true;
        int buffer;
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = (int) (Math.random() * 9);
            }
        }
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < A[0].length; i ++) {
            while (needIteration){
                needIteration = false;
                for (int j = 1; j < A.length; j++) {
                    if(A[j][i] < A[j-1][i]){
                        buffer = A[j][i];
                        A[j][i] = A[j-1][i];
                        A[j-1][i] = buffer;
                        needIteration = true;
                    }
                }
            }
            needIteration = true;
        }

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < A[0].length; i ++) {
            while (needIteration){
                needIteration = false;
                for (int j = 1; j < A.length; j++) {
                    if(A[j][i] > A[j-1][i]){
                        buffer = A[j][i];
                        A[j][i] = A[j-1][i];
                        A[j-1][i] = buffer;
                        needIteration = true;
                    }
                }
            }
            needIteration = true;
        }

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
