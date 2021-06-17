package by.epam.introduction_to_java.unit03;
public class Task2_1 {
    public int findingTheMostGaps(String string){
        int maxQuantity = 0;
        int i = 0;
        int quantity;

        while (true){
            if(string.indexOf(" ",i) != -1){
                quantity = 1;
                int j = string.indexOf(" ",i);
                while (true){
                    if(string.indexOf(" ",j+1) == j+1){
                        i++;
                        j++;
                        quantity++;
                    }else {
                        i++;
                        break;
                    }
                }
            }else break;

            if(maxQuantity < quantity) {
                maxQuantity = quantity;
            }

        }
        return maxQuantity;
    }
}
