package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.model.Vehicle;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;

public class FreeingExecuter extends CommandExecuter {

    public FreeingExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        super(outputPrinter, parkingLotService);
    }
    @Override
    protected void executeCommand(Command command) {
        String slotNumber = command.getParams().get(0);
        parkingLotService.free(Integer.parseInt(slotNumber));
        outputPrinter.free(slotNumber);
    }
    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }
}
