package com.example.restaurant.controllers;

import com.example.restaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginuser")
    public String loginuser(@RequestParam String username, String password) {
        if (userService.findUserByUserLoginAndAndUserPassword(username, password)
                        .isPresent()) {
            return "main";
        } else {
            return "wrong_login";
        }
    }
}
