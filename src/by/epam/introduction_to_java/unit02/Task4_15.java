package by.epam.introduction_to_java.unit02;
import java.util.ArrayList;

public class Task4_15 {
    private final int n;
    private ArrayList<Integer> arrayNumbers;
    public Task4_15(int n){
        this.n = n;
    }
    private ArrayList<Integer> getNumbersOfTheNumber(int number){
        ArrayList<Integer> arrayNumbersOfNumber = new ArrayList<>();
        final int base = 10;
        while (number != 0){
            arrayNumbersOfNumber.add(0,number%base);
            number /= base;
        }
        return arrayNumbersOfNumber;
    }
    private boolean increaseCheck(ArrayList<Integer> array){
        boolean increase = true;
        for(int i = 0; i < array.size()-1; i++){
            if(array.get(i) >= array.get(i+1)){
                increase = false;
                return increase;
            }
        }
        return increase;
    }
    public void findingNumbers(){
        arrayNumbers = new ArrayList<>();
        for(int i = (int) Math.pow(10,n-1); i < Math.pow(10,n); i++){
            if(increaseCheck(getNumbersOfTheNumber(i))){
                arrayNumbers.add(i);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("n = ").append(n).append("\n");
        for(Integer array: arrayNumbers){
            str.append(array).append(" ");
        }
        return str.toString();
    }
}
