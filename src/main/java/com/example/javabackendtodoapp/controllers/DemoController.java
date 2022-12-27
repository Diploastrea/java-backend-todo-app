package com.example.javabackendtodoapp.controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DemoController {

    @GetMapping("/demo1")
    @PreAuthorize("hasAuthority('read')")
    public String demo1() {
        return "demo1";
    }

    @GetMapping("/demo2")
    @PreAuthorize("hasAnyAuthority('read', 'write')")
    public String demo2() {
        return "demo2";
    }

    @GetMapping("/demo3/{smth}")
    @PreAuthorize("""
        #something == authentication.name or
        hasAnyAuthority('read', 'write')
    """)
    public String demo3(@PathVariable("smth") String something) {
        var a = SecurityContextHolder.getContext().getAuthentication();
        return "demo3";
    }

    @GetMapping("/demo4")
    @PostAuthorize("returnObject == 'demo4'")
    public String demo4() {
        System.out.println("method executed");
        return "demo4";
    }

    @GetMapping("/demo5")
    @PreFilter("filterObject.contains('a')")
    public String demo5(@RequestBody List<String> values) {
        System.out.println(values);
        return "demo5";
    }

    @GetMapping("/demo6")
    @PostFilter("filterObject.contains('a')")
    public List<String> demo6() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("lemon");
        list.add("pineapple");
        return list;
    }
}
