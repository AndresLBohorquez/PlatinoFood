package com.platinosfood.backend.controllers;

import com.platinosfood.backend.entities.Role;
import com.platinosfood.backend.entities.Usuario;
import com.platinosfood.backend.services.RoleService;
import com.platinosfood.backend.util.DateHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.platinosfood.backend.services.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(4);

    DateHour dh = new DateHour();

    @GetMapping("/users/user-list")
    public String goToUserListAdmin(Model model) {
        model.addAttribute("userList", userService.getUsers());
        return "/admin/users/user-list";
    }

    @GetMapping("/add-user")
    public String goToAddUserAdmin(Model model) {
        Usuario user = new Usuario();
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", user);
        return "/admin/users/add-user";
    }

    @GetMapping("/edit-user/{id}")
    public String goToEditUserAdmin(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/admin/users/edit-user";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") Usuario user) {
        user.setRegisterDate(dh.date() + " " + dh.hour());
        user.setEnable(true);
        user.setUsername(user.getEmail());
        user.setPassword(ENCODER.encode(user.getPassword()));

        userService.addUser(user);
        return "redirect:/users/user-list";
    }

    @PostMapping("/user-list/{id}")
    public String editUser(@PathVariable int id, @ModelAttribute("user") Usuario user, Model model) {
        Usuario userSelect = userService.getUserById(id);
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

    @GetMapping("/sign-up")
    public String goToUserRegister(Model model) {
        Usuario user = new Usuario();
        model.addAttribute("user", user);
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String userRegister(@ModelAttribute("user") Usuario user) {
        try {
            user.setRegisterDate(dh.date() + " " + dh.hour());
            Role role = new Role();
            role.setId(2);
            user.setRole(role);
            user.setEnable(true);
            user.setUsername(user.getEmail());
            user.setPassword(ENCODER.encode(user.getPassword()));
            userService.addUser(user);
        } catch (Exception e) {
            System.out.println("com.platinosfood.backend.controllers.UserController.userRegister()" + e.getMessage());
        }
        return "redirect:/menu";
    }
}
