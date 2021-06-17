package by.epam.introduction_to_java.unit02;
import java.util.ArrayList;

public class Task4_13 {
    private final int n;
    private ArrayList<Twins> arrayTwins;
    public Task4_13(int n){
        this.n = n;
    }
    public void findingTwins(){
        arrayTwins = new ArrayList<>();
        for(int i = n; i <= 2*n-2; i++){
            arrayTwins.add(new Twins(i));
        }
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[").append(n).append(",").append(2*n).append("]\n");
        for(Twins array: arrayTwins){
            str.append(array);
        }
        return str.toString();
    }
}
class Twins{
    private final int number1;
    private final int number2;
    public Twins(int number1){
        this.number1 = number1;
        this.number2 = number1+2;
    }
    @Override
    public String toString(){
        return "("+number1+","+number2+")";
    }
}
