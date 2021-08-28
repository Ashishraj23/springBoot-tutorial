package com.learn.Springboottutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping(value = "/")
    public String helloWorld(){
        return welcomeMessage;
    }
}
