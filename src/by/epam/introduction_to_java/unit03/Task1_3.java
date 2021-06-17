package by.epam.introduction_to_java.unit03;
public class Task1_3 {
    public int searchDigit(String string){
        int quantity = 0;
        for(int i = 0; i < string.length(); i++){
            if(Character.isDigit(string.charAt(i))){
                quantity++;
            }
        }
        return quantity;
    }
}
