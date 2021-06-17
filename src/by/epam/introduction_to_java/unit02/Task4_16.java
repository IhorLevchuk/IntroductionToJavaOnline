package by.epam.introduction_to_java.unit02;
import java.util.ArrayList;

public class Task4_16 {
    private final int n;
    private int sum;
    private int quantityEvenInSum;
    public Task4_16(int n){
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
    private int findingNumberOfEven(ArrayList<Integer> array){
        int quantityEven = 0;
        for (Integer integer : array) {
            if (integer % 2 == 0) {
                quantityEven++;
            }
        }
        return quantityEven;
    }
    public void findingSumAndQuantity(){
        for(int i = (int) Math.pow(10,n-1); i < Math.pow(10,n); i++){
            if(findingNumberOfEven(getNumbersOfTheNumber(i)) == 0){
                sum += i;
            }
        }
        quantityEvenInSum = findingNumberOfEven(getNumbersOfTheNumber(sum));
    }


    @Override
    public String toString(){
        return "n = " + n + "\n" + "Sum = " + sum + "\n" + "Quantity even in sum " + quantityEvenInSum;
    }
}
