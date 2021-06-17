package by.epam.introduction_to_java.unit02;
public class Task1_9 {
    public void calculating() {
        int[] A = {4, 8, 9, 2, 2, 1, 4, 7, 2, 68, 2, 1, 1, 98, 54, 5, 1, 6, 35, 21, 7};
        int number = A[0];
        int quantityNumber = 1;
        int quantity;
        for (int i = 0; i < A.length; i++) {
            quantity = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == A[i]) {
                    quantity++;
                }
            }
            if(quantity > quantityNumber){
                number = A[i];
                quantityNumber = quantity;
            }
        }

        for (int i = 0; i < A.length; i++) {
            quantity = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == A[i]) {
                    quantity++;
                }
            }
            if(quantity == quantityNumber && number > A[i]){
                number = A[i];
                quantityNumber = quantity;
            }
        }

        System.out.println("number:" + number);
        System.out.println("quantity:" + quantityNumber);
    }
}
