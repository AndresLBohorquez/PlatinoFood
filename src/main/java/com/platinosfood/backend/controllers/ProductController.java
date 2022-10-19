package com.platinosfood.backend.controllers;

import com.platinosfood.backend.entities.Article;
import com.platinosfood.backend.entities.Orden;
import com.platinosfood.backend.entities.OrderStatus;
import com.platinosfood.backend.entities.Product;
import com.platinosfood.backend.entities.Usuario;
import com.platinosfood.backend.services.CategoryService;
import com.platinosfood.backend.services.OrdenService;
import com.platinosfood.backend.services.ProductService;
import com.platinosfood.backend.services.UsuarioService;
import com.platinosfood.backend.util.CodeGenerator;
import com.platinosfood.backend.util.DateHour;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OrdenService ordenService;

    DateHour dh = new DateHour();
    CodeGenerator cg = new CodeGenerator();

    List<Article> articleList = new ArrayList<>();

    @GetMapping("/menu")
    public String goToMenu(Model model, Authentication auth) {
        if (auth != null) {
            model.addAttribute("usuLog", usuarioService.getUsuarioByUsername(auth.getName()));
        }
        model.addAttribute("productList", productService.getProductsByCategoryId(1));
        model.addAttribute("listaArticulos", articleList);
        return "menu";
    }

    @GetMapping("/menu-entradas")
    public String goToMenuEntradas(Model model, Authentication auth) {
        if (auth != null) {
            model.addAttribute("usuLog", usuarioService.getUsuarioByUsername(auth.getName()));
        }
        model.addAttribute("productList", productService.getProductsByCategoryId(2));
        model.addAttribute("listaArticulos", articleList);
        return "menu-entradas";
    }

    @GetMapping("/menu-bebidas")
    public String goToMenuBebidas(Model model, Authentication auth) {
        if (auth != null) {
            model.addAttribute("usuLog", usuarioService.getUsuarioByUsername(auth.getName()));
        }
        model.addAttribute("productList", productService.getProductsByCategoryId(3));
        model.addAttribute("listaArticulos", articleList);
        return "menu-bebidas";
    }

    @GetMapping("/menu-postres")
    public String goToMenuPostres(Model model, Authentication auth) {
        if (auth != null) {
            model.addAttribute("usuLog", usuarioService.getUsuarioByUsername(auth.getName()));
        }
        model.addAttribute("productList", productService.getProductsByCategoryId(4));
        model.addAttribute("listaArticulos", articleList);
        return "menu-postres";
    }

    @GetMapping("/products/products-list")
    public String goToProductsListAdmin(Model model) {
        model.addAttribute("productList", productService.getProducts());
        return "/admin/products/products-list";
    }

    @GetMapping("/add-products")
    public String goToAddProductsAdmin(Model model) {
        Product product = new Product();

        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("product", product);
        return "/admin/products/add-products";
    }

    @GetMapping("/edit-products/{id}")
    public String goToEditProductsAdmin(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.getCategories());
        model.addAttribute("product", productService.getProductById(id));
        return "/admin/products/edit-products";
    }

    @PostMapping("/products-list")
    public String addProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile imagen) {

        if (!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src//main//resources//static//assets/img");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                product.setImage(imagen.getOriginalFilename());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        productService.AddProduct(product);
        return "redirect:/products/products-list";
    }

    @PostMapping("/products-list/{id}")
    public String editProduct(@PathVariable int id, @ModelAttribute("product") Product product, Model model) {
        Product productSelect = productService.getProductById(id);
        productSelect.setId(id);
        productSelect.setName(product.getName());
        productSelect.setCategory(product.getCategory());
        productSelect.setDescription(product.getDescription());
        productSelect.setPrice(product.getPrice());
        productSelect.setQuantity(product.getQuantity());
        productService.editProduct(productSelect);
        return "redirect:/products/products-list";
    }

    @GetMapping("/products-list/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products/products-list";
    }

    @GetMapping("/user/carrito")
    public String goToCarrito(Model model) {
        model.addAttribute("listaArticulos", articleList);
        double total = 0;
        for (Article art : articleList) {
            total += art.getPrice();
        }
        model.addAttribute("total", total);
        return "user/carrito";
    }

    @GetMapping("/add-cart/{id}")
    public String goToCart(@PathVariable int id, Model model) {
        Article art = new Article();
        var product = productService.getProductById(id);
        art.setId(id);
        art.setName(product.getName());
        art.setDescription(product.getDescription());
        art.setImage(product.getImage());
        art.setPrice(product.getPrice());
        art.setQuantity(1);
        articleList.add(art);
        model.addAttribute("article", art);
        model.addAttribute("listaArticulos", articleList);
        return "/user/add-cart";
    }

    @GetMapping("/check")
    public String goToCheckOut(Model model) {
        return "/user/check";
    }

    @PostMapping("/check")
    public String createOrden(Orden orden, Model model, Authentication auth) {
        double total = 0;
        OrderStatus os = new OrderStatus();
        os.setId(1);
        Usuario us = usuarioService.getUsuarioByUsername(auth.getName());
        List<Product> prodList = new ArrayList<>();
        Product prod = new Product();
        for (Article art : articleList) {
            total += art.getPrice();
            prod.setDescription(art.getDescription());
            prod.setId(art.getId());
            prodList.add(prod);
        }
        orden.setOrderCode(cg.generateCode());
        orden.setTotal(total);
        orden.setOrderStatus(os);
        orden.setUser(us);
        orden.setOrderDate(dh.date() + " " + dh.hour());
        orden.setEnable(true);
        ordenService.addOrden(orden);
        model.addAttribute("orden", orden);
        model.addAttribute("usuario", us);
        articleList.clear();
        return "/user/check";
    }

    
    
}
