package unit05.task01;

public class Task01 {
    public static void main(String[] args) {
        /*
        Создать объект класса Текстовый файл, используя классы Файл, Директория.
        Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
         */
        Directory directory = new Directory("task01");
        // создание файла в директории
        TextFile textFile = new TextFile(directory,"Test");
        // дополнение текста
        textFile.addText("This is a test file");
        File file = directory.createTextFile("Test5");
        // печать всех файлов, содержащихся в директории
        directory.printFiles();
        // переименование файла
        textFile.reName("Test1");
        directory.printFiles();
        // удаление файла
        directory.removeFile(file);
        directory.printFiles();



    }
}
