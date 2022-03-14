package com.systemdesign.vehiclerental.service;

import com.systemdesign.vehiclerental.exceptions.AccountDoesNotExistsException;
import com.systemdesign.vehiclerental.model.account.Account;
import com.systemdesign.vehiclerental.model.account.AccountType;
import com.systemdesign.vehiclerental.repository.AccountRepository;
import com.systemdesign.vehiclerental.repository.AccountRepositoryFactory;

public class AccountServiceImpl implements AccountService{

    @Override
    public Account createAccount(Account account, AccountType accountType) {
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository(accountType);
        return accountRepository.createAccount(account);
    }

    @Override
    public void resetPassword(String userId, String password, AccountType accountType) throws AccountDoesNotExistsException {
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository(accountType);
        accountRepository.resetPassword(userId,password);
    }
}
