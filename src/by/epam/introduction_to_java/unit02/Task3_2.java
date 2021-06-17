package by.epam.introduction_to_java.unit02;
public class Task3_2 {
    public void calculating() {
        int n = 3;
        int m = 3;
        int a = 0;
        int b = 5;
        int[] A = new int[n];
        int[] B = new int[m];
        int[] C = new int[n+m];
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        boolean needLoop = true;

        for (int i = 0; i < A.length; i ++) {
            A[i] = (int) (Math.random()*(b-a)+a);
            a += 5;
            b += 5;
        }
        for (int i = B.length-1; i >=0; i --) {
            B[i] = (int) (Math.random()*(b-a)+a);
            a -= 5;
            b -= 5;
        }

        while (needLoop){
            if(A[indexA] >= B[indexB]){
                C[indexC] = B[indexB];
                indexB++;
                if(indexB == B.length){
                    for(int i = indexA; i < A.length; i++){
                        indexC++;
                        C[indexC]= A[i];
                    }
                    needLoop = false;
                }
            } else{
                 C[indexC] = A[indexA];
                 indexA++;
                if(indexA == A.length){
                    for(int i = indexB; i < B.length; i++){
                        indexC++;
                        C[indexC]= B[i];
                    }
                    needLoop = false;
                }
            }
            indexC++;
        }

        for (int j : A) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int j : B) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int j : C) System.out.print(j + "\t");
        System.out.println();
    }
}
