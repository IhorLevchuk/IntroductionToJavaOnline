package unit02;
public class Task2_14 {
    public void calculating() {
        int n = 10;
        int m = 7;
        int[][] A = new int[n][m];
        boolean needAdd1;
        int positionAdd, counter;
        for (int i = 0; i < A[0].length; i ++) {
            needAdd1 = true;
            counter = 0;
            while (needAdd1){
                needAdd1 = false;
                positionAdd = (int) (Math.random()*(n));
                if(counter < i){
                    if(A[positionAdd][i] == 0){
                        A[positionAdd][i] = 1;
                        counter++;
                    }
                    needAdd1 = true;
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
