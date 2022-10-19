package com.platinosfood.backend.controllers;

import com.platinosfood.backend.entities.Orden;
import com.platinosfood.backend.entities.Usuario;
import com.platinosfood.backend.services.OrdenService;
import com.platinosfood.backend.services.ProductService;
import com.platinosfood.backend.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/admin")
    public String goToAdmin(Model model, Authentication auth) {

        Usuario usuLog;
        try {
            if (auth != null) {
                usuLog = usuarioService.getUsuarioByUsername(auth.getName());
            } else {
                usuLog = new Usuario();
            }
            model.addAttribute("usuLog", usuLog);
        } catch (Exception e) {
            System.out.println("com.platinosfood.backend.controllers.UsuarioController.goToProfile()" + e.getMessage());
        }
        var quantity = productService.getProducts().size();
        var totalUsers = usuarioService.getUsers().size();
        List<Orden> ordenList = ordenService.getOrdenes();
        model.addAttribute("orderList", ordenList);
        double ingreso = 0;
        
        for (Orden orden : ordenList) {
            if (!orden.getOrderStatus().getName().equals("Cancelada")) {
                ingreso  += orden.getTotal();
            }
        }
        model.addAttribute("ingresos", ingreso);
        model.addAttribute("quantity", quantity);
        model.addAttribute("totalUsers", totalUsers);
        return "/admin/index.html";
    }

    @GetMapping("/reservations/reservations-list")
    public String goToReservationsListAdmin(Model model) {
        List<Orden> ordenList = ordenService.getOrdenes();
        model.addAttribute("orderList", ordenList);
        return "/admin/reservations/reservations-list";
    }
}
