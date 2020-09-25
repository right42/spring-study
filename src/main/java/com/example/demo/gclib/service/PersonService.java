package com.example.demo.gclib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class PersonService {

    public String getHelloMessage(){
        return "hello";
    }

    public String getByeMessage() {
        return "bye";
    }

    public int getAge(){
        return 22;
    }

    @Autowired
    Test test;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test() {
        System.out.println("2 : " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("test !!!!");

        test.test();
    }

    @Service
    public static class Test{
        @Transactional
        public void test(){
            System.out.println("3 " + TransactionSynchronizationManager.getCurrentTransactionName());
            System.out.println("test");
            throw new RuntimeException("고의 Runtime exception");
        }
    }
}
