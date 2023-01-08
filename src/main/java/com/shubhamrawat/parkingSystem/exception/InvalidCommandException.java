package com.shubhamrawat.parkingSystem.exception;

import com.shubhamrawat.parkingSystem.constants.ErrorConstants;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException() {
        super(ErrorConstants.INVALID_COMMAND);
    }
}
