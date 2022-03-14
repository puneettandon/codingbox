package com.systemdesign.offerletterapproval;

public class CORMain {

    public static void main(String[] args) {
        ChainCreator chainCreator = new ChainCreator();
        Managers manager = chainCreator.createChain();
        manager.approveSalary(5000);
        manager.approveSalary(15000);
        manager.approveSalary(40000);
        manager.approveSalary(500000);
    }
}
