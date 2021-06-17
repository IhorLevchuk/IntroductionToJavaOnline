package by.epam.introduction_to_java.unit02;
public class Task2_12 {
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
        for (int i = 0; i < A.length; i ++) {
            while (needIteration){
                needIteration = false;
                for (int j = 1; j < A[0].length; j++) {
                    if(A[i][j] < A[i][j-1]){
                        buffer = A[i][j];
                        A[i][j] = A[i][j-1];
                        A[i][j-1] = buffer;
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
        for (int i = 0; i < A.length; i ++) {
            while (needIteration){
                needIteration = false;
                for (int j = 1; j < A[0].length; j++) {
                    if(A[i][j] > A[i][j-1]){
                        buffer = A[i][j];
                        A[i][j] = A[i][j-1];
                        A[i][j-1] = buffer;
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
