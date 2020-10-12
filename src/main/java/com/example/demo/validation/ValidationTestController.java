package com.example.demo.validation;

import com.example.demo.mvc.RestResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationTestController {

    @PostMapping("/valid/phone-number")
    public RestResult<String> phoneNumber(@Valid @RequestBody Account account) {

        return new RestResult<>(200, "success");
    }

}
