package unit02;
import java.util.ArrayList;

public class Task4_17 {
    private final int number;
    private int numberOfSubtractions;
    public Task4_17(int number){
        this.number = number;
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

    private int findingSum(ArrayList<Integer> array){
        int sum = 0;
        for(int i = 0; i < array.size(); i++){
            sum += array.get(i);
        }
        return sum;
    }
    public void findingTheNumberOfSubtractions(){
        int number = this.number;
        while (true){
            if (number != 0){
                number = number - findingSum(getNumbersOfTheNumber(number));
                numberOfSubtractions++;
            } else break;
        }

    }


    @Override
    public String toString(){
        return "n = " + number + "\n" + "The number of subtractions is " + numberOfSubtractions;
    }
}
