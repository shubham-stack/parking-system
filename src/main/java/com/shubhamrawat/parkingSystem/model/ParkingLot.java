package com.shubhamrawat.parkingSystem.model;


import com.shubhamrawat.parkingSystem.exception.InvalidSlotNumberException;
import com.shubhamrawat.parkingSystem.exception.LotFullException;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingLot {
    public static int CAPACITY;
    private int cap;
    private Map<Integer, Slot> slots;

    public ParkingLot(int capacity) {
        slots = new HashMap<>();
        CAPACITY = capacity;
        cap = 0;
    }
    public int getCapacity(){
        return CAPACITY;
    }

    public void park(Vehicle vehicle, Integer slotNumber) {
        if(cap >= CAPACITY){
            throw new LotFullException();
        }
        Slot slot = new Slot(slotNumber);
        slot.assignSlot(vehicle);
        slots.put(slotNumber, slot);
        cap++;
    }
    public List<Slot> getOccupiedSlots(){
        return slots.values().stream().filter(slot -> !slot.isAvailable()).collect(Collectors.toList());
    }

    public Slot getSlot(int slotNumber) {
        if(!slots.containsKey(slotNumber)){
            throw new InvalidSlotNumberException();
        }
        return slots.get(slotNumber);
    }

    public void free(int slotNumber) {
        Slot slot = getSlot(slotNumber);
        if(slot == null){
            throw new InvalidSlotNumberException();
        }
        slot.unAssignSlot();
        cap--;
    }

    public void addSlot(Slot slot) {

    }
}
