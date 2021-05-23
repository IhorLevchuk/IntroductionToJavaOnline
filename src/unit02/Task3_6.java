package unit02;
public class Task3_6 {
    public void calculating() {
        int n = 10;
        int[] A = new int[n];
        int buffer;
        int index = 0;

        for (int i = 0; i < A.length; i ++) {
            A[i] = (int) (Math.random()*15);
        }

        for (int k : A) {
            System.out.print(k + "\t");
        }
        System.out.println();

        while (index < A.length-1){
            if(A[index] <= A[index+1]){
                index++;
            } else {
                buffer = A[index];
                A[index] = A[index+1];
                A[index+1] = buffer;
                if (index != 0){
                    index--;
                }
            }
        }

        for (int j : A) {
            System.out.print(j + "\t");
        }
        System.out.println();

    }
}
