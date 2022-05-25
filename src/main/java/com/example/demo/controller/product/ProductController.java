package com.example.demo.controller.product;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ProductController {

    @GetMapping("/addProduct")
    public String addProduct(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session != null)
            session.invalidate();
        return "redirect:/home";
    }

    @GetMapping("/productForm")
    public String productForm() {
        return "productForm";
    }

    @GetMapping("/editProduct")
    public String editProduct() {
        return "editProduct";
    }



}
