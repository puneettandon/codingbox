package com.designpattern.uditagarwal.commanddesignpattern;

import com.designpattern.uditagarwal.commanddesignpattern.baddesign.CommandRunnerBad;
import com.designpattern.uditagarwal.commanddesignpattern.other.Database;
import com.designpattern.uditagarwal.commanddesignpattern.other.RechargeProvider;
import com.google.common.collect.ImmutableList;

import static com.designpattern.uditagarwal.commanddesignpattern.TestHelper.getTestBalanceCommand;
import static com.designpattern.uditagarwal.commanddesignpattern.TestHelper.getTestUser;

public class BadCommandRunnerMain {

    public static void main(String[] args) {


        CommandRunnerBad commandRunnerBad = new CommandRunnerBad(new Database(), new RechargeProvider());

        String balance = commandRunnerBad.runCommand(getTestBalanceCommand(ImmutableList.of(getTestUser())));
    }
}
