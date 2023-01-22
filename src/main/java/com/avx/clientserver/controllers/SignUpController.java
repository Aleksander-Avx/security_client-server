package com.avx.clientserver.controllers;

import com.avx.clientserver.entity.UserEntity;
import com.avx.clientserver.repository.UserRepository;
import com.avx.clientserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp_page";
    }

    @PostMapping("/signUp")
    public String signUpUser (UserEntity user) {
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/signUp";
    }
}
