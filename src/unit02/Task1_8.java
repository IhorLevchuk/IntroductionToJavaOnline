package unit02;
import java.util.ArrayList;

public class Task1_8 {
    public void calculating() {
        int[] A = {4, 8, 9, 2, 2, 1, 4, 5, 68};
        ArrayList<Integer> newMas = new ArrayList();
        int min = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
        }
        for (int mas : A) {
            if (mas != min) {
                newMas.add(mas);
            }
        }
        for (int i = 0; i < newMas.size(); i++) {
            System.out.print(newMas.get(i) + " ");
        }

    }
}
