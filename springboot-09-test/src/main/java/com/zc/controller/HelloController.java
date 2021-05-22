package com.zc.controller;

import com.zc.service.AsyncService;
import com.zc.utils.SendMailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    AsyncService asyncService;
    @Autowired
    SendMailUtils sendMailUtils;

    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "hello";
    }

    @GetMapping("/")
    public void sendMail() {
        while (true) {
            sendMailUtils.EasyMail("","","");
        }
    }

}
