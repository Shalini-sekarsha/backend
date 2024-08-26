package com.micro.online.repository;




import com.micro.online.model.Account;

public interface AccountRepo {

    public Account createAccount(Account account);

    public Account getAccountById(Long id);

    public void updateAccount(Account account);

    public void deleteAccount(Long id);
}
