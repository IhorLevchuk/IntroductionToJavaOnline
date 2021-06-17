package by.epam.introduction_to_java.unit01;
public class Task3_3 {
    private int sum;
    public Task3_3(){
        System.out.println("The sum of the squares of the first hundred numbers is:");
        summation();
    }

    public void summation(){
        setSum(0);
        for(int i = 1; i <= 100; i++){
            setSum((int) (getSum()+Math.pow(i,2)));
        }
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
