package com.micro.online.service;

import com.micro.online.model.Account;

public interface AccountService {
	
    Account createAccount(Account account);
    Account getAccountById(Long id);
    void updateAccount(Account account);
    void deleteAccount(Long id);
}

