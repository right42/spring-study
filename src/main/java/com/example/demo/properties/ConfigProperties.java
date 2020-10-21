package com.example.demo.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {

    private String host;

    private int port;

    private String from;

}
