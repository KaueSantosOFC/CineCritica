package com.filmes.CineCritica.controller;

import com.filmes.CineCritica.entity.User;
import com.filmes.CineCritica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String registerPage() {
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        boolean userExists = userService.existsByUsername(user.getUsername());

        if (userExists) {
            model.addAttribute("error", "Usuário já existe!");
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/login?sucess=true";
    }
}
