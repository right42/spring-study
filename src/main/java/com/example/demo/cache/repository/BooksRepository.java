package com.example.demo.cache.repository;

import com.example.demo.cache.domain.Books;

public interface BooksRepository {

    Books findByIsbn(String isbn);

}
