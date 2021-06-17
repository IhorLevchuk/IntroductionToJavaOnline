package by.epam.introduction_to_java.unit02;
public class Task1_4 {
    public void calculating(){
        int[] A = {4,8,9,2,2,1,4,7,3,5,68,47,32,1,98,54,5,1,6,35,21,7};
        int max = A[0], min = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
            }
            if(A[i] < min){
                min = A[i];
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] == max){
                A[i] = min;
            } else if(A[i] == min){
                A[i] = max;
            }
        }
        for(int mas: A){
            System.out.print(mas + " ");
        }
    }
}
