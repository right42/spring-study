package com.example.demo.gclib.service;

import com.example.demo.gclib.domain.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    @Disabled
    public void saveTest(){
        Account account = Account.builder()
                            .username("test")
                            .password("1234")
                            .build();

        accountService.save(account);
    }


}