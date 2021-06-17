package by.epam.introduction_to_java.unit03;
public class Task2_9 {
    public int countLowerCase(String string){
        int lowerCase = 0;
        int upperCase;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) >= 'a' && string.charAt(i) <= 'z'){
                lowerCase++;
            }
        }
        return lowerCase;
    }
    public int countUpperCase(String string){
        int upperCase = 0;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                upperCase++;
            }
        }
        return upperCase;
    }

}
