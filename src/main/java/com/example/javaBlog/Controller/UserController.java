package com.example.javaBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaBlog.Model.Users;
import com.example.javaBlog.Service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {

        user.setPassword(encoder.encode(user.getPassword()));
        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {

        return userService.verify(user);

    }

}
