package com.example.demo.gclib.service;

import com.example.demo.gclib.domain.Account;
import com.example.demo.gclib.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final PersonService personService;

    @Transactional
    public void save(Account account) {
        log.info("============== accountService save");

        System.out.println("1 " + TransactionSynchronizationManager.getCurrentTransactionName());
        testWithNew();

        accountRepository.save(account);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testWithNew() {
        System.out.println("2 : " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("test !!!!");

        test();
    }

    @Transactional
    public void test(){
        System.out.println("3 " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("test");

        throw new RuntimeException("고의 Runtime exception");
    }


    public String getHelloMessage(){
        return "hello";
    }
}
