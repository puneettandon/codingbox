package com.lld.parkinglot.commands;

import com.lld.parkinglot.OutputPrinter;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.model.ParkingLot;
import com.lld.parkinglot.model.parking.strategy.NaturalOrderParkingStrategy;
import com.lld.parkinglot.services.ParkingLotService;
import com.lld.parkinglot.validator.IntegerValidator;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor{

    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter){
        super(parkingLotService,outputPrinter);
    }

    protected String getCommandName(){
        return COMMAND_NAME;
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if(params.size() != 1){
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(Command command) {
        final  int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot,new NaturalOrderParkingStrategy());
        outputPrinter.printWithNewLine("Created a parking lot with "+parkingLot.getCapacity()+ " slots");
    }
}
