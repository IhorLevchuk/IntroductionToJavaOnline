package unit02;
public class Task1_3 {
    public void calculating(){
        int[] A = {68,5,8,-9,-78,5,0,8,-3,0,0,45,78,-1,-6};
        int N = A.length;
        int positive = 0, negative = 0, zero = 0;
        for(int mas: A){
            if (mas > 0){
                positive++;
            } else if (mas < 0){
                negative++;
            } else zero++;
        }
        System.out.printf("positive: %d \nnegative: %d \nzero: %d ", positive, negative, zero);

    }
}
