package by.epam.introduction_to_java.unit03;
public class Task2_5 {
    public int letterCountSearch(String string, String letter){
        int count = 0;
        int i = 0;
        while (true){
            if(string.indexOf(letter,i) != -1){
                count++;
                i = string.indexOf(letter,i)+1;
            }else break;
        }

        return count;
    }
}
