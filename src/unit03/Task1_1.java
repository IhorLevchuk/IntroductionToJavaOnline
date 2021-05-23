package unit03;
public class Task1_1 {
    public String[] toSnakeCase(String[] args){
        String[] snakeCase = new String[args.length];
        for(int i = 0; i < args.length; i++){
            StringBuilder str = new StringBuilder();
            char[] arrayLetters = args[i].toCharArray();
            for( int j = 0; j < arrayLetters.length; j++){
                if(Character.isLowerCase(arrayLetters[j])){
                    str.append(arrayLetters[j]);
                } else {
                    str.append("_").append(Character.toLowerCase(arrayLetters[j]));
                }
            }
            snakeCase[i] = str.toString();
        }
        return snakeCase;
    }
}
