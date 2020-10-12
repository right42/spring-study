package com.example.demo.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {

    private String name;

    @PhoneNumberConstraint
    private String phoneNumber;
}
