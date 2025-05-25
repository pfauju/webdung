package com.webdung.webdungapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Willkommen bei Webdung-dung-dung Sahurrrrrrr!";
    }
}
