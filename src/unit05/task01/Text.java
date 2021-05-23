package unit05.task01;

public class Text {
    private StringBuilder text;

    public Text() {
        text = new StringBuilder();
    }

    public void addText(String text){
        this.text.append(text).append("\n");
    }

    public StringBuilder getText() {
        return text;
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
