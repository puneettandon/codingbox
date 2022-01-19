package com.systemdesign.parkinglot.model;

import com.systemdesign.parkinglot.exceptions.InvalidcommandException;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Command {

    private static final String SPACE=" ";
    private String commandName;
    private List<String> params;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }

    public Command(final String inputLine) {
        List<String> tokensList = Arrays.stream(inputLine.trim().split(SPACE))
                                    .map(String:: trim)
                                    .filter(token -> (token.length()>0))
                                    .collect(Collectors.toList());

        if(tokensList.size() == 0){
            throw new InvalidcommandException();
        }
        commandName = tokensList.get(0).toLowerCase();
        tokensList.remove(0);
        params=tokensList;
    }
}
