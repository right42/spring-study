package com.example.demo.mvc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test/home")
    public Result home(@RequestHeader("X-Test-Header") String header){
        return new Result(200, header);
    }


    @GetMapping(value = "/test/foos", headers = {"X-Test-Header=test"})
    public Result foos(){
        return new Result(200, "X-Test-Header is test");
    }

    @GetMapping(value = "/test/foos", consumes = "application/json")
    public Result foosAcceptJson(){
        return new Result(200, "produces is application/json");
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result onBadRequest(){
        log.info("bad Request");
        return new Result(400, "Bad Request");
    }

    @Builder
    @AllArgsConstructor
    @Getter
    private static class Result{
        private int status;

        private String message;
    }
}
