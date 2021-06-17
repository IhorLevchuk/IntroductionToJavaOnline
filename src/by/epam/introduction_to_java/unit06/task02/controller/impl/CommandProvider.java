package by.epam.introduction_to_java.unit06.task02.controller.impl;

import by.epam.introduction_to_java.unit06.task02.controller.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("getAllNotes", new GetAllNotesCommand());
        commands.put("addNote", new AddNoteCommand());
        commands.put("getNotesContainingWord", new GetNotesContainingWordCommand());
        commands.put("searchByTopic", new SearchByTopicCommand());
        commands.put("searchByDate", new SearchByDateCommand());
        commands.put("searchByEMail", new SearchByEMailCommand());
        commands.put("searchByText", new SearchByTextCommand());
        commands.put("searchByTopicAndDate", new SearchByTopicAndDateCommand());
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);
    }
}
