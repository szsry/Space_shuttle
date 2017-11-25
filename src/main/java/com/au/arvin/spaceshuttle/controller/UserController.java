package com.au.arvin.spaceshuttle.controller;


import com.au.arvin.spaceshuttle.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @GetMapping("/all")
    public List<User> all() {
        return Arrays.asList(new User("su", "password"), new User("Su", "Password"));
    }

    @GetMapping("/me")
    public Object me() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}