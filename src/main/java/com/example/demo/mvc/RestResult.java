package com.example.demo.mvc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RestResult<T> {

    private final int status;

    private final T body;

}
