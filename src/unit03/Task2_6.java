package unit03;
public class Task2_6 {
    public String doubleLetter(String string){
        StringBuilder doubleString = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            doubleString.append(string.charAt(i)).append(string.charAt(i));
        }
        return doubleString.toString();
    }
}
