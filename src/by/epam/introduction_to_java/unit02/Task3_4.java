package by.epam.introduction_to_java.unit02;
public class Task3_4 {
    public void calculating() {
        int n = 5;
        int a = 0;
        int b = 5;
        int[] A = new int[n];
        int buffer;
        int numberPermutations = 0;
        boolean needIteration = true;


        for (int i = 0; i < A.length; i ++) {
            A[i] = (int) (Math.random()*(b-a)+a);
            a += 5;
            b += 5;
        }

        for (int k : A) {
            System.out.print(k + "\t");
        }
        System.out.println();

        while (needIteration){
            needIteration = false;
            for (int j = 1; j < A.length; j++) {
                if(A[j] > A[j-1]){
                    buffer = A[j];
                    A[j] = A[j-1];
                    A[j-1] = buffer;
                    numberPermutations++;
                    needIteration = true;
                }
            }
        }

        for (int j : A) {
            System.out.print(j + "\t");
        }
        System.out.println();
        System.out.println(numberPermutations);

    }
}
