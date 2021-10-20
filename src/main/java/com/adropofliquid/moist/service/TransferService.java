package com.adropofliquid.moist.service;


import com.adropofliquid.moist.model.Account;
import com.adropofliquid.moist.model.Transfer;
import com.adropofliquid.moist.model.Users;
import com.adropofliquid.moist.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserService userService;

    public Account getAccount(String username){
        Users user = userService.getUser(username);
        return accountRepository.findByUserId(user.getId());
    }

    public void makeTransfer(String username, Transfer transfer){
        // TODO check if account has enough balance

        Account fromAccount = accountRepository.findByUserId(userService.getUser(username).getId());
        Account toAccount = accountRepository.findByUserId(userService.getUser(transfer.getRecipient()).getId());

        fromAccount.setBalance(fromAccount.getBalance() - transfer.getAmount());
        toAccount.setBalance(toAccount.getBalance() + transfer.getAmount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
