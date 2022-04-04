package com.lld.parkinglot.commands;

import com.lld.parkinglot.OutputPrinter;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.services.ParkingLotService;

public abstract class CommandExecutor {

    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

   /* public boolean commandValidate(Command command){
        if(!command.getCommandName().equals(getCommandName())){
            return false;
        }
        return validate(command);
    }*/

   // public abstract  String getCommandName();

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
