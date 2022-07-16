package com.designpattern.uditagarwal.commanddesignpattern.gooddesign.executors;

import com.designpattern.uditagarwal.commanddesignpattern.other.Command;
import com.designpattern.uditagarwal.commanddesignpattern.other.Database;
import com.designpattern.uditagarwal.commanddesignpattern.other.RechargeProvider;

public class RechargeCommandExecutor extends CommandExecutor {

    RechargeProvider rechargeProvider;

    public RechargeCommandExecutor(Database database,RechargeProvider rechargeProvider){
        super(database);
        this.rechargeProvider = rechargeProvider;
    }

    @Override
    public Boolean isApplicable(Command command) {
        return command.getName().equalsIgnoreCase("recharge");
    }

    @Override
    protected Boolean isValid(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    protected String executeValidCommand(Command command) {
        String user = command.getParams().get(0);
        Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

        Integer userBalance = database.getUserBalance(user);
        if(userBalance < rechargeAmount){
            return "Not Sufficient Balance";
        }
        rechargeProvider.recharge(user,rechargeAmount);
        return "Recharge Done";
    }
}
