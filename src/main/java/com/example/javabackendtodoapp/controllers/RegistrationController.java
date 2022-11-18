package com.example.javabackendtodoapp.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @GetMapping("/register")
    public String registration() {
        // var user = SecurityContextHolder.getContext().getAuthentication();
        // user.getAuthorities().forEach(System.out::println);
        return "it works";
    }
}
