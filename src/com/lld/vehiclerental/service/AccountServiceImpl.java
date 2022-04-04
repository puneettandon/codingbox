package com.lld.vehiclerental.service;

import com.lld.vehiclerental.exceptions.AccountDoesNotExistsException;
import com.lld.vehiclerental.model.account.Account;
import com.lld.vehiclerental.model.account.AccountType;
import com.lld.vehiclerental.repository.AccountRepository;
import com.lld.vehiclerental.repository.AccountRepositoryFactory;

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
