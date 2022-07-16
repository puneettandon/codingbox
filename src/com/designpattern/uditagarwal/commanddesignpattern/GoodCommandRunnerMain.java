package com.designpattern.uditagarwal.commanddesignpattern;

import com.designpattern.uditagarwal.commanddesignpattern.gooddesign.CommandRunnerGood;
import com.designpattern.uditagarwal.commanddesignpattern.gooddesign.executors.BalanceCommandExecutor;
import com.designpattern.uditagarwal.commanddesignpattern.gooddesign.executors.CommandExecutor;
import com.designpattern.uditagarwal.commanddesignpattern.gooddesign.executors.RechargeCommandExecutor;
import com.google.common.collect.ImmutableList;

import static com.designpattern.uditagarwal.commanddesignpattern.TestHelper.getTestBalanceCommand;
import static com.designpattern.uditagarwal.commanddesignpattern.TestHelper.getTestUser;


public class GoodCommandRunnerMain {

    ImmutableList<CommandExecutor> commandExecutors = ImmutableList.of(
            new BalanceCommandExecutor(TestHelper.getTestDatabase()),
            new RechargeCommandExecutor(TestHelper.getTestDatabase(), TestHelper.getTestRechargeProvider())
    );

    CommandRunnerGood commandRunnerGood = new CommandRunnerGood(commandExecutors);

    String balance = commandRunnerGood.runCommand(getTestBalanceCommand(ImmutableList.of(getTestUser())));

}
