package unit02;
public class Task3_3 {
    public void calculating() {
        int n = 5;
        int a = 0;
        int b = 5;
        int[] A = new int[n];
        int max;
        int buffer;
        int positionMax = 0;

        for (int i = 0; i < A.length; i ++) {
            A[i] = (int) (Math.random()*(b-a)+a);
            a += 5;
            b += 5;
        }

        for (int k : A) {
            System.out.print(k + "\t");
        }
        System.out.println();

        for(int i = 0; i < A.length-1; i++){
            max = A[i];
            for(int j = i + 1; j < A.length; j++){
                if (max < A[j]){
                    max = A[j];
                    positionMax = j;
                }
            }
            buffer = A[i];
            A[i] = A[positionMax];
            A[positionMax] = buffer;
        }

        for (int j : A) {
            System.out.print(j + "\t");
        }
        System.out.println();

    }

}
