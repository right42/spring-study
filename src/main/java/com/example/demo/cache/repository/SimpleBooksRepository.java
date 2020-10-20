package com.example.demo.cache.repository;

import com.example.demo.cache.domain.Books;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleBooksRepository implements BooksRepository {


    @Override
    @Cacheable("books")
    public Books findByIsbn(String isbn) {
        simulateSlowService();
        return new Books("test", isbn);
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }


}
