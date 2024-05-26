package com.ecommerce.admin.controller;

import com.ecommerce.admin.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    RoleService roleService;

    @GetMapping("/welcome")
    public String viewHomePage() {
        System.out.println("Hello World 123!");
        return "index";
    }

}
