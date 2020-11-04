package com.example.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class GreetingController {

    @RequestMapping("/")
    public String greeting() {
        return "greeting";
    }
}
