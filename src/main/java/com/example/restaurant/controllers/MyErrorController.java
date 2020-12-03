package com.example.restaurant.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        GreetingController.checkAuth(model);
        GreetingController.checkAdmin(model);
        model.addAttribute("error", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
