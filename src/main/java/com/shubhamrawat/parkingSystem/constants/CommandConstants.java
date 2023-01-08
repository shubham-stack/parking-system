package com.shubhamrawat.parkingSystem.constants;

public class CommandConstants {
    public static final String WELCOME = "welcome";
    public static final String EXIT = "exit";
    public static final String CREATE_PARKING_LOT = "create_parking_lot";
    public static final String PARK_VEHICLE = "park";
    public static final String FREE_SLOT = "free";
    public static final String STATUS = "status";
    public static final String FETCH_REGIS_NO_BY_COLOR = "fetch_registration_number_by_color";
    public static final String FETCH_SLOT_NO_BY_COLOR = "fetch_slot_number_by_color";
    public static final String FETCH_SLOT_NO_BY_REGIS_NO = "fetch_slot_number_by_regis_no";
    public static final Object INVALID_COMMAND = "invalid_command";

    private CommandConstants() {}
}
