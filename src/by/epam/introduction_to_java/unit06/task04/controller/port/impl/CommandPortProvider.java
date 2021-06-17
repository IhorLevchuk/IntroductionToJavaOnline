package by.epam.introduction_to_java.unit06.task04.controller.port.impl;

import by.epam.introduction_to_java.unit06.task04.controller.port.PortCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandPortProvider {
    private Map<String, PortCommand> commands = new HashMap<>();

    public CommandPortProvider() {
        commands.put("dock", new DockCommand());
        commands.put("depart", new DepartCommand());
    }

    public PortCommand getCommand(String commandName){
        return commands.get(commandName);
    }
}
