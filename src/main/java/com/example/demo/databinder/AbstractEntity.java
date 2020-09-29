package com.example.demo.databinder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AbstractEntity {

    private String id;

    protected abstract String getMessage();
}
