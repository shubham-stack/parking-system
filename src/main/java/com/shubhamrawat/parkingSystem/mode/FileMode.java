package com.shubhamrawat.parkingSystem.mode;

import com.shubhamrawat.parkingSystem.commands.CommandExecuterFactory;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;

import java.io.IOException;

public class FileMode extends Mode{

    public FileMode(CommandExecuterFactory commandExecuterFactory, OutputPrinter outputPrinter) {
        super(commandExecuterFactory, outputPrinter);
    }
    @Override
    public void process() throws IOException {

    }
}
