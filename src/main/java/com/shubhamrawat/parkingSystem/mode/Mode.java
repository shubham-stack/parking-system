package com.shubhamrawat.parkingSystem.mode;

import com.shubhamrawat.parkingSystem.commands.Command;
import com.shubhamrawat.parkingSystem.commands.CommandExecuterFactory;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class Mode {
    private static final String SPACE = " ";
    protected CommandExecuterFactory commandExecuterFactory;
    protected OutputPrinter outputPrinter;

    protected Command processCommand(String commandLine){
        List<String> commandData = Arrays.stream(commandLine.trim().split(SPACE))
                .map(s -> s.trim())
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());
        Command command = null;
        if(!commandData.isEmpty()){
            String commandName = commandData.get(0);
            commandData.remove(0);
            command = new Command(commandName,
                    commandData.stream().collect(Collectors.toList()));
        }
        return command;
    }
    public abstract void process() throws IOException;
}
