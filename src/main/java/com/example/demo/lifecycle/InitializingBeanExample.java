package com.example.demo.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("lifecycle")
public class InitializingBeanExample implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean ---- afterPropertiesSet");
    }
}
