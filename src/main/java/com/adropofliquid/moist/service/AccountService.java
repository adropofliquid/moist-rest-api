package com.adropofliquid.moist.service;


import com.adropofliquid.moist.model.Account;
import com.adropofliquid.moist.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;



    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    public Account getAccount(int userid){
        return accountRepository.findByUserId(userid);
    }
}
