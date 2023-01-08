package com.shubhamrawat.parkingSystem.exception;

import com.shubhamrawat.parkingSystem.constants.ErrorConstants;

public class InvalidSlotNumberException extends RuntimeException{
    public InvalidSlotNumberException() {
        super(ErrorConstants.INVALID_SLOT_NUMBER);
    }
}
