package com.platinosfood.backend.controllers;

import com.platinosfood.backend.entities.Product;
import com.platinosfood.backend.services.CategoryService;
import com.platinosfood.backend.services.ProductService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @GetMapping("/menu")
    public String goToMenu(Model model) {
        model.addAttribute("productList", productService.getProductsByCategoryId(1));
        return "menu";
    }

    @GetMapping("/menu-entradas")
    public String goToMenuEntradas(Model model, Authentication auth) {
        model.addAttribute("productList", productService.getProductsByCategoryId(2));
        return "menu-entradas";
    }

    @GetMapping("/menu-bebidas")
    public String goToMenuBebidas(Model model) {
        model.addAttribute("productList", productService.getProductsByCategoryId(3));
        return "menu-bebidas";
    }

    @GetMapping("/menu-postres")
    public String goToMenuPostres(Model model) {
        model.addAttribute("productList", productService.getProductsByCategoryId(4));
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

}
