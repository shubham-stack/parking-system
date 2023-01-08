package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;

public class InvalidCommandExecuter extends CommandExecuter{

    public InvalidCommandExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        super(outputPrinter, parkingLotService);
    }
    @Override
    protected void executeCommand(Command command) {
        outputPrinter.invalidCommand();
    }
    @Override
    protected boolean isValid(Command command) {
        return true;
    }
}
