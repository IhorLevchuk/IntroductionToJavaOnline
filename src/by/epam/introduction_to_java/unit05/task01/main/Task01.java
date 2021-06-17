package by.epam.introduction_to_java.unit05.task01.main;

import by.epam.introduction_to_java.unit05.task01.bean.Directory;
import by.epam.introduction_to_java.unit05.task01.bean.File;
import by.epam.introduction_to_java.unit05.task01.service.DirectoryAction;
import by.epam.introduction_to_java.unit05.task01.view.DirectoryView;

public class Task01 {
    public static void main(String[] args) {
        /*
        Создать объект класса Текстовый файл, используя классы Файл, Директория.
        Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
         */
        DirectoryAction directoryAction = new DirectoryAction();
        DirectoryView directoryView = new DirectoryView();

        Directory directory = new Directory("task01");
        // создание файла в директории
        File textFile = directoryAction.createTextFile(directory,"Test");
        // дополнение текста
        textFile.add("This is a test file");
        File textFile1 = directoryAction.createTextFile(directory,"Test5");
        // печать всех файлов, содержащихся в директории
        directoryView.printFiles(directory);
        // переименование файла
        textFile.reName("Test1");
        directoryView.printFiles(directory);
        // удаление файла
        directoryAction.removeFile(directory,textFile1);
        directoryView.printFiles(directory);

    }
}
