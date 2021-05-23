package unit02;
import java.util.ArrayList;

public class Task4_14 {
    private final int k;
    private ArrayList<Integer> armstrongNumbers;
    public Task4_14(int k){
        this.k = k;
    }
    private boolean armstrongNumberCondition(int number){
        int sum = 0;
        ArrayList<Integer> arrayNumbers = getNumbersOfTheNumber(number);
        for(int i = 0; i < arrayNumbers.size(); i++){
            sum += Math.pow(arrayNumbers.get(i),getCountsOfDigits(number));
        }
        return sum == number;
    }

    public void findingArmstrongNumbers(){
        armstrongNumbers = new ArrayList<>();
        for(int i = 1; i <= k; i++){
            if(armstrongNumberCondition(i)){
                armstrongNumbers.add(i);
            }
        }
    }

    public int getCountsOfDigits(int number){
        int count = 0;
        while (number != 0){
            count++;
            number /= 10;
        }
        return count;
    }
    public ArrayList<Integer> getNumbersOfTheNumber(int number){
        ArrayList<Integer> arrayNumbers = new ArrayList<>();
        final int base = 10;
        while (number != 0){
            arrayNumbers.add(number%base);
            number /= base;
        }
        return arrayNumbers;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[1;").append(k).append("]\n");
        for(Integer array: armstrongNumbers){
            str.append(array).append(" ");
        }
        return str.toString();
    }
}
