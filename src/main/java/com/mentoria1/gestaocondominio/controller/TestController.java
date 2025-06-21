package com.mentoria1.gestaocondominio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestController {
    @GetMapping("my-first-api")
    public String testController(){
        return "Hello world - my first GET";
    }
}
