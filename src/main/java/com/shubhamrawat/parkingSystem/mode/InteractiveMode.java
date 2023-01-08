package com.shubhamrawat.parkingSystem.mode;

import com.shubhamrawat.parkingSystem.commands.CommandExecuterFactory;
import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.commands.Command;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

    public InteractiveMode(CommandExecuterFactory commandExecuterFactory, OutputPrinter outputPrinter) {
        super(commandExecuterFactory, outputPrinter);
    }
    @Override
    public void process() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        outputPrinter.welcome();
        while(true){
            Command command = processCommand(reader.readLine());
            if(command == null) continue;
            commandExecuterFactory.getExecuter(command.getCommandName()).execute(command);
            if(command.getCommandName().equals(CommandConstants.EXIT)){
                break;
            }
        }
    }
}
