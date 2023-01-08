package com.shubhamrawat.parkingSystem.commands;

import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.model.Slot;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class SlotNumberByRegistrationNumberExecuter extends CommandExecuter {

    public SlotNumberByRegistrationNumberExecuter(OutputPrinter outputPrinter, ParkingLotService parkingLotService) {
        super(outputPrinter, parkingLotService);
    }
    @Override
    protected void executeCommand(Command command) {
        List<Slot> slots = parkingLotService.getSlotByRegistrationNumber(command.getParams().get(0));
        outputPrinter.slotNoByRegisNo(slots.stream()
                .map(slot -> slot.getSlotNumber())
                .map(integer -> Integer.toString(integer))
                .collect(Collectors.toList()));
    }
    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }
}
