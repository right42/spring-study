package com.example.demo.gclib.service;

import com.example.demo.gclib.domain.Account;
import com.example.demo.gclib.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    private AccountService self;

    @Transactional
    public void save(Account account) {
        log.info("============== accountService save");

        System.out.println("save " + TransactionSynchronizationManager.getCurrentTransactionName());
        accountRepository.save(account);
    }


    @Transactional
    public void exceptionExe() {
        System.out.println("exceptionExe " + TransactionSynchronizationManager.getCurrentTransactionName());
        throw new RuntimeException("고의 exception");
    }

    public void test(){
        System.out.println("test " + TransactionSynchronizationManager.getCurrentTransactionName());

        self.save(Account.builder()
                .username("user")
                .password("1234")
                .build());

        self.exceptionExe();

    }
}
