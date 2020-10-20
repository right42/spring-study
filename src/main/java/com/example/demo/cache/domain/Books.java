package com.example.demo.cache.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class Books {

    private String title;

    private String isbn;
}
