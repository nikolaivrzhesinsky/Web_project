package com.example.pharmacy_web.controllers;

import com.example.pharmacy_web.models.Product;
import com.example.pharmacy_web.models.User;
import com.example.pharmacy_web.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public String products(@RequestParam(name = "searchCity", required = false) String city,
                           @RequestParam(name="searchWord",required = false) String title, Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts(title, city));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model, Principal principal) {
        Product product = productService.getProductById(id);
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        model.addAttribute("authorProduct", product.getUser());
        return "product-info";
    }

    @GetMapping("/product/buy/{id}")
    public String productBuying(@PathVariable Long id, Model model, Principal principal){
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("user", productService.getUserByPrincipal(principal));

        return "/buyPage";
    }

//    @PostMapping("/product/create")
//    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
//                                @RequestParam("file3") MultipartFile file3, Product product, Principal principal) throws IOException {
//        productService.saveProduct(principal, product, file1, file2, file3);
//        return "redirect:/my/products";
//    }
//
//    @PostMapping("/product/delete/{id}")
//    public String deleteProduct(@PathVariable Long id, Principal principal) {
//        productService.deleteProduct(productService.getUserByPrincipal(principal), id);
//        return "redirect:/my/products";
//    }

//    @GetMapping("/my/products")
//    public String userProducts(Principal principal, Model model) {
//        User user = productService.getUserByPrincipal(principal);
//        model.addAttribute("user", user);
//        model.addAttribute("products", user.getProducts());
//        return "my-products";
//    }
}
