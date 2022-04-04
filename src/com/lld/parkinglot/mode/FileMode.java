package com.lld.parkinglot.mode;

import com.lld.parkinglot.OutputPrinter;
import com.lld.parkinglot.commands.CommandExecutorFactory;
import com.lld.parkinglot.model.Command;

import java.io.*;

public class FileMode extends Mode{

    String fileName;

    public FileMode(final CommandExecutorFactory commandExecutorFactory,
                    final OutputPrinter outputPrinter,
                    final String fileName){
        super(commandExecutorFactory,outputPrinter);
        this.fileName = fileName;
    }

    public void process() throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e){
            outputPrinter.invalidFile();
            return;
        }

        String input = reader.readLine();
        while(input != null){
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }
}
