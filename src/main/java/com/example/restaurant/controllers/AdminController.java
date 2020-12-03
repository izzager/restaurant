package com.example.restaurant.controllers;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.Staff;
import com.example.restaurant.services.DishService;
import com.example.restaurant.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin")
public class AdminController {

    DishService dishService;
    StaffService staffService;

    @Autowired
    public AdminController(DishService dishService, StaffService staffService) {
        this.dishService = dishService;
        this.staffService = staffService;
    }

    @RequestMapping("/")
    public String mainAdmin(Model model) {
        GreetingController.checkAuth(model);
        GreetingController.checkAdmin(model);
        return "index";
    }

    @GetMapping("/editMenu")
    public String editMenu(Model model) {
        List<Dish> dishesInMenu = getDishesWithUncheck();
        model.addAttribute("dishes", dishesInMenu);
        model.addAttribute("dishForm", new Dish());
        return "editMenu";
    }

    @PostMapping("/editDishInMenu")
    public String editDishInMenu(@ModelAttribute Dish dishForm, Model model) {
        System.out.println(dishForm);
        dishService.save(dishForm);

        List<Dish> dishesInMenu = getDishesWithUncheck();
        System.out.println(dishesInMenu);
        model.addAttribute("dishes", dishesInMenu);
        return "editMenu";
    }

    private List<Dish> getDishesWithUncheck() {
        List<Dish> dishesInMenu = dishService.findAll().stream()
                .limit(20).collect(Collectors.toList());
        for (Dish dish : dishesInMenu) {
            if (!dish.isInMenu()) {
                dish.setChecked("unchecked");
            }
        }
        return dishesInMenu;
    }

    @GetMapping("/addDishToMenu")
    public String addDishToMenu(Model model) {
        model.addAttribute("dish", new Dish("name", "category", 0, true));
        model.addAttribute("dishForm", new Dish());
        return "addDishToMenu";
    }

    @PostMapping("/addDishToMenu")
    public String addedDishToMenu(@ModelAttribute Dish dishForm, Model model) {
        System.out.println(dishForm);
        dishService.save(dishForm);

        List<Dish> dishesInMenu = getDishesWithUncheck();
        System.out.println(dishesInMenu);
        model.addAttribute("dishes", dishesInMenu);
        return "editMenu";
    }

    private List<Staff> getStaffWithUncheck() {
        List<Staff> staff = staffService.findAll().stream()
                .skip(59900)
                .collect(Collectors.toList());
        for (Staff s : staff) {
            if (!s.isStatusStaff()) {
                s.setChecked("unchecked");
            }
        }
        return staff;
    }

    @GetMapping("/editStaff")
    public String editStaff(Model model) {
        List<Staff> staff = getStaffWithUncheck();
        model.addAttribute("staff", staff);
        model.addAttribute("staffForm", new Staff());
        return "editStaff";
    }

    @PostMapping("/editStaffInList")
    public String editStaffInList(@ModelAttribute Staff staffForm, Model model) {
        System.out.println(staffForm);
        staffService.save(staffForm);

        List<Staff> staff = getStaffWithUncheck();
        System.out.println(staff);
        model.addAttribute("staff", staff);
        return "editStaff";
    }

    @GetMapping("/addStaffToList")
    public String addStaff(Model model) {
        model.addAttribute("staff", new Staff("F", "I", "O", "Повар", 1234567, 1, true));
        model.addAttribute("staffForm", new Staff());
        return "addStaff";
    }

    @PostMapping("/addStaffInList")
    public String addStaffToList(@ModelAttribute Staff staffForm, Model model) {
        System.out.println(staffForm);
        staffService.save(staffForm);

        List<Staff> staff = getStaffWithUncheck();
        System.out.println(staff);
        model.addAttribute("staff", staff);
        return "editStaff";
    }
}
