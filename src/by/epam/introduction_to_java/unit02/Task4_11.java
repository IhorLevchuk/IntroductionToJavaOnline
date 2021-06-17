package by.epam.introduction_to_java.unit02;
public class Task4_11 {
    private final int firstNumber, secondNumber;
    private int greatestNumber;

    public Task4_11(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getCountsOfDigits(int number){
        int count = 0;
        while (number != 0){
            count++;
            number /= 10;
        }
        return count;
    }

    public void comparisonOfNumbers(){
        int countOfFirstNumber = getCountsOfDigits(firstNumber);
        int countOfSecondNumber = getCountsOfDigits(secondNumber);
        if(countOfFirstNumber > countOfSecondNumber){
            greatestNumber = firstNumber;
        } else if(countOfFirstNumber == countOfSecondNumber){
            greatestNumber = 0;
        } else greatestNumber = secondNumber;
    }

    public String toString(){
        if(greatestNumber == 0){
            return firstNumber +" and "+ secondNumber+ " are equal";
        }
        return "More of "+firstNumber+" and "+secondNumber+" is "+ greatestNumber;
    }
}
