package com.micro.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.micro.online.model.Account;
import com.micro.online.serviceimpl.AccountServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl asi;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return asi.createAccount(account);
    }
   

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return asi.getAccountById(id);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Account account) {
        account.setId(id);
        asi.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        asi.deleteAccount(id);
    }
}

