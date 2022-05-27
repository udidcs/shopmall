package com.example.demo.controller.product;

import com.example.demo.dto.Product;
import com.example.demo.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService service;

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

    @PostMapping("/upload")
    public String uploadProduct(@ModelAttribute Product pdt, @RequestParam MultipartFile pdtimg) {
        pdt.setFilename(pdtimg.getOriginalFilename());
        service.saveProduct(pdt, pdtimg);
        return "home";
    }

}
