package com.lld.vehiclerental.repository;

import com.lld.vehiclerental.exceptions.AccountDoesNotExistsException;
import com.lld.vehiclerental.model.account.Account;

public interface AccountRepository {

    Account createAccount(Account account);


    void resetPassword(String userId, String password) throws AccountDoesNotExistsException;
}
