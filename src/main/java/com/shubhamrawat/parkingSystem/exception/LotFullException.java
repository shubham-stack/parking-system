package com.shubhamrawat.parkingSystem.exception;

import com.shubhamrawat.parkingSystem.constants.ErrorConstants;

public class LotFullException extends RuntimeException{
    public LotFullException() {
        super(ErrorConstants.PARKING_LOT_FULL);
    }
}
