package com.example.restaurant.controllers;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MenuController {
    private final DishService dishService;

    @Autowired
    public MenuController(DishService dishService) {
        this.dishService = dishService;
    }

    @RequestMapping("/menu")
    public String getMenu(Model model) {
        List<Dish> dishes = dishService.findAll();
        List<Dish> dishesInMenu = dishes.stream()
                .filter(Dish::isInMenu)
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("dishes", dishesInMenu);
        GreetingController.checkAuth(model);
        GreetingController.checkAdmin(model);
        return "menu";
    }

}
