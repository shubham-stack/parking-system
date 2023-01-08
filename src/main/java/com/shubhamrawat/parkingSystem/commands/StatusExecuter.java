package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.model.Slot;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;

import java.util.List;

public class StatusExecuter extends CommandExecuter {

    public StatusExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        super(outputPrinter, parkingLotService);
    }
    @Override
    protected void executeCommand(Command command) {
        List<Slot> parkingData = parkingLotService.getParkingData();
        outputPrinter.parkingLotState(parkingData);
    }
    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 0;
    }
}
