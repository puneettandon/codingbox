package com.systemdesign.vehiclerental.repository;

import com.systemdesign.vehiclerental.exceptions.AccountDoesNotExistsException;
import com.systemdesign.vehiclerental.model.account.Account;

public interface AccountRepository {

    Account createAccount(Account account);


    void resetPassword(String userId, String password) throws AccountDoesNotExistsException;
}
