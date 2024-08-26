
package com.micro.online.serviceimpl;

import com.micro.online.model.Account;
import com.micro.online.repository.AccountRepo;
import com.micro.online.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Account createAccount(Account account) {
        return accountRepo.createAccount(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepo.getAccountById(id);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepo.updateAccount(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepo.deleteAccount(id);
    }
}

