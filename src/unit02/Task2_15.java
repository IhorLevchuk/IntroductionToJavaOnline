package unit02;
public class Task2_15 {
    public void calculating() {
        int[][] A = new int[5][5];
        int max;

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

        max = A[0][0];
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] > max){
                    max = A[i][j];
                }
            }
        }

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                if(i%2 != 0 && j%2 != 0){
                    A[i][j] = max;
                }
            }
        }

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
