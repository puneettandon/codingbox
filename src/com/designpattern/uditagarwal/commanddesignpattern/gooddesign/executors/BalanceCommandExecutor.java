package com.designpattern.uditagarwal.commanddesignpattern.gooddesign.executors;

import com.designpattern.uditagarwal.commanddesignpattern.other.Command;
import com.designpattern.uditagarwal.commanddesignpattern.other.Database;

public class BalanceCommandExecutor extends  CommandExecutor{

    public static final String BALANCE = "balance";

    public BalanceCommandExecutor(Database database) {
        super(database);
    }

    @Override
    public Boolean isApplicable(Command command) {
        return command.getName().equalsIgnoreCase(BALANCE);
    }

    @Override
    protected Boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    protected String executeValidCommand(Command command) {
        String user = command.getParams().get(0);
        return database.getUserBalance(user).toString();
    }
}
