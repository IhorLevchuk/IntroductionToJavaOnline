package by.epam.introduction_to_java.unit03;
public class Task1_4 {
    public int searchNumber(String string){
        int quantity = 0;

        int i = 0;
        while (i < string.length()){
            if(Character.isDigit(string.charAt(i))){
                for(int j = i; j < string.length(); j++){
                    if(Character.isDigit(string.charAt(j))){
                        i++;
                    } else break;
                }
                quantity++;
            } else i++;

        }
        return quantity;
    }
}
