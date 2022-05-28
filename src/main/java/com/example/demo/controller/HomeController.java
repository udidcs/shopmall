package com.example.demo.controller;

import com.example.demo.dto.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ProductRepository repository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Product> products = repository.findAll();
        model.addAttribute("pdts", products);
        return "/home";
    }


}
