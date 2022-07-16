package com.designpattern.uditagarwal.commanddesignpattern;

import com.designpattern.uditagarwal.commanddesignpattern.other.Command;
import com.designpattern.uditagarwal.commanddesignpattern.other.Database;
import com.designpattern.uditagarwal.commanddesignpattern.other.RechargeProvider;

import java.util.List;

public class TestHelper {

    static public Database getTestDatabase(){
        return new Database();
    }

    static public RechargeProvider getTestRechargeProvider(){
        return  new RechargeProvider();
    }

    static public String getTestUser(){
        return "test-user";
    }

    static public Command getTestBalanceCommand(List params){
        return new Command("balance",params);
    }

    static public Command getTestRechargeCommand(List params){
        return new Command("recharge",params);
    }
}
