package unit02;

public class Task1_10 {
    public void calculating() {
        int[] A = {4, 8, 9, 5, 2, 2, 1, 4, 5, 68};
        for (int i = 0; i < A.length; i += 2){
            A[i] = 0;
        }
        for (int mas: A){
            System.out.print(mas + " ");
        }
    }
}
