package unit03;
public class Task2_4 {
    public String wordCreation(String sourceWord, String requiredWord){
        String word = "";
        for( int i = 0; i < requiredWord.length(); i++){
            String letter = String.valueOf(requiredWord.charAt(i));
            if(sourceWord.contains(letter)){
                word += letter;
            }else {
                return "Missing letters";
            }
        }
        return word;
    }
}
