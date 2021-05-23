package unit05.task01;

import java.util.ArrayList;

public class Directory {
    String directoryName;
    private ArrayList<? super File> files;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        files = new ArrayList<>();
    }

    public <T extends File> void addFile (T file){
        files.add(file);
    }
    public TextFile createTextFile(String fileName){
        return new TextFile(this, fileName);
    }

    public <T extends File> void removeFile (T file){
        for (int i = 0; i < files.size(); i++) {
            if(files.get(i).equals(file)) {
                files.remove(i);
            }
        }
    }

    public void printFiles(){
        StringBuilder allFiles = new StringBuilder();
        for (Object file: files){
            allFiles.append("\n").append(file);
        }
        System.out.println(allFiles.toString());
    }
}
