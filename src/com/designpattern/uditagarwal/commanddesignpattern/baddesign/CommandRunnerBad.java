package com.designpattern.uditagarwal.commanddesignpattern.baddesign;

import com.designpattern.uditagarwal.commanddesignpattern.other.Command;
import com.designpattern.uditagarwal.commanddesignpattern.other.Database;
import com.designpattern.uditagarwal.commanddesignpattern.other.RechargeProvider;

public class CommandRunnerBad {

    final Database database;
    final RechargeProvider rechargeProvider;

    public CommandRunnerBad(Database database, RechargeProvider rechargeProvider) {
        this.database = database;
        this.rechargeProvider = rechargeProvider;
    }

    public String runCommand(Command command){
        if("balance".equalsIgnoreCase(command.getName())){
            if(command.getParams().size() != 1){
                return "Invalid Command";
            }
            String user = command.getParams().get(0);
            return database.getUserBalance(user).toString();
        } else if ("recharge".equalsIgnoreCase(command.getName())) {
            if(command.getParams().size() != 2){
                return "Invalid Command";
            }
            String user = command.getParams().get(0);
            Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

            Integer userBalance = database.getUserBalance(user);
            if(userBalance < rechargeAmount){
                return "Not sufficient balance";
            }
            rechargeProvider.recharge(user,rechargeAmount);
            return "Recharge Done";
        }else if("addmondey".equalsIgnoreCase(command.getName())){
            return "";
        }else{
            return "Invalid command";
        }
    }
}
