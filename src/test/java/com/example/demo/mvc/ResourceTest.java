package com.example.demo.mvc;

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
public class ResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void resource() throws Exception {
        mockMvc.perform(
            get("/test.html")
        )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.TEXT_HTML))
        ;
    }
}
