package unit02;
public class Task4_7 {
    private int sumFactorial;
    private int calculatingFactorial(int number){
        int factorial = 1;
        for(int i = 1; i <= number; i++){
            factorial *= i;
        }
        return factorial;
    }
    public void summationFactorial(){
        int from = 1;
        int before = 9;
        for(int i = from; i <= before; i++){
            if(i%2 != 0){
                sumFactorial += calculatingFactorial(i);
            }
        }
    }

    public int getSumFactorial() {
        return sumFactorial;
    }
}
