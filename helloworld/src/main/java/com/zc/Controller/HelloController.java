package com.zc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//  自动装配
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello,World";
    }
}
