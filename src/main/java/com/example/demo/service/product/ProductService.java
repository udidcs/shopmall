package com.example.demo.service.product;

import com.example.demo.dto.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public void saveProduct(Product pdt, MultipartFile pdtimg) {

        try {
            pdtimg.transferTo(new File("C:\\images\\"+pdtimg.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repository.save(pdt);
    }





}
