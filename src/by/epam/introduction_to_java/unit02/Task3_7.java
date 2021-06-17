package by.epam.introduction_to_java.unit02;
public class Task3_7 {
    public void calculating() {
        int n = 3;
        int m = 3;
        int a = 0;
        int b = 5;
        int[] A = new int[n];
        int[] B = new int[m];
        int indexA = 0;
        int indexB = 0;
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

        for (int k : A) {
            System.out.print(k + "\t");
        }
        System.out.println();

        for (int j : B) {
            System.out.print(j + "\t");
        }
        System.out.println();

        while (needLoop){
            if(A[indexA+1] >= B[indexB] && A[indexA] <= B[indexB]){
                System.out.printf("Enter element B[%d] between A[%d] and A[%d] \n",indexB,indexA,indexA+1);
                indexB++;
                if(indexB == B.length){
                    needLoop = false;
                }
            } else {
                indexA++;
                if(indexA+1 == A.length){
                    System.out.printf("Enter element B[%d]-B[%d] after A[%d]",indexB,B.length-1,A.length-1);
                    needLoop = false;
                }
            }
        }
    }

}
