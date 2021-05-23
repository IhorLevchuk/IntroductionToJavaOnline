package unit03;
public class Task2_7 {
    public String stringFormatting(String string){
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            boolean isChar = false;
            for(int j = 0; j < newString.length(); j++){
                if(newString.codePointAt(j) == string.charAt(i)){
                    isChar = true;
                    break;
                }
            }
            if(!isChar && !Character.isWhitespace(string.charAt(i))){
                newString.append(string.charAt(i));
            }
        }
        return newString.toString();
    }
}
