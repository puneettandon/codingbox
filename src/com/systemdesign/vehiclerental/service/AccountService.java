package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.exceptions.AccountDoesNotExistsException;
import com.systemdesign.vehiclerental.model.account.Account;
import com.systemdesign.vehiclerental.model.account.AccountType;

public interface AccountService {

    Account createAccount(Account account, AccountType accountType);

    void resetPassword(String userId,String password,AccountType accountType) throws AccountDoesNotExistsException;
}
