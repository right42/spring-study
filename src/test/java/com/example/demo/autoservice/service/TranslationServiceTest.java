package com.example.demo.autoservice.service;

import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

class TranslationServiceTest {

    @Test
    void loader(){
        ServiceLoader<TranslationService> loader = ServiceLoader.load(TranslationService.class);

        long count = StreamSupport.stream(loader.spliterator(), false).count();

        assertThat(count).isEqualTo(2);
    }

    @Test
    void loaderFilter(){
        ServiceLoader<TranslationService> loader = ServiceLoader.load(TranslationService.class);

        TranslationService googleService = StreamSupport.stream(loader.spliterator(), false)
                .filter(translationService -> translationService.getClass().getSimpleName().equalsIgnoreCase("GoogleTranslationServiceProvider"))
                .findFirst()
                .get();
        ;

        String message = "Hello";
        assertThat(googleService.translate(message, null, null)).isEqualTo(message + " (translated by Google)");
    }

}