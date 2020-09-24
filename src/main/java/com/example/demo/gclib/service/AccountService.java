package com.example.demo.gclib.service;

import com.example.demo.gclib.domain.Account;
import com.example.demo.gclib.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;


    @Transactional
    public void save(Account account) {
        log.info("============== accountService save");

        accountRepository.save(account);

    }

    public String getHelloMessage(){
        return "hello";
    }
}
