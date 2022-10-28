package com.sts.Ecommerce.ECommerceApplicationBackend.controller;

import com.sts.Ecommerce.ECommerceApplicationBackend.entity.User;
import com.sts.Ecommerce.ECommerceApplicationBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

        @Autowired
        private UserService service;

        @PostConstruct
        public void initRolesAndUsers(){
            service.initRolesAndUsers();
        }

        @PostMapping("/registerNewUser")
        public User registerNewUser(@RequestBody User user){
            return service.registerNewUser(user);
        }

        @GetMapping("/forAdmin")
        @PreAuthorize("hasRole('Admin')")
        public String forAdmin(){
            return "This URL is only accessible for Admin users";
        }

        @GetMapping("/forUser")
        @PreAuthorize("hasRole('User')")
        public String forUser(){
            return "This URL is only accessible for users";
        }
}
