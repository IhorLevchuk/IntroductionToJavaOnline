
package by.epam.introduction_to_java.unit02;
public class Task4_5 {
    private final int[] mas;
    private final int n;
    private  int max;
    private int element;
    public Task4_5(int n){
        this.n = n;
        mas = createMas();
    }
    private int[] createMas(){
        int[] mas = new int[n];
        for(int i = 0; i < n; i++){
            mas[i] = (int)(Math.random()*15);
        }
        return mas;
    }
    private void findMax(){
        max = mas[0];
        for(int i = 1; i < mas.length; i++){
            if(mas[i] > max){
                max = mas[i];
            }
        }
    }
    public void findElement(){
        findMax();
        element = mas[0];
        for(int i = 1; i < mas.length; i++){
            if(mas[i] < max && mas[i] > element){
                element = mas[i];
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int ma : mas) {
            str.append(ma).append(" ");
        }
        str.append("\nFinding element: ").append(element);
        return str.toString();
    }
}
