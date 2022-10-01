package com.platinosfood.backend.controllers;

import com.platinosfood.backend.entities.User;
import com.platinosfood.backend.services.RoleService;
import com.platinosfood.backend.services.UserService;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/users/user-list")
    public String goToUserListAdmin(Model model) {
        model.addAttribute("userList", userService.getUsers());
        return "/admin/users/user-list";
    }

    @GetMapping("/add-user")
    public String goToAddUserAdmin(Model model) {
        User user = new User();
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", user);
        return "/admin/users/add-user";
    }

    @GetMapping("/edit-user/{id}")
    public String goToEditUserAdmin(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/admin/users/edit-user";
    }

    @PostMapping("/user-list")
    public String addUser(@ModelAttribute("user") User user) {
        Date date = Calendar.getInstance().getTime();
        user.setRegisterDate(date);
        userService.addUser(user);
        return "redirect:/users/user-list";
    }

    @PostMapping("/user-list/{id}")
    public String editUser(@PathVariable int id, @ModelAttribute("user") User user, Model model) {
        User userSelect = userService.getUserById(id);
        userSelect.setId(user.getId());
        userSelect.setAddress(user.getAddress());
        userSelect.setEmail(user.getEmail());
        userSelect.setFirstName(user.getFirstName());
        userSelect.setLastName(user.getLastName());
        userSelect.setPassword(user.getPassword());
        userSelect.setPhone(user.getPhone());
        userSelect.setRole(user.getRole());
        userService.editUser(userSelect);
        return "redirect:/users/user-list";
    }

    @GetMapping("/user-list/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users/user-list";
    }
}
