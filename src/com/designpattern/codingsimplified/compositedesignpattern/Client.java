package com.designpattern.codingsimplified.compositedesignpattern;

public class Client {

    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(new SavingAccount("SA01",2000));
        compositeAccount.addAccount(new SavingAccount("SA02",5000));
        compositeAccount.addAccount(new DepositAccount("DA01",1000));
        compositeAccount.addAccount(new DepositAccount("DA02",4000));
        compositeAccount.addAccount(new DepositAccount("DA03",7000));
        compositeAccount.addAccount(new DepositAccount("DA04",3000));

        float totalBalance = compositeAccount.getBalance();
        System.out.println("Total Balance : "+totalBalance);
    }
}
