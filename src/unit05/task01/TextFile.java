package unit05.task01;

import java.util.Objects;

public class TextFile extends File{
    private Text text;

    public TextFile(Directory directory, String fileName) {
        super(directory, fileName);
        text = new  Text();
        super.getDirectory().addFile(this);
    }

    public void addText(String line){
        this.text.addText(line);
    }

    public void printOnConsole(){
        System.out.println(text.getText());
    }

    @Override
    public String toString() {
        return "TextFile: "+ super.getFileName() + "\n" +
                "Directory: " + super.getDirectory().directoryName + "\n" +
                "Text:\n" + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TextFile textFile = (TextFile) o;
        return Objects.equals(text, textFile.text);
    }

}
