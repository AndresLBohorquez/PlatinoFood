package com.platinosfood.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlatinoFoodController {

    @GetMapping("/menu")
    public String goToMenu(Model model) {
        return "menu";
    }

    @GetMapping("/login")
    public String goToLogin(Model model) {
        return "login";
    }

    @GetMapping("/sign-up")
    public String goToSignUp(Model model) {
        return "sign-up";
    }

    @GetMapping("/terms")
    public String goToTerms(Model model) {
        return "terms";
    }

    @GetMapping("/policy")
    public String goToPolicy(Model model) {
        return "policy";
    }

    @GetMapping("/forget-password")
    public String goToForgetPassword(Model model) {
        return "forget-password";
    }

    @GetMapping("/menu-entradas")
    public String goToMenuEntradas(Model model) {
        return "menu-entradas";
    }

    @GetMapping("/menu-bebidas")
    public String goToMenuBebidas(Model model) {
        return "menu-bebidas";
    }

    @GetMapping("/menu-postres")
    public String goToMenuPostres(Model model) {
        return "menu-postres";
    }

    @GetMapping("/admin")
    public String goToAdmin(Model model) {
        return "/admin/index.html";
    }

    @GetMapping("/users/user-list")
    public String goToUserListAdmin(Model model) {
        return "/admin/users/user-list";
    }

    @GetMapping("/add-user")
    public String goToAddUserAdmin(Model model) {
        return "/admin/users/add-user";
    }

    @GetMapping("/edit-user")
    public String goToEditUserAdmin(Model model) {
        return "/admin/users/edit-user";
    }

    @GetMapping("/products/products-list")
    public String goToProductsListAdmin(Model model) {
        return "/admin/products/products-list";
    }

    @GetMapping("/add-products")
    public String goToAddProductsAdmin(Model model) {
        return "/admin/products/add-products";
    }

    @GetMapping("/edit-products")
    public String goToEditProductsAdmin(Model model) {
        return "/admin/products/edit-products";
    }

    @GetMapping("/reservations/reservations-list")
    public String goToReservationsListAdmin(Model model) {
        return "/admin/reservations/reservations-list";
    }

    @GetMapping("/user")
    public String goToUser(Model model) {
        return "user/profile";
    }

    @GetMapping("/user-reservations")
    public String goToUserReservations(Model model) {
        return "user/user-reservations";
    }
}
