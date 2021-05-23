package unit05.task01;

import java.util.Objects;

public class File {
    private String fileName;
    private Directory directory;

    public File(Directory directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    public void reName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public Directory getDirectory() {
        return directory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(fileName, file.fileName) && Objects.equals(directory, file.directory);
    }

}
