package by.epam.introduction_to_java.unit05.task01.service;

import by.epam.introduction_to_java.unit05.task01.bean.Directory;
import by.epam.introduction_to_java.unit05.task01.bean.File;
import by.epam.introduction_to_java.unit05.task01.bean.TextFile;

public class DirectoryAction {
    public <T extends File> void addFile (Directory directory, T file){
        directory.getFiles().add(file);
    }

    public TextFile createTextFile(Directory directory, String fileName){
        TextFile textFile = new TextFile(directory, fileName);
        addFile(directory,textFile);
        return textFile;
    }

    public <T extends File> void removeFile (Directory directory, T file){
        for (int i = 0; i < directory.getFiles().size(); i++) {
            if(directory.getFiles().get(i).equals(file)) {
                directory.getFiles().remove(i);
            }
        }
    }
}
