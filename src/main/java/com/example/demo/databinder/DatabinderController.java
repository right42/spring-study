package com.example.demo.databinder;

import com.example.demo.mvc.RestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabinderController {

    @GetMapping("/databinder/converter")
    public RestResult<Modes> stringToModes(@RequestParam("modes") Modes modes){
        return new RestResult<>(200, modes);
    }

    @GetMapping("/databinder/foo")
    public RestResult<String> stringToFoo(@RequestParam("id") Foo foo) {
        return new RestResult<>(200, foo.getMessage());
    }

    @GetMapping("/databinder/bar")
    public RestResult<String> stringToBar(@RequestParam("id") Bar bar) {
        return new RestResult<>(200, bar.getMessage());
    }
}
