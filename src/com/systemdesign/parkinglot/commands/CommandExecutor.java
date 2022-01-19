package com.systemdesign.parkinglot.commands;

import com.systemdesign.parkinglot.OutputPrinter;
import com.systemdesign.parkinglot.model.Command;
import com.systemdesign.parkinglot.services.ParkingLotService;

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
