package by.epam.introduction_to_java.unit05.task01.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory implements Serializable {
    @Serial
    private static final long serialVersionUID = -7503475264814373156L;

    String directoryName;

    private List<? super File> files;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        files = new ArrayList<>();
    }

    public Directory() {
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public List<? super File> getFiles() {
        return files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(directoryName, directory.directoryName) && Objects.equals(files, directory.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directoryName, files);
    }

    @Override
    public String toString() {
        return "Directory{" +
                "directoryName='" + directoryName + '\'' +
                ", files=" + files +
                '}';
    }

}
