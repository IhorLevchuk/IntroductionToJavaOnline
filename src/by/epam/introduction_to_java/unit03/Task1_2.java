package by.epam.introduction_to_java.unit03;
public class Task1_2 {
    public String replacementWorldOnLetter(String sourceString, String oldWord, String newWord){
        boolean conformity;
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < sourceString.length()){
            conformity = true;
            for(int j = 0; j < oldWord.length(); j++){
                if(sourceString.charAt(j+i) != oldWord.charAt(j) || i+Math.max(oldWord.length(),newWord.length()) > sourceString.length()){
                    conformity = false;
                    break;
                }
            }
            if(conformity){
                str.append(newWord);
                i += oldWord.length();
            } else {
                str.append(sourceString.charAt(i));
                i++;
            }
        }

        return str.toString();
    }
}
