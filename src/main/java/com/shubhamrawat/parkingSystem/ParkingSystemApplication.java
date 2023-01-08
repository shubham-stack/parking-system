package com.shubhamrawat.parkingSystem;

import com.shubhamrawat.parkingSystem.commands.*;
import com.shubhamrawat.parkingSystem.constants.CommandConstants;
import com.shubhamrawat.parkingSystem.exception.InvalidParameterException;
import com.shubhamrawat.parkingSystem.mode.FileMode;
import com.shubhamrawat.parkingSystem.mode.InteractiveMode;
import com.shubhamrawat.parkingSystem.model.ParkingLot;
import com.shubhamrawat.parkingSystem.printer.OutputPrinter;
import com.shubhamrawat.parkingSystem.service.ParkingLotService;
import com.shubhamrawat.parkingSystem.strategy.DefaultParkingStrategy;
import com.shubhamrawat.parkingSystem.strategy.ParkingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class ParkingSystemApplication {

	public static void main(String[] args) throws IOException {
		settingContext(args);
		ConfigurableApplicationContext run = SpringApplication.run(ParkingSystemApplication.class, args);
		run.close();
	}

	public static void settingContext(String[] args) throws IOException {
		//beans creation
		int capacity = -1;
		OutputPrinter outputPrinter = new OutputPrinter();
		ParkingLot parkingLot = new ParkingLot(capacity);
		ParkingStrategy parkingStrategy = new DefaultParkingStrategy();
		ParkingLotService parkingLotService = new ParkingLotService(parkingLot, parkingStrategy);

		//adding supported commands
		Map<String, CommandExecuter> supportedCommands = new HashMap(){{
			put(CommandConstants.EXIT, new ExitExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.CREATE_PARKING_LOT, new CreateParkingLotExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.PARK_VEHICLE, new ParkingExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.FREE_SLOT, new FreeingExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.STATUS, new StatusExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.FETCH_REGIS_NO_BY_COLOR, new RegistrationNumberByColorExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.FETCH_SLOT_NO_BY_COLOR, new SlotNumberByColorExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.FETCH_SLOT_NO_BY_REGIS_NO, new SlotNumberByRegistrationNumberExecuter(outputPrinter, parkingLotService));
			put(CommandConstants.INVALID_COMMAND, new InvalidCommandExecuter(outputPrinter, parkingLotService));
		}};
		CommandExecuterFactory commandExecuterFactory = new CommandExecuterFactory(supportedCommands);

		//mode selection
		if(args.length == 0){
			new InteractiveMode(commandExecuterFactory, outputPrinter).process();
		} else if(args.length == 1){
			new FileMode(commandExecuterFactory, outputPrinter).process();
		} else {
			throw new InvalidParameterException();
		}
	}

}
