package by.epam.introduction_to_java.unit06.task03.client.view.impl;


import by.epam.introduction_to_java.unit06.task03.client.view.OutPut;

public class OutPytOnConsole implements OutPut {
    @Override
    public void doOutPyt(String string) {
        System.out.println(string);
    }
}
