package com.platinosfood.backend.controllers;

import com.platinosfood.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("/admin")
    public String goToAdmin(Model model) {
        var quantity = productService.getProducts().size();
        model.addAttribute("quantity", quantity);
        return "/admin/index.html";
    }
}
