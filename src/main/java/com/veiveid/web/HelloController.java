package com.veiveid.web;

import com.veiveid.SpringBootlearn.exception.MyException;
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

    @RequestMapping("/hello2")
    public String errorPage() {
        throw new RuntimeException("抛出异常了");
    }

    @RequestMapping(value = "/hello3")
    public String errorJson() throws Exception{
        throw new MyException("发生错误");
    }
}