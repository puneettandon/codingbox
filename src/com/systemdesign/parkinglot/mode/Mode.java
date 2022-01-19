package com.systemdesign.parkinglot.mode;

import com.systemdesign.parkinglot.OutputPrinter;
import com.systemdesign.parkinglot.commands.CommandExecutor;
import com.systemdesign.parkinglot.commands.CommandExecutorFactory;
import com.systemdesign.parkinglot.exceptions.InvalidcommandException;
import com.systemdesign.parkinglot.model.Command;

import java.io.IOException;

public abstract class Mode {

    private CommandExecutorFactory commandExecutorFactory;
    protected OutputPrinter outputPrinter;

    public Mode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    protected void processCommand(final Command command){
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if(commandExecutor.validate(command)){
            commandExecutor.execute(command);
        }else {
            throw new InvalidcommandException();
        }
    }

    public  abstract  void process() throws IOException;
}
