package com.lld.vehiclerental.service;

import com.lld.vehiclerental.exceptions.AccountDoesNotExistsException;
import com.lld.vehiclerental.model.account.Account;
import com.lld.vehiclerental.model.account.AccountType;

public interface AccountService {

    Account createAccount(Account account, AccountType accountType);

    void resetPassword(String userId,String password,AccountType accountType) throws AccountDoesNotExistsException;
}
