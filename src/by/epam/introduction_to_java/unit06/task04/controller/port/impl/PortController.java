package by.epam.introduction_to_java.unit06.task04.controller.port.impl;

import by.epam.introduction_to_java.unit06.task04.controller.port.PortCommand;
import by.epam.introduction_to_java.unit06.task04.controller.port.PortControllerI;
import by.epam.introduction_to_java.unit06.task04.controller.port.impl.CommandPortProvider;

public class PortController implements PortControllerI {
    private CommandPortProvider provider = new CommandPortProvider();
    @Override
    public Object doAction(Object... params) {
        PortCommand currentCommand = provider.getCommand((String)params[0]);
        return currentCommand.execute(params);
    }
}
