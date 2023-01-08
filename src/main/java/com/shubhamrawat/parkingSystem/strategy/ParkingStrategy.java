package com.shubhamrawat.parkingSystem.strategy;

import com.shubhamrawat.parkingSystem.model.Slot;

import java.util.List;
import java.util.TreeSet;

public interface ParkingStrategy {
    Integer getNextSlotNumber();
    void addSlot(int slotNumber);

    void removeSlot(int slotNumber);
}
