package com.example.demo.gclib.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;
}
