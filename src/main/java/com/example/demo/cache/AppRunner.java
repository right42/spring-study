package com.example.demo.cache;

import com.example.demo.cache.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final BooksRepository booksRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("fetching books....");
        log.info("ibsn-1234 -> {}", booksRepository.findByIsbn("1234"));
        log.info("ibsn-512 -> {}", booksRepository.findByIsbn("22222"));
        log.info("ibsn-12132 -> {}", booksRepository.findByIsbn("1234"));
        log.info("ibsn-44444 -> {}", booksRepository.findByIsbn("44444"));
        log.info("ibsn-55555 -> {}", booksRepository.findByIsbn("1234"));
    }
}
