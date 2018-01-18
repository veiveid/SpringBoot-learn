package com.veiveid.SpringBootlearn.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThyController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://xxxxxyuyyyyy.com");
        return "index";
    }

    @RequestMapping("/hello")
    public String index() {
        return "hello";
    }
}