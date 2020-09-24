package com.example.demo.autoservice.service;

import com.google.auto.service.AutoService;

import java.util.Locale;

@AutoService(TranslationService.class)
public class BingTranslationServiceProvider implements TranslationService {

    @Override
    public String translate(String message, Locale from, Locale to) {
        return message + " (translated by Bing)";
    }
}
