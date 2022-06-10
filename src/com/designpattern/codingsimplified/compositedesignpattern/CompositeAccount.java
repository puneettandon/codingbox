package com.designpattern.codingsimplified.compositedesignpattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeAccount extends Account{

    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    @Override
    public float getBalance() {
        totalBalance = 0;
        for(Account f : accountList){
            totalBalance += f.getBalance();
        }
        return  totalBalance;
    }

    public void addAccount(Account account){
        accountList.add(account);
    }

    public void removeAccount(Account account){
        accountList.remove(account);
    }
}
