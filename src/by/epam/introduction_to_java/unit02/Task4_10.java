package by.epam.introduction_to_java.unit02;
import java.util.ArrayList;

public class Task4_10 {
    private ArrayList<Integer> arrayNumbers;
    private final int number;
    public Task4_10(int number){
        this.number = number;
    }

    public void arrayFormation(){
        int number = this.number;
        arrayNumbers = new ArrayList<>();
        final int base = 10;
        while (number != 0){
            arrayNumbers.add(0,number%base);
            number /= base;
        }
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(number).append("\n");
        for(Integer array: arrayNumbers){
            str.append(array).append(" ");
        }
        return str.toString();
    }
}
