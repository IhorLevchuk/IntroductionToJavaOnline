package by.epam.introduction_to_java.unit03;
public class Task2_2 {
    public String insertingAAfterB(String string){
        StringBuilder str = new StringBuilder(string);
        int i = 0;

        while (true){
            if(str.indexOf("a",i) != -1){
                int j = str.indexOf("a",i)+1;
                str.insert(j,"b");
                i = j;
            }else break;
        }
        return str.toString();
    }
}
