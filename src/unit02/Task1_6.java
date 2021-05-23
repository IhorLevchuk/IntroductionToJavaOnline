package unit02;
public class Task1_6 {
    public void calculating() {
        int[] A = {4, 8, 9, 2, 2, 1, 4, 7, 3, 5};
        int sum = 0;
        boolean simple;
        for (int i = 2; i < A.length; i++){
            simple = true;
            for(int j = 2; j < i; j++){
                if(i%j == 0){
                    simple = false;
                    break;
                }
            }
            if(simple){
                System.out.print(A[i]);
                sum += A[i];
            }
        }
        System.out.println();
        System.out.println(sum);
    }
}
