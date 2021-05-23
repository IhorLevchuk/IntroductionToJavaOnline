package unit02;
public class Task2_16 {
    public void calculating() {
        int n = 4;
        int[][] A = new int[n][n];
        int number = 0;

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = ++number;
            }
        }

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int count = 0;
        for (int i = 0; i < A.length/2; i++) {
            int transition;
            if(i<A.length/2) {
                transition = A[i][i];
                A[i][i] = A[A.length-1-count][A.length-1-count];
                A[A.length-1-count][A.length-1-count] = transition;
                count++;
            }
        }
        count = 0;
        for (int i = 0; i <A.length/2 ; i++) {
            int transition;
            if(i<A.length/2){
                transition = A[A.length - 1 -count][i];
                A[A.length - 1 - count][i] = A[i][A.length-1-count];
                A[i][A.length-1-count] = transition;
                count++;
            }
        }

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
