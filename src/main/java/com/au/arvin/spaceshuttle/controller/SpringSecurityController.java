package com.au.arvin.spaceshuttle.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SpringSecurityController {
    @GetMapping("/")
    public String helloworld() {
        return "Hello World";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring";
    }
}
