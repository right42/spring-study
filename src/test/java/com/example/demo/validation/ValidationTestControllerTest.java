package com.example.demo.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class ValidationTestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void phoneNumberValidSuccess() throws Exception {

        Account account = new Account("name", "01012342323");
        String body = accountToJson(account);

        mockMvc.perform(
                post("/valid/phone-number")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.body").value("success"));
        ;
    }

    @Test
    void phoneNumberValidFail() throws Exception {
        Account account = new Account("name", "abcd");
        String body = accountToJson(account);

        mockMvc.perform(
                post("/valid/phone-number")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body)
            )
            .andExpect(status().isBadRequest())
        ;
    }

    private String accountToJson(Account account) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(account);
    }

}