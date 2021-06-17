package by.epam.introduction_to_java.unit05.task01.bean;

public abstract class File{
    private String fileName;
    private Directory directory;

    public File(Directory directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    public File() {
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public String getFileName() {
        return fileName;
    }

    public Directory getDirectory() {
        return directory;
    }

    public abstract void add(Object o);

    public void reName(String newName){
        setFileName(newName);

    }
}
