package unit02;
public class Task2_11 {
    public void calculating() {
        int[][] A = new int[10][20];
        int counter;
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 20; j++) {
                A[i][j] = (int) (Math.random() * 15);
            }
        }
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i ++) {
            counter = 0;
            for (int j = 0; j < 20; j++) {
                if (A[i][j] == 5){
                    counter++;
                }
            }
            if (counter >= 3){
                System.out.print(i + " ");
            }
        }
    }
}
