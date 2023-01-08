package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.exception.InvalidCommandException;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;
import lombok.Getter;

import java.security.PublicKey;

public abstract class CommandExecuter {
    protected OutputPrinter outputPrinter;
    protected ParkingLotService parkingLotService;

    public CommandExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        this.outputPrinter = outputPrinter;
        this.parkingLotService = parkingLotService;
    }

    public void execute(Command command){
        if(!isValid(command)){
            throw new InvalidCommandException();
        }
        executeCommand(command);
    }
    protected abstract void executeCommand(Command command);
    protected abstract boolean isValid(Command command);
}
