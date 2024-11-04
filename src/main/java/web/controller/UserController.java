package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import web.model.User;
import web.repositories.UserRep;
import web.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class UserController {

    private final UserRep userRep;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserRep userRep, UserServiceImpl userService) {
        this.userRep = userRep;
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userProfile(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName()); // Получите пользователя
        model.addAttribute("user", user); // Передайте его в модель
        return "user"; // Возвратим шаблон
    }
}