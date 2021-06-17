package by.epam.introduction_to_java.unit02;
public class Task2_7 {
    public void calculating() {
        int n = 10;
        int counter = 0;
        double[][] A = new double[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = Math.sin((Math.pow(i,2)-Math.pow(j,2))/n);
                if(A[i][j] > 0){
                    counter++;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(" %.4f ",A[i][j]);
            }
            System.out.println();
        }
        System.out.println(counter);
    }
}
