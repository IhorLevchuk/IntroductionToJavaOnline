package by.epam.introduction_to_java.unit06.task03.client.view.impl;


import by.epam.introduction_to_java.unit06.task03.client.view.OutPut;

public final class OutPutProvider {
    private static final OutPutProvider provider = new OutPutProvider();

    private final OutPut outPutOnConsole = new OutPytOnConsole();

    private OutPutProvider() {
    }

    public static OutPutProvider getProvider() {
        return provider;
    }

    public OutPut getOutPutOnConsole() {
        return outPutOnConsole;
    }
}
