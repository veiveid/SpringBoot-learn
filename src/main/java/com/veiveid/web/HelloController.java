package com.veiveid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping("/hello")
    public String index() {
        System.out.println(blogProperties.getName());
        return "Hello World";
    }
}