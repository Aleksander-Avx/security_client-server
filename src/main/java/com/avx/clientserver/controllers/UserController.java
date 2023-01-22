package com.avx.clientserver.controllers;

import com.avx.clientserver.entity.UserEntity;
import com.avx.clientserver.repository.UserRepository;
import com.avx.clientserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUserPage(Model model) {
        List<UserEntity> users = userService.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }
}
