package by.epam.introduction_to_java.unit03;
public class Task2_8 {
    public String findingTheLongestWord(String string){
        String[] words = string.split(" ");
        String longestWord = words[0];
        for(int i = 1; i< words.length; i++){
            if(longestWord.length() < words[i].length()){
                longestWord = words[i];
            }
        }
        return longestWord;
    }
}
