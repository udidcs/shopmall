package com.example.demo.controller.product;

import com.example.demo.dto.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class ProductController {


    private final ProductRepository repository;

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

    @Transactional
    @PostMapping("/upload")
    public String uploadProduct(@ModelAttribute Product pdt, @RequestParam MultipartFile pdtimg) {
        pdt.setFilename(pdtimg.getOriginalFilename());
        try {
            pdtimg.transferTo(new File("C:\\Users\\udidcs\\Desktop\\demo\\src\\main\\resources\\static\\"+pdtimg.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repository.save(pdt);
        return "redirect:/home";
    }

}
