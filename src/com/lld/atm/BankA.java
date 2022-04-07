package com.lld.atm;

public class BankA implements BankService{

    @Override
    public boolean isValidUser(String pin, CardInfo cardInfo) {
        return false;
    }

    @Override
    public Customer getCustomerDetails(CardInfo cardInfo) {
        return null;
    }

    @Override
    public TransactionDetail executeTransaction(Transaction transaction) {
        return null;
    }
}
