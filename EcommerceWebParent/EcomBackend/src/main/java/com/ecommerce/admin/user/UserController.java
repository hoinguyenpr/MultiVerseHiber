package com.ecommerce.admin.user;

import com.common.entity.Role;
import com.common.entity.User;
import com.ecommerce.admin.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/users")
    public String listAllUser(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping(value = "/users/create")
    public String newUser(Model model) {
        User user = new User();
        List<Role> roleList = roleService.getAllRole();

        user.setEnabled(true);
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);

        return "user_form";
    }

    @PostMapping(value = "/users/save")
    public String saveUser(User user, Model model, RedirectAttributes redirectAttributes) {
        if (userService.isExistEmail(user.getEmail())) {
            model.addAttribute("emailExist", true);
            return "user_form";
        } else {
            userService.saveUser(user);
            redirectAttributes.addFlashAttribute("message", "The user has been saved successfully.");
            return "redirect:/users";
        }
    }
}