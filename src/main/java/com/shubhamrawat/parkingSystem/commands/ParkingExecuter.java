package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.model.Vehicle;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;

public class ParkingExecuter extends CommandExecuter {

    public ParkingExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        super(outputPrinter, parkingLotService);
    }
    @Override
    protected void executeCommand(Command command) {
        String regisNo = command.getParams().get(0);
        String color = command.getParams().get(1);
        int slotNumber = parkingLotService.park(new Vehicle(regisNo, color));
        outputPrinter.park(regisNo, slotNumber);
    }
    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 2;
    }
}
