package com.shubhamrawat.parkingSystem.service;

import com.shubhamrawat.parkingSystem.model.ParkingLot;
import com.shubhamrawat.parkingSystem.model.Slot;
import com.shubhamrawat.parkingSystem.model.Vehicle;
import com.shubhamrawat.parkingSystem.strategy.ParkingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public ParkingLotService(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
    }
    public void createParkingLot(int capacity){
        ParkingLot.CAPACITY = capacity; //vurnable
        for (int i = 1; i <= parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
            parkingLot.addSlot(new Slot(i));
        }
    }
    public int park(Vehicle vehicle){
        Integer nextSlotNumber = parkingStrategy.getNextSlotNumber();
        parkingLot.park(vehicle, nextSlotNumber);
        parkingStrategy.removeSlot(nextSlotNumber);
        return nextSlotNumber;
    }
    public void free(int slotNumber){
        parkingLot.free(slotNumber);
        parkingStrategy.addSlot(slotNumber);

    }
    public List<Slot> getParkingData(){
        return parkingLot.getOccupiedSlots();
    }
    public List<Vehicle> getVehicleByColor(String color){
        List<Slot> slots = parkingLot.getOccupiedSlots();
        return slots.stream()
            .filter(slot -> slot.getVehicle().getColor().toLowerCase().equals(color))
            .map(slot -> slot.getVehicle())
            .collect(Collectors.toList());
    }
    public List<Slot> getSlotByRegistrationNumber(String regisNumber){
        List<Slot> slots = parkingLot.getOccupiedSlots();
        return slots.stream()
            .filter(slot -> slot.getVehicle().getRegistrationNumber().equals(regisNumber))
            .collect(Collectors.toList());
    }
    public List<Slot> getSlotByColor(String color){
        List<Slot> slots = parkingLot.getOccupiedSlots();
        return slots.stream()
                .filter(slot -> slot.getVehicle().getColor().toLowerCase().equals(color))
                .collect(Collectors.toList());
    }
}
