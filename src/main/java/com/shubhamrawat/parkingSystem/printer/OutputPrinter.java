package com.shubhamrawat.parkingSystem.printer;

import com.shubhamrawat.parkingSystem.model.Slot;

import java.util.List;

public class OutputPrinter {
    private void print(String message){
        System.out.println(message);
    }
    private void printList(List<String> list) {
        list.stream().forEach(s -> print(s));
    }
    public void welcome(){
        print("Welcome to Parking Lot System!");
        print("EnterCommands:");
    }
    public void exit(){
        print("Thank You for using Parking Lot System");
    }
    public void parkingLotCreated(String capacity){
        print("Parking Lot with " + capacity + " slots capacity is created");
    }

    public void park(String regisNo, int slotNumber) {
        print("Park " + regisNo + " at Slot " + slotNumber);
    }

    public void free(String slotNumber) {
        print("Leave slot " + slotNumber);
    }

    public void parkingLotState(List<Slot> parkingData) {
        print("SlotNo VehicleNo VehicleColor");
        parkingData.stream()
            .forEach(slot -> print(slot.getSlotNumber() + " " + slot.getVehicle().getRegistrationNumber() +
                    " " + slot.getVehicle().getColor()));
    }

    public void regisNoByColor(List<String> colors) {
        printList(colors);
    }

    public void slotNoByColor(List<String> slots) {
        printList(slots);
    }
    public void slotNoByRegisNo(List<String> slots) {
        printList(slots);
    }

    public void invalidCommand() {
        print("This is invalid command!");
    }
}
