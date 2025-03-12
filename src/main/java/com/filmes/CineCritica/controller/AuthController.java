package com.filmes.CineCritica.controller;

import com.filmes.CineCritica.entity.Role;
import com.filmes.CineCritica.entity.User;
import com.filmes.CineCritica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/login")
    public ModelAndView loginPage() {
       ModelAndView mv = new ModelAndView("login");
       return mv;
    }

}
