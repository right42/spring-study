package com.example.demo.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class TestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void home() throws Exception {
        mockMvc.perform(
                get("/test/home")
                        .header("X-Test-Header", "home")
        )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("home"))
        ;
    }

    @Test
    void homeNoneHeader() throws Exception {
        mockMvc.perform(
                get("/test/home")
        )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Bad Request"))
        ;
    }

    @Test
    void foos() throws Exception {
        mockMvc.perform(
                get("/test/foos")
                        .header("X-Test-Header", "test")
        )
                .andExpect(status().isOk());
    }

    @Test
    void foosNoneHeader() throws Exception {
        mockMvc.perform(
                get("/test/foos")
        )
                .andExpect(status().isNotFound());
    }

    @Test
    void foosAcceptJson() throws Exception {
        mockMvc.perform(
                get("/test/foos")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    void foosAcceptJsonWithAppliationXml() throws Exception {
        mockMvc.perform(
                get("/test/foos")
                    .contentType(MediaType.APPLICATION_XML)
        )
        .andExpect(status().isNotFound());
    }

}