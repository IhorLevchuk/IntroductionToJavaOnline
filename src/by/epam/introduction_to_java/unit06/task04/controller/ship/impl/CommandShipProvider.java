package by.epam.introduction_to_java.unit06.task04.controller.ship.impl;

import by.epam.introduction_to_java.unit06.task04.controller.ship.ShipCommand;
import by.epam.introduction_to_java.unit06.task04.enumeration.PurposeOfArrival;

import java.util.HashMap;
import java.util.Map;

public class CommandShipProvider {
    private Map<PurposeOfArrival, ShipCommand> commands = new HashMap<>();

    public CommandShipProvider() {
        commands.put(PurposeOfArrival.LOADING, new LoadingCommand());
        commands.put(PurposeOfArrival.UNLOADING, new UnLoadingCommand());
    }

    public ShipCommand getCommand(PurposeOfArrival commandName){
        return commands.get(commandName);
    }
}
