package by.epam.introduction_to_java.unit02;
import java.util.ArrayList;

public class Task4_12 {
    private final int K,N;
    private ArrayList<Integer> A;
    public Task4_12(int K, int N){
        this.K = K;
        this.N = N;
    }
    public void arrayFormation(){
        A = new ArrayList<>();
        boolean needLoop = true;
        int sum = 0;
        int addedElement;
        while (needLoop){
            if(K-sum < N){
                addedElement = (int) (Math.random()*(K-sum-1)+1);
            } else {
                addedElement = (int) (Math.random()*(N-1)+1);
            }
            A.add(addedElement);
            sum += addedElement;
            if (sum == K){
                needLoop = false;
            }
        }
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Sum of elements: ").append(K);
        str.append("\nElements no more than ").append(N).append("\n");
        for(Integer array: A){
            str.append(array).append(" ");
        }
        return str.toString();
    }

}
