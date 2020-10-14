package com.example.demo.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@Profile("lifecycle")
public class PostConstructorExample {

    @PostConstruct
    public void init(){
        log.info("PostConstruct ----- init");
    }
}
