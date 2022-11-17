package com.example.javabackendtodoapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RegistrationController {

    @GetMapping("/register")
    public String registration() {
        return "it works";
    }
}
