package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.model.Slot;
import com.shubhamrawat.parkingSystem.model.Vehicle;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class RegistrationNumberByColorExecuter extends CommandExecuter {

    public RegistrationNumberByColorExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        super(outputPrinter, parkingLotService);
    }
    @Override
    protected void executeCommand(Command command) {
        List<Vehicle> vehicleByColor = parkingLotService.getVehicleByColor(command.getParams().get(0));
        outputPrinter.regisNoByColor(vehicleByColor.stream()
                .map(vehicle -> vehicle.getRegistrationNumber())
                .collect(Collectors.toList()));
    }
    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }
}
