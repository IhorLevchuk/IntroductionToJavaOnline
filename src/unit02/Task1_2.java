package unit02;
public class Task1_2 {
    public void calculating(){
        int[] A = {5,7,81,9,4,12,6,54,8,4,8,6,15,58};
        int Z = 20;
        int i = 0;
        for (int mas: A){
            if(mas > Z){
                mas = Z;
                i++;
            }
            System.out.print(mas + ",");
        }
        System.out.println();
        System.out.println(i);
    }

}
