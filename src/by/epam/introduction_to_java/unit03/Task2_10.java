package by.epam.introduction_to_java.unit03;
public class Task2_10 {
    public int countSentences(String string){
        int quantity = 0;
        char[] marks = {'.','?','!'};
        for(int i = 0; i < string.length(); i++){
            for(char mark: marks){
                if(string.charAt(i) == mark){
                    quantity++;
                }
            }
        }
        return quantity;
    }

}
