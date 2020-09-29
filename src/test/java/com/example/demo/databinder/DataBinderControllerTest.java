package com.example.demo.databinder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class DataBinderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void stringToEnumConverterTest() throws Exception {

        mockMvc.perform(
                get("/databinder/converter?modes=BETA")
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.body").value("BETA"));
    }

    @Test
    void stringToFoo() throws Exception {
        String id = "1";

        mockMvc.perform(
            get("/databinder/foo?id=" + id)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.body").value("this entity is Foo(id=1)"));
        ;
    }

    @Test
    void stringToBar() throws Exception {
        String id = "3";

        mockMvc.perform(
            get("/databinder/bar?id=" + id)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.body").value("this entity is Bar(id=3)"));
    }

}