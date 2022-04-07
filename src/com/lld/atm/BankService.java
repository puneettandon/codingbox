package com.lld.atm;

public interface BankService {

    boolean isValidUser(String pin,CardInfo cardInfo);

    Customer getCustomerDetails(CardInfo cardInfo);

    TransactionDetail executeTransaction(Transaction transaction);

}
