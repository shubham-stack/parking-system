package com.shubhamrawat.parkingSystem.exception;

import com.shubhamrawat.parkingSystem.constants.ErrorConstants;

public class InvalidParameterException extends RuntimeException{
    public InvalidParameterException() {
        super(ErrorConstants.INVALID_PARAMETER);
    }
}
