package by.epam.introduction_to_java.unit05.task01.view;

import by.epam.introduction_to_java.unit05.task01.bean.Directory;

public class DirectoryView {

    public void printFiles(Directory directory){
        StringBuilder allFiles = new StringBuilder();
        for (Object file: directory.getFiles()){
            allFiles.append("\n").append(file);
        }
        System.out.println(allFiles);
    }
}
