package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.exception.InvalidCommandException;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;

public class CreateParkingLotExecuter extends CommandExecuter {

    public CreateParkingLotExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        super(outputPrinter, parkingLotService);
    }
    @Override
    protected void executeCommand(Command command) {
        parkingLotService.createParkingLot(Integer.parseInt(command.getParams().get(0)));
        outputPrinter.parkingLotCreated(command.getParams().get(0));
    }
    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }
}
