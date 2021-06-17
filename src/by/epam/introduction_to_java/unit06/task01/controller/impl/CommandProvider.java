package by.epam.introduction_to_java.unit06.task01.controller.impl;

import by.epam.introduction_to_java.unit06.task01.controller.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("authorization", new AuthorizationCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("logOut", new LogOutCommand());
        commands.put("getMessages", new GetMessagesCommand());

        commands.put("searchByID", new SearchByIDCommand());
        commands.put("searchByName", new SearchByNameCommand());
        commands.put("cataloging", new CatalogingCommand());
        commands.put("addEBook", new AddEBookCommand());
        commands.put("addPaperBook", new AddPaperBookCommand());
        commands.put("proposalAddEBook", new ProposalAddEBookCommand());
        commands.put("proposalPaperBook", new ProposalPaperBookCommand());
        commands.put("removeBook", new RemoveBookCommand());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);
    }
}
