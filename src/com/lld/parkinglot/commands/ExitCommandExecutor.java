package com.lld.parkinglot.commands;

import com.lld.parkinglot.OutputPrinter;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.services.ParkingLotService;

public class ExitCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(
            final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(final Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(final Command command) {
        outputPrinter.end();
    }
}
