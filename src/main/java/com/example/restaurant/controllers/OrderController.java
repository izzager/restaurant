package com.example.restaurant.controllers;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.User;
import com.example.restaurant.services.OrderService;
import com.example.restaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/showOrders")
    public String showOrders(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> currUser = userService.findUserByUsername(auth.getName());
        if (currUser.isPresent()) {
            List<Order> orders = orderService.findAllByIdUser(currUser.get().getId());
            for (Order order : orders) {
                order.setSumma(order.getDishes().stream()
                                    .map(Dish::getPrice)
                                    .reduce(0, Integer::sum));
            }
            model.addAttribute("orders",
                    orderService.findAllByIdUser(currUser.get().getId()));
        } else {
            return "error";
        }

        return "showOrders";
    }
}
