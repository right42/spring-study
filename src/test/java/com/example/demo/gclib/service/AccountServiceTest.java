package com.example.demo.gclib.service;

import com.example.demo.gclib.domain.Account;
import com.example.demo.gclib.domain.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;


    @Test
    @Disabled
    void saveTest(){
        Account account = Account.builder()
                            .username("test")
                            .password("1234")
                            .build();

        accountService.save(account);
    }

    @Test
    @Disabled
    @Rollback(value = false)
    void test(){

        assertThrows(RuntimeException.class, () -> {
            accountService.test();
        });

        Account account = accountRepository.findById(1L).get();

        assertThat(account).isNotNull();
    }

    @Test
    void mockingTest(){
        Account account = Account.builder()
                                    .id(1L)
                                    .password("1234")
                                    .username("username")
                                    .build();
        when(accountRepository.findAll())
                .thenReturn(Arrays.asList(account));


        List<Account> all = accountRepository.findAll();

        assertThat(all).isNotNull();
        assertThat(all.size()).isEqualTo(1);
        assertThat(all.get(0).getUsername()).isEqualTo(account.getUsername());
    }

}