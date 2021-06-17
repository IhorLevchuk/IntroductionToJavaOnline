package by.epam.introduction_to_java.unit06.task03.server.controller.impl;



import by.epam.introduction_to_java.unit06.task03.server.controller.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("authorization", new AuthorizationCommand());
        commands.put("requestCase", new RequestCaseCommand());
        commands.put("createCase", new CreateCaseCommand());
        commands.put("changeCase", new ChangeCaseCommand());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);
    }
}
