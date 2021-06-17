package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.controller.Command;
import by.epam.introduction_to_java.unit06.task01.controller.Controller;

public class ProfileController implements Controller {
    private CommandProvider provider = new CommandProvider();

    @Override
    public String doAction(String request) {
        String[] params = request.split("\\s+");
        String response;
        Command currentCommand = provider.getCommand(params[0]);
        response = currentCommand.execute(params);
        return response;
    }
}
