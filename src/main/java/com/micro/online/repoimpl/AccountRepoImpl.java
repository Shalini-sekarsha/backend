package com.micro.online.repoimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.micro.online.model.Account;
import com.micro.online.repository.AccountRepo;

@Repository
@Transactional
public class AccountRepoImpl implements AccountRepo{

    @Autowired
   private EntityManager entityManager;

    public Account createAccount(Account account) {
        entityManager.persist(account);
        return account;
    }

    public Account getAccountById(Long id) {
        return entityManager.find(Account.class, id);
    }

    public void updateAccount(Account account) {
        if (entityManager.contains(account)) {
            entityManager.merge(account);
        } else {
            throw new RuntimeException("Account does not exist");
        }
    }

    public void deleteAccount(Long id) {
        Account account = getAccountById(id);
        if (account != null) {
            entityManager.remove(account);
        } else {
            throw new RuntimeException("Account does not exist");
        }
    }
}

