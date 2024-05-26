package com.ecommerce.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    UserService userService;

    @PostMapping("/users/check-email")
    public String checkExistingEmail(@Param("email") String email) {
        return userService.isExistEmail(email) ? "Existed" : "OK";
    }
}
