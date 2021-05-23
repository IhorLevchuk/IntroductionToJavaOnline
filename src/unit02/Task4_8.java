package unit02;
public class Task4_8 {
    private int sum;
    private int[] mas;

    public void createMas(int size) {
        mas = new int[size];
        for (int i = 0; i < size; i++) {
            mas[i] = (int) (Math.random() * 15);
        }
    }
    public void findSum(int indexFirstElement){
        sum = 0;
        if (indexFirstElement > mas.length-3 || indexFirstElement < 0){
            System.out.println("Elements are out of bounds of the array");
        } else for(int i = indexFirstElement; i < indexFirstElement+3; i++){
            sum += mas[i];
        }
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int array: mas) {
            str.append(array).append(" ");
        }
        str.append("\n").append(sum);
        return str.toString();
    }
}
