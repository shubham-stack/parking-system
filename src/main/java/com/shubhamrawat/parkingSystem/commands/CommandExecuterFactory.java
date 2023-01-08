package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandExecuterFactory {
    private Map<String, CommandExecuter> executers;
    public CommandExecuterFactory(Map<String, CommandExecuter> supportedCommands) {
        this.executers = supportedCommands;
    }

    public CommandExecuter getExecuter(String commandName){
        CommandExecuter commandExecuter = executers.get(commandName);
        if(commandExecuter == null){
            commandExecuter = executers.get(CommandConstants.INVALID_COMMAND);
        }
        return commandExecuter;
    }
}
