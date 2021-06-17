package by.epam.introduction_to_java.unit06.task03.server.controller.impl;


import by.epam.introduction_to_java.unit06.task03.server.controller.Controller;

public final class ControllerProvider {
    private static ControllerProvider provider = new ControllerProvider();

    Controller archiveController = new ArchiveController();

    private ControllerProvider() {
    }

    public static ControllerProvider getProvider() {
        return provider;
    }

    public Controller getArchiveController() {
        return archiveController;
    }
}
