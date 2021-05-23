package unit03;
public class Task1_5 {
    public String searchNumber(String string){
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < string.length()){
            if(Character.isWhitespace(string.charAt(i)) && i == 0){
                i++;
            } else if(Character.isWhitespace(string.charAt(i)) && i == string.length()-1){
                break;
            }

            str.append(string.charAt(i));
            if(Character.isWhitespace(string.charAt(i))){
                for(int j = i; j < string.length(); j++){
                    if(Character.isWhitespace(string.charAt(j))){
                        i++;
                    } else break;
                }
            } else i++;
        }
        return str.toString();
    }
}
