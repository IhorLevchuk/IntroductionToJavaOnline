package by.epam.introduction_to_java.unit03;
public class Task2_3 {
    public boolean palindromInspection(String string){
        StringBuilder palindrom = new StringBuilder(string);
        palindrom.reverse();
        return palindrom.toString().equals(string);
    }
}
