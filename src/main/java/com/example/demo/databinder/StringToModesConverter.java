package com.example.demo.databinder;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToModesConverter implements Converter<String, Modes> {

    @Override
    public Modes convert(String source) {
        return Modes.valueOf(source);
    }
}
