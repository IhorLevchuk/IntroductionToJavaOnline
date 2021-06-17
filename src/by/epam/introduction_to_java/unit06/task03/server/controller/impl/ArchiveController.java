package by.epam.introduction_to_java.unit06.task03.server.controller.impl;


import by.epam.introduction_to_java.unit06.task03.server.controller.Command;
import by.epam.introduction_to_java.unit06.task03.server.controller.Controller;

public class ArchiveController implements Controller {
    private CommandProvider provider = new CommandProvider();

    public String doAction(String request){
        String[] params = request.substring(1,request.length()-1).split("\\]\\[");
        String response;
        Command currentCommand = provider.getCommand(params[0]);
        response = currentCommand.execute(params);
        return response;
    }
}

