package by.epam.introduction_to_java.unit02;
public class Task3_5 {
    public void calculating() {
        int n = 10;
        int[] A = new int[n];
        int buffer;


        for (int i = 0; i < A.length; i ++) {
            A[i] = (int) (Math.random()*15);
        }

        for (int k : A) {
            System.out.print(k + "\t");
        }
        System.out.println();


        for(int left = 1; left < A.length; left++){
            int insertIndex = binarySearch(A,left);
            for(int j = left; j > insertIndex; j--){
                buffer = A[j];
                A[j] = A[j-1];
                A[j-1] = buffer;
            }
        }

        for (int j : A) {
            System.out.print(j + "\t");
        }
        System.out.println();

    }

    private int binarySearch(int[] arr, int index) {
        int firstIndex = 0;
        int lastIndex = index - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[index] >= arr[index-1]) {
                return index;
            } else if(arr[index] >= arr[middleIndex] && arr[index] < arr[middleIndex + 1]){
                return middleIndex + 1;
            } else if (arr[middleIndex] > arr[index]) {
                lastIndex = middleIndex - 1;
            } else if (arr[middleIndex] <= arr[index]) {
                firstIndex = middleIndex + 1;
            }
        }
        return 0;
    }
}


