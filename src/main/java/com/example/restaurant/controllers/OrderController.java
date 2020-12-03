package com.example.restaurant.controllers;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.User;
import com.example.restaurant.services.DishService;
import com.example.restaurant.services.OrderService;
import com.example.restaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    UserService userService;
    @Autowired
    DishService dishService;

    @Autowired
    public OrderController(OrderService orderService, DishService dishService) {
        this.orderService = orderService;
        this.dishService = dishService;
    }

    @RequestMapping("/showOrders")
    public String showOrders(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> currUser = userService.findUserByUsername(auth.getName());
        GreetingController.checkAdmin(model);

        List<Order> orders = orderService.findAllByIdUser(currUser.get().getId());
        for (Order order : orders) {
            order.setSumma(order.getDishes().stream()
                    .map(Dish::getPrice)
                    .reduce(0, Integer::sum));
        }
        model.addAttribute("orders",
                orderService.findAllByIdUser(currUser.get().getId()));

        return "showOrders";
    }

    @GetMapping("/makeOrder")
    public String makeOrderPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        GreetingController.checkAdmin(model);

        User user = userService.findUserByUsername(auth.getName()).get();
        orderService.save(new Order(user.getId(), new Date(Calendar.getInstance().getTime().getTime())));

        List<Dish> dishes = dishService.findAll();
        List<Dish> dishesInMenu = dishes.stream()
                .filter(Dish::isInMenu)
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("dishes", dishesInMenu);
        model.addAttribute("dishForm", new Dish());

        return "makeOrder";
    }

    @PostMapping("/addDishToOrder")
    public String makeOrderAddDish(@ModelAttribute Dish dishForm, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        GreetingController.checkAdmin(model);
        System.out.println(dishForm);

        User user = userService.findUserByUsername(auth.getName()).get();
        System.out.println(user);
        Order order = orderService.findLastByIdUser(user.getId());
        System.out.println(order);
        Dish dish = dishService.findFirstByDishName(dishForm.getDishName()).get();
        System.out.println(dish);
        System.out.println(orderService.addDishToOrder(order.getId(), dish.getId()));

        Order orderWithDish = orderService.findLastByIdUser(user.getId());
        orderWithDish.getDishes().add(dish);
        System.out.println(orderWithDish);
        orderWithDish.setSumma(orderWithDish.getDishes().stream()
                .map(Dish::getPrice)
                .reduce(0, Integer::sum));
        model.addAttribute("clientDishes", orderWithDish);

        List<Dish> dishes = dishService.findAll();
        List<Dish> dishesInMenu = dishes.stream()
                .filter(Dish::isInMenu)
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("dishes", dishesInMenu);

        return "makeOrder";
    }
}
