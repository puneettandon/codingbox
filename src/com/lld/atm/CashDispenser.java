package com.lld.atm;

import java.util.List;
import java.util.Map;

public class CashDispenser {

    Map<CashType, List<Cash>> cashAvailable;

    public void dispenseCash(int amount){
        System.out.println("Dispensing Cash: "+amount);
    }
}
