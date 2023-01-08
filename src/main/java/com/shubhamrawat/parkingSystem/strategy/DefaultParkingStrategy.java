package com.shubhamrawat.parkingSystem.strategy;

import com.shubhamrawat.parkingSystem.model.Slot;

import java.util.TreeSet;

public class DefaultParkingStrategy implements ParkingStrategy{
    TreeSet<Integer> remainingSlotNumbers = new TreeSet<>();

    @Override
    public void addSlot(int slotNumber) {
        remainingSlotNumbers.add(slotNumber);
    }
    @Override
    public void removeSlot(int slotNumber) {
        remainingSlotNumbers.remove(slotNumber);
    }

    @Override
    public Integer getNextSlotNumber() {
        return remainingSlotNumbers.first();
    }
}
