package com.shubhamrawat.parkingSystem.model;

import lombok.Getter;

@Getter
public class Slot {
    private int slotNumber;
    private Vehicle vehicle;
    private boolean isAvailable;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        isAvailable = true;
    }
    public void assignSlot(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void unAssignSlot(){
        this.vehicle = null;
        this.isAvailable = true;
    }
}
